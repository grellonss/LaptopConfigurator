package org.example.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.LaptopComponentQueryService;
import org.example.ontology.OntologyLoader;
import org.example.ontology.SPARQLQueryExecutor;

import java.util.ArrayList;
import java.util.List;

public class LaptopConfiguratorApp extends Application {

    private Laptop laptop;
    private LaptopComponentQueryService queryService;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Laptop Configurator");

        // Step 1: Carica l'ontologia
        String ontologyFilePath = "LaptopConfigModellazione.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
            queryService = new LaptopComponentQueryService(queryExecutor);

            laptop = new Laptop("MyLaptop");

            // Crea l'interfaccia utente
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20, 20, 20, 20));
            layout.setStyle("-fx-background-color: #f0f0f0;"); // Colore di sfondo

            Label welcomeLabel = new Label("Benvenuto nel configuratore di laptop!");
            welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");


            // ComboBox per selezionare il componente da configurare
            ComboBox<String> componentSelector = new ComboBox<>();
            componentSelector.getItems().addAll("Sistema Audio", "Batteria", "Colore", "Componenti", "Sistema di Raffreddamento", "Periferiche", "Porte", "Sicurezza", "Garanzia");
            componentSelector.setPromptText("Scegli un componente da configurare");
            componentSelector.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;"); // Stile per la ComboBox

            // Bottone "Configura"
            Button configureButton = new Button("Configura");
            configureButton.setStyle(
                    "-fx-background-color: #4CAF50;" +  // Colore verde
                            "-fx-text-fill: white;" +           // Testo bianco
                            "-fx-font-size: 14px;" +            // Dimensione del font
                            "-fx-font-weight: bold;" +          // Grassetto
                            "-fx-border-radius: 5px;" +         // Bordo arrotondato
                            "-fx-background-radius: 5px;" +     // Sfondo arrotondato
                            "-fx-padding: 10 20 10 20;"         // Padding interno
            );

            // Bottone "Mostra Configurazione Finale"
            Button finalizeButton = new Button("Mostra Configurazione Finale");
            finalizeButton.setStyle(
                    "-fx-background-color: #2196F3;" +  // Colore blu
                            "-fx-text-fill: white;" +           // Testo bianco
                            "-fx-font-size: 14px;" +            // Dimensione del font
                            "-fx-font-weight: bold;" +          // Grassetto
                            "-fx-border-radius: 5px;" +         // Bordo arrotondato
                            "-fx-background-radius: 5px;" +     // Sfondo arrotondato
                            "-fx-padding: 10 20 10 20;"         // Padding interno
            );

            // Stile hover per i bottoni
            String buttonHoverStyle = "-fx-background-color: #555555; -fx-text-fill: white;";

            // Aggiunge l'effetto hover sui bottoni
            configureButton.setOnMouseEntered(e -> configureButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));
            configureButton.setOnMouseExited(e -> configureButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));

            finalizeButton.setOnMouseEntered(e -> finalizeButton.setStyle("-fx-background-color: #1976D2; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));
            finalizeButton.setOnMouseExited(e -> finalizeButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));

            // Aggiunge i comportamenti dei bottoni
            configureButton.setOnAction(e -> configureComponent(componentSelector.getValue()));
            finalizeButton.setOnAction(e -> displayFinalConfiguration());


            layout.getChildren().addAll(welcomeLabel, componentSelector, configureButton, finalizeButton);

            Scene scene = new Scene(layout, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.show();

        } else {
            showError("Errore nel caricamento dell'ontologia.");
        }
    }

    // Metodo per configurare il componente selezionato
    private void configureComponent(String selectedComponent) {
        if (selectedComponent == null) {
            showError("Per favore seleziona un componente.");
            return;
        }

        switch (selectedComponent) {
            case "Sistema Audio":
                configureAudioSystem();
                break;
            case "Batteria":
                configureBattery();
                break;
            case "Colore":
                configureColour();
                break;
            case "Componenti":
                configureComponents();
                break;
            case "Sistema di Raffreddamento":
                configureCoolingSystem();
                break;
            case "Periferiche":
                configurePeripherals();
                break;
            case "Porte":
                configurePorts();
                break;
            case "Sicurezza":
                configureSecurity();
                break;
            case "Garanzia":
                configureWarranty();
                break;
            default:
                showError("Opzione non valida.");
        }
    }

    private void configureAudioSystem() {
        List<AudioSystem> audioSystems = queryService.getAudioSystemComponents(laptop);
        if (audioSystems.isEmpty()) {
            showError("Nessun sistema audio trovato.");
            return;
        }

        ChoiceDialog<AudioSystem> audioDialog = new ChoiceDialog<>(audioSystems.get(0), audioSystems);
        audioDialog.setTitle("Configurazione Sistema Audio");
        audioDialog.setHeaderText("Seleziona un sistema audio");
        audioDialog.setContentText("Sistema Audio:");

        audioDialog.showAndWait().ifPresent(selectedAudioSystem -> {
            laptop.setAudioSystem(selectedAudioSystem);
            showSuccess("Hai aggiunto il sistema audio: " + selectedAudioSystem.getAudioSystemName());
        });
    }

    private void configureBattery() {
        List<Battery> batteries = queryService.getBatteryComponents(laptop);
        if (batteries.isEmpty()) {
            showError("Nessuna batteria trovata.");
            return;
        }

        ChoiceDialog<Battery> batteryDialog = new ChoiceDialog<>(batteries.get(0), batteries);
        batteryDialog.setTitle("Configurazione Batteria");
        batteryDialog.setHeaderText("Seleziona un sistema di batteria");
        batteryDialog.setContentText("Sistema Batteria:");

        batteryDialog.showAndWait().ifPresent(selectedbattery -> {
            laptop.setBattery(selectedbattery);
            showSuccess("Hai aggiunto il sistema di batteria: " + selectedbattery.getBatteryName());
        });
    }

    private void configureColour() {
        List<Colour> colours = queryService.getColourComponents(laptop);
        if (colours.isEmpty()) {
            showError("Nessun colore trovato.");
            return;
        }

        ChoiceDialog<Colour> colourDialog = new ChoiceDialog<>(colours.get(0), colours);
        colourDialog.setTitle("Configurazione Colore");
        colourDialog.setHeaderText("Seleziona un sistema di colore");
        colourDialog.setContentText("Sistema Colore:");

        colourDialog.showAndWait().ifPresent(selectedcolour -> {
            laptop.setColour(selectedcolour);
            showSuccess("Hai aggiunto il sistema di colore: " + selectedcolour.getColourName());
        });
    }

    private void configureComponents() {
        // Crea un menu per selezionare il tipo di componente da configurare
        List<String> componentOptions = new ArrayList<>();
        componentOptions.add("CPU");
        componentOptions.add("RAM");
        componentOptions.add("Display");
        componentOptions.add("Graphics Card");
        componentOptions.add("Sistema Operativo");
        componentOptions.add("Storage");

        ChoiceDialog<String> componentDialog = new ChoiceDialog<>(componentOptions.get(0), componentOptions);
        componentDialog.setTitle("Configurazione Componenti");
        componentDialog.setHeaderText("Seleziona il componente che vuoi configurare:");
        componentDialog.setContentText("Componente:");

        // Mostra il dialogo e agisci in base alla scelta
        componentDialog.showAndWait().ifPresent(selectedComponent -> {
            switch (selectedComponent) {
                case "CPU":
                    configureCPU();
                    break;
                case "RAM":
                    configureRAM();
                    break;
                case "Display":
                    configureDisplay();
                    break;
                case "Graphics Card":
                    configureGraphicsCard();
                    break;
                case "Sistema Operativo":
                    configureOperatingSystem();
                    break;
                case "Storage":
                    configureStorage();
                    break;
                default:
                    showError("Componente non valido.");
            }
        });
    }

        private void configureCPU() {
            List<CPU> cpuComponents = queryService.getCPUComponents(laptop);
            if (cpuComponents.isEmpty()) {
                showError("Nessuna CPU trovata.");
                return;
            }

            ChoiceDialog<CPU> cpuDialog = new ChoiceDialog<>(cpuComponents.get(0), cpuComponents);
            cpuDialog.setTitle("Configurazione CPU");
            cpuDialog.setHeaderText("Seleziona una CPU:");
            cpuDialog.setContentText("CPU:");

            cpuDialog.showAndWait().ifPresent(selectedCPU -> {
                laptop.addOrReplaceComponent(selectedCPU);
                showSuccess("Hai aggiunto la CPU: " + selectedCPU.getCPUName());
            });
        }

        private void configureRAM() {
            List<RAM> ramComponents = queryService.getRAMComponents(laptop);
            if (ramComponents.isEmpty()) {
                showError("Nessuna RAM trovata.");
                return;
            }

            ChoiceDialog<RAM> ramDialog = new ChoiceDialog<>(ramComponents.get(0), ramComponents);
            ramDialog.setTitle("Configurazione RAM");
            ramDialog.setHeaderText("Seleziona una RAM:");
            ramDialog.setContentText("RAM:");

            ramDialog.showAndWait().ifPresent(selectedRAM -> {
                laptop.addOrReplaceComponent(selectedRAM);
                showSuccess("Hai aggiunto la RAM: " + selectedRAM.getRamName() + " con capacita' " + selectedRAM.getRamSize());
            });
        }

        private void configureDisplay() {
            List<Display> displayComponents = queryService.getDisplayComponents(laptop);
            if (displayComponents.isEmpty()) {
                showError("Nessun display trovato.");
                return;
            }

            ChoiceDialog<Display> displayDialog = new ChoiceDialog<>(displayComponents.get(0), displayComponents);
            displayDialog.setTitle("Configurazione Display");
            displayDialog.setHeaderText("Seleziona un Display:");
            displayDialog.setContentText("Display:");

            displayDialog.showAndWait().ifPresent(selectedDisplay -> {
                laptop.addOrReplaceComponent(selectedDisplay);
                showSuccess("Hai aggiunto il display: " + selectedDisplay.getDisplayName() + " con risoluzione " + selectedDisplay.getDisplayResolution());
            });
        }

        private void configureGraphicsCard() {
            List<GraphicsCard> graphicsCardComponents = queryService.getGraphicsCardComponents(laptop);
            if (graphicsCardComponents.isEmpty()) {
                showError("Nessuna scheda grafica trovata.");
                return;
            }

            ChoiceDialog<GraphicsCard> graphicsCardDialog = new ChoiceDialog<>(graphicsCardComponents.get(0), graphicsCardComponents);
            graphicsCardDialog.setTitle("Configurazione Scheda Grafica");
            graphicsCardDialog.setHeaderText("Seleziona una scheda grafica:");
            graphicsCardDialog.setContentText("Scheda Grafica:");

            graphicsCardDialog.showAndWait().ifPresent(selectedGraphicsCard -> {
                laptop.addOrReplaceComponent(selectedGraphicsCard);
                showSuccess("Hai aggiunto la scheda grafica: " + selectedGraphicsCard.getGraphicCardName() + " con " + selectedGraphicsCard.getGraphicsMemory() + " di memoria.");
            });
        }

        private void configureOperatingSystem() {
            List<OperatingSystem> osComponents = queryService.getOperatingSystemComponents(laptop);
            if (osComponents.isEmpty()) {
                showError("Nessun sistema operativo trovato.");
                return;
            }

            ChoiceDialog<OperatingSystem> osDialog = new ChoiceDialog<>(osComponents.get(0), osComponents);
            osDialog.setTitle("Configurazione Sistema Operativo");
            osDialog.setHeaderText("Seleziona un Sistema Operativo:");
            osDialog.setContentText("Sistema Operativo:");

            osDialog.showAndWait().ifPresent(selectedOS -> {
                laptop.addOrReplaceComponent(selectedOS);
                showSuccess("Hai aggiunto il sistema operativo: " + selectedOS.getOSName() + " versione " + selectedOS.getOperatingSystemVersion());
            });
        }

        private void configureStorage() {
            List<Storage> storageComponents = queryService.getStorageComponents(laptop);
            if (storageComponents.isEmpty()) {
                showError("Nessun componente di storage trovato.");
                return;
            }

            ChoiceDialog<Storage> storageDialog = new ChoiceDialog<>(storageComponents.get(0), storageComponents);
            storageDialog.setTitle("Configurazione Storage");
            storageDialog.setHeaderText("Seleziona uno storage:");
            storageDialog.setContentText("Storage:");

            storageDialog.showAndWait().ifPresent(selectedStorage -> {
                laptop.addOrReplaceComponent(selectedStorage);
                showSuccess("Hai aggiunto lo storage: " + selectedStorage.getStorageName() + " con capacità " + selectedStorage.getStorageCapacity() + "GB.");
            });
        }

    private void configureCoolingSystem() {
        List<CoolingSystem> coolingSystems = queryService.getCoolingSystemComponents(laptop);
        if (coolingSystems.isEmpty()) {
            showError("Nessun sistema di raffreddamento trovato.");
            return;
        }

        ChoiceDialog<CoolingSystem> coolingDialog = new ChoiceDialog<>(coolingSystems.get(0), coolingSystems);
        coolingDialog.setTitle("Configurazione Sistema di Raffreddamento");
        coolingDialog.setHeaderText("Seleziona un sistema di raffreddamento");
        coolingDialog.setContentText("Sistema di Raffreddamento:");

        coolingDialog.showAndWait().ifPresent(selectedCoolingSystem -> {
            laptop.setCoolingSystem(selectedCoolingSystem);
            showSuccess("Hai aggiunto il sistema di raffreddamento: " + selectedCoolingSystem.getCoolingSystemName());
        });
    }

    private void configurePeripherals() {
        // Crea un menu per selezionare la periferica da configurare
        List<String> peripheralOptions = new ArrayList<>();
        peripheralOptions.add("Monitor Esterno");
        peripheralOptions.add("Speaker Esterno");
        peripheralOptions.add("Tastiera");
        peripheralOptions.add("Mouse");
        peripheralOptions.add("Webcam");

        ChoiceDialog<String> peripheralDialog = new ChoiceDialog<>(peripheralOptions.get(0), peripheralOptions);
        peripheralDialog.setTitle("Configurazione Periferiche");
        peripheralDialog.setHeaderText("Seleziona la periferica che vuoi configurare:");
        peripheralDialog.setContentText("Periferica:");

        // Mostra il dialogo e agisci in base alla scelta
        peripheralDialog.showAndWait().ifPresent(selectedPeripheral -> {
            switch (selectedPeripheral) {
                case "Monitor Esterno":
                    configureExternalMonitor();
                    break;
                case "Speaker Esterno":
                    configureExternalSpeaker();
                    break;
                case "Tastiera":
                    configureKeyboard();
                    break;
                case "Mouse":
                    configureMouse();
                    break;
                case "Webcam":
                    configureWebcam();
                    break;
                default:
                    showError("Periferica non valida.");
            }
        });
    }

        private void configureExternalMonitor() {
            List<ExternalMonitor> monitorComponents = queryService.getExternalMonitorComponents(laptop);
            if (monitorComponents.isEmpty()) {
                showError("Nessun monitor esterno trovato.");
                return;
            }

            ChoiceDialog<ExternalMonitor> monitorDialog = new ChoiceDialog<>(monitorComponents.get(0), monitorComponents);
            monitorDialog.setTitle("Configurazione Monitor Esterno");
            monitorDialog.setHeaderText("Seleziona un monitor esterno:");
            monitorDialog.setContentText("Monitor:");

            monitorDialog.showAndWait().ifPresent(selectedMonitor -> {
                laptop.addOrReplacePeripheral(selectedMonitor);
                showSuccess("Hai aggiunto il monitor esterno: " + selectedMonitor.getExMonitorName() + " con risoluzione " + selectedMonitor.getExternalDisplayResolution());
            });
        }

        private void configureExternalSpeaker() {
            List<ExternalSpeaker> speakerComponents = queryService.getExternalSpeakerComponents(laptop);
            if (speakerComponents.isEmpty()) {
                showError("Nessun speaker esterno trovato.");
                return;
            }

            ChoiceDialog<ExternalSpeaker> speakerDialog = new ChoiceDialog<>(speakerComponents.get(0), speakerComponents);
            speakerDialog.setTitle("Configurazione Speaker Esterno");
            speakerDialog.setHeaderText("Seleziona uno speaker esterno:");
            speakerDialog.setContentText("Speaker:");

            speakerDialog.showAndWait().ifPresent(selectedSpeaker -> {
                laptop.addOrReplacePeripheral(selectedSpeaker);
                showSuccess("Hai aggiunto lo speaker esterno: " + selectedSpeaker.getExSpeakerName() + " di tipo " + selectedSpeaker.getExternalAudioSystemType());
            });
        }

        private void configureKeyboard() {
            List<Keyboard> keyboardComponents = queryService.getKeyboardComponents(laptop);
            if (keyboardComponents.isEmpty()) {
                showError("Nessuna tastiera trovata.");
                return;
            }

            ChoiceDialog<Keyboard> keyboardDialog = new ChoiceDialog<>(keyboardComponents.get(0), keyboardComponents);
            keyboardDialog.setTitle("Configurazione Tastiera");
            keyboardDialog.setHeaderText("Seleziona una tastiera:");
            keyboardDialog.setContentText("Tastiera:");

            keyboardDialog.showAndWait().ifPresent(selectedKeyboard -> {
                laptop.addOrReplacePeripheral(selectedKeyboard);
                showSuccess("Hai aggiunto la tastiera: " + selectedKeyboard.getKeyboardName() + " con layout " + selectedKeyboard.getKeyboardLayout());
            });
        }

        private void configureMouse() {
            List<Mouse> mouseComponents = queryService.getMouseComponents(laptop);
            if (mouseComponents.isEmpty()) {
                showError("Nessun mouse trovato.");
                return;
            }

            ChoiceDialog<Mouse> mouseDialog = new ChoiceDialog<>(mouseComponents.get(0), mouseComponents);
            mouseDialog.setTitle("Configurazione Mouse");
            mouseDialog.setHeaderText("Seleziona un mouse:");
            mouseDialog.setContentText("Mouse:");

            mouseDialog.showAndWait().ifPresent(selectedMouse -> {
                laptop.addOrReplacePeripheral(selectedMouse);
                showSuccess("Hai aggiunto il mouse: " + selectedMouse.getMouseName() + " di tipo " + selectedMouse.getMouseType());
            });
        }

        private void configureWebcam() {
            List<Webcam> webcamComponents = queryService.getWebcamComponents(laptop);
            if (webcamComponents.isEmpty()) {
                showError("Nessuna webcam trovata.");
                return;
            }

            ChoiceDialog<Webcam> webcamDialog = new ChoiceDialog<>(webcamComponents.get(0), webcamComponents);
            webcamDialog.setTitle("Configurazione Webcam");
            webcamDialog.setHeaderText("Seleziona una webcam:");
            webcamDialog.setContentText("Webcam:");

            webcamDialog.showAndWait().ifPresent(selectedWebcam -> {
                laptop.addOrReplacePeripheral(selectedWebcam);
                showSuccess("Hai aggiunto la webcam: " + selectedWebcam.getWebcamName() + " con risoluzione " + selectedWebcam.getWebcamResolution());
            });
        }

    private void configurePorts() {
        // Crea un menu per selezionare la porta da configurare
        List<String> portOptions = new ArrayList<>();
        portOptions.add("Ethernet");
        portOptions.add("USB");
        portOptions.add("HDMI");

        ChoiceDialog<String> portDialog = new ChoiceDialog<>(portOptions.get(0), portOptions);
        portDialog.setTitle("Configurazione Porte");
        portDialog.setHeaderText("Seleziona il tipo di porta che vuoi configurare:");
        portDialog.setContentText("Porta:");

        // Mostra il dialogo e agisci in base alla scelta
        portDialog.showAndWait().ifPresent(selectedPort -> {
            switch (selectedPort) {
                case "Ethernet":
                    configureEthernet();
                    break;
                case "USB":
                    configureUSB();
                    break;
                case "HDMI":
                    configureHDMI();
                    break;
                default:
                    showError("Tipo di porta non valida.");
            }
        });
    }

        private void configureEthernet() {
            List<Ethernet> ethernetComponents = queryService.getEthernetComponents(laptop);
            if (ethernetComponents.isEmpty()) {
                showError("Nessuna porta Ethernet trovata.");
                return;
            }

            ChoiceDialog<Ethernet> ethernetDialog = new ChoiceDialog<>(ethernetComponents.get(0), ethernetComponents);
            ethernetDialog.setTitle("Configurazione Porta Ethernet");
            ethernetDialog.setHeaderText("Seleziona una porta Ethernet:");
            ethernetDialog.setContentText("Ethernet:");

            ethernetDialog.showAndWait().ifPresent(selectedEthernet -> {
                laptop.addOrReplacePort(selectedEthernet);
                showSuccess("Hai aggiunto la porta Ethernet: " + selectedEthernet.getEthernetName() + " con velocità " + selectedEthernet.getEthernetSpeed());
            });
        }

        private void configureUSB() {
            List<USB> usbComponents = queryService.getUSBComponents(laptop);
            if (usbComponents.isEmpty()) {
                showError("Nessuna porta USB trovata.");
                return;
            }

            ChoiceDialog<USB> usbDialog = new ChoiceDialog<>(usbComponents.get(0), usbComponents);
            usbDialog.setTitle("Configurazione Porta USB");
            usbDialog.setHeaderText("Seleziona una porta USB:");
            usbDialog.setContentText("USB:");

            usbDialog.showAndWait().ifPresent(selectedUSB -> {
                laptop.addOrReplacePort(selectedUSB);
                showSuccess("Hai aggiunto la porta USB: " + selectedUSB.getUSBName() + " con versione " + selectedUSB.getUSBVersion());
            });
        }

        private void configureHDMI() {
            List<HDMI> hdmiComponents = queryService.getHDMIComponents(laptop);
            if (hdmiComponents.isEmpty()) {
                showError("Nessuna porta HDMI trovata.");
                return;
            }

            ChoiceDialog<HDMI> hdmiDialog = new ChoiceDialog<>(hdmiComponents.get(0), hdmiComponents);
            hdmiDialog.setTitle("Configurazione Porta HDMI");
            hdmiDialog.setHeaderText("Seleziona una porta HDMI:");
            hdmiDialog.setContentText("HDMI:");

            hdmiDialog.showAndWait().ifPresent(selectedHDMI -> {
                laptop.addOrReplacePort(selectedHDMI);
                showSuccess("Hai aggiunto la porta HDMI: " + selectedHDMI.getHDMIName() + " con versione " + selectedHDMI.getHDMIVersion());
            });
        }

    private void configureSecurity() {
        // Crea un menu per selezionare la tipologia di sicurezza da configurare
        List<String> securityOptions = new ArrayList<>();
        securityOptions.add("Antivirus");
        securityOptions.add("Funzione di Protezione");

        ChoiceDialog<String> securityDialog = new ChoiceDialog<>(securityOptions.get(0), securityOptions);
        securityDialog.setTitle("Configurazione Sicurezza");
        securityDialog.setHeaderText("Seleziona il tipo di sicurezza che vuoi configurare:");
        securityDialog.setContentText("Sicurezza:");

        // Mostra il dialogo e agisci in base alla scelta
        securityDialog.showAndWait().ifPresent(selectedSecurity -> {
            switch (selectedSecurity) {
                case "Antivirus":
                    configureAntivirus();
                    break;
                case "Funzione di Protezione":
                    configureProtectionFeature();
                    break;
                default:
                    showError("Tipo di sicurezza non valida.");
            }
        });
    }

        private void configureAntivirus() {
            List<Antivirus> antivirusComponents = queryService.getAntivirusComponents(laptop);
            if (antivirusComponents.isEmpty()) {
                showError("Nessun antivirus trovato.");
                return;
            }

            ChoiceDialog<Antivirus> antivirusDialog = new ChoiceDialog<>(antivirusComponents.get(0), antivirusComponents);
            antivirusDialog.setTitle("Configurazione Antivirus");
            antivirusDialog.setHeaderText("Seleziona un antivirus:");
            antivirusDialog.setContentText("Antivirus:");

            antivirusDialog.showAndWait().ifPresent(selectedAntivirus -> {
                laptop.addOrReplaceSecurity(selectedAntivirus);
                showSuccess("Hai aggiunto l'antivirus: " + selectedAntivirus.getAntivirusName() + " con versione " + selectedAntivirus.getAntivirusVersion());
            });
        }

        private void configureProtectionFeature() {
            List<ProtectionFeature> protectionFeatureComponents = queryService.getProtectionFeatureComponents(laptop);
            if (protectionFeatureComponents.isEmpty()) {
                showError("Nessuna funzione di protezione trovata.");
                return;
            }

            ChoiceDialog<ProtectionFeature> protectionDialog = new ChoiceDialog<>(protectionFeatureComponents.get(0), protectionFeatureComponents);
            protectionDialog.setTitle("Configurazione Funzione di Protezione");
            protectionDialog.setHeaderText("Seleziona una funzione di protezione:");
            protectionDialog.setContentText("Funzione di Protezione:");

            protectionDialog.showAndWait().ifPresent(selectedProtectionFeature -> {
                laptop.addOrReplaceSecurity(selectedProtectionFeature);
                showSuccess("Hai aggiunto la funzione di protezione: " + selectedProtectionFeature.getProtectionFeatureName() + " di tipo " + selectedProtectionFeature.getTypeProtectionFeature());
            });
        }

    private void configureWarranty() {
        List<Warranty> warranties = queryService.getWarrantyComponents(laptop);
        if (warranties.isEmpty()) {
            showError("Nessuna garanzia trovata.");
            return;
        }

        ChoiceDialog<Warranty> warrantyDialog = new ChoiceDialog<>(warranties.get(0), warranties);
        warrantyDialog.setTitle("Configurazione Garanzia");
        warrantyDialog.setHeaderText("Seleziona una garanzia");
        warrantyDialog.setContentText("Garanzia:");

        warrantyDialog.showAndWait().ifPresent(selectedWarranty -> {
            laptop.setWarranty(selectedWarranty);
            showSuccess("Hai aggiunto la garanzia: " + selectedWarranty.getWarrantyName());
        });
    }

    private void displayFinalConfiguration() {
        VBox root = new VBox(10); // Layout verticale per le informazioni
        root.setAlignment(Pos.TOP_LEFT);

        String iconPath = "/icons/"; // Assicurati che le icone siano qui

        // Titolo Laptop
        Label laptopNameLabel = new Label("Nome del Laptop:");
        laptopNameLabel.setStyle("-fx-font-weight: bold;");
        Label laptopName = new Label(laptop.getLaptopName());

        root.getChildren().addAll(laptopNameLabel, laptopName);

        // Sistema Audio
        if (laptop.getAudioSystem() != null) {
            AudioSystem audioSystem = laptop.getAudioSystem();
            HBox audioBox = new HBox(10);
            ImageView audioIcon = loadIcon(iconPath + "audio.png");
            Label audioLabel = new Label("Sistema Audio:");
            audioLabel.setStyle("-fx-font-weight: bold;");
            Label audioDetails = new Label(audioSystem.getAudioSystemName() + " - Tipo: " + audioSystem.getAudioSystemType());

            audioBox.getChildren().addAll(audioIcon, audioLabel, audioDetails);
            root.getChildren().add(audioBox);
        }

        // Batteria
        if (laptop.getBattery() != null) {
            Battery battery = laptop.getBattery();
            HBox batteryBox = new HBox(10);
            ImageView batteryIcon = loadIcon(iconPath + "battery.png");
            Label batteryLabel = new Label("Batteria:");
            batteryLabel.setStyle("-fx-font-weight: bold;");
            Label batteryDetails = new Label(battery.getBatteryName() + " - Capacita': " + String.format("%.2f mAh", battery.getBatteryCapacity()));

            batteryBox.getChildren().addAll(batteryIcon, batteryLabel, batteryDetails);
            root.getChildren().add(batteryBox);
        }

        // Colore
        if (laptop.getColour() != null) {
            Colour colour = laptop.getColour();
            HBox colourBox = new HBox(10);
            ImageView colourIcon = loadIcon(iconPath + "colour.png");
            Label colourLabel = new Label("Colore:");
            colourLabel.setStyle("-fx-font-weight: bold;");
            Label colourDetails = new Label(colour.getColourName());

            colourBox.getChildren().addAll(colourIcon, colourLabel, colourDetails);
            root.getChildren().add(colourBox);
        }
        // Sistema di Raffreddamento
        if (laptop.getCoolingSystem() != null) {
            CoolingSystem coolingSystem = laptop.getCoolingSystem();
            HBox coolingBox = new HBox(10);
            ImageView coolingIcon = loadIcon(iconPath + "cooling.png");
            Label coolingLabel = new Label("Sistema di Raffreddamento:");
            coolingLabel.setStyle("-fx-font-weight: bold;");
            Label coolingDetails = new Label(coolingSystem.getCoolingSystemName() + " - Tipo: " + coolingSystem.getCoolingSystemType());

            coolingBox.getChildren().addAll(coolingIcon, coolingLabel, coolingDetails);
            root.getChildren().add(coolingBox);
        }

        // Garanzia
        if (laptop.getWarranty() != null) {
            Warranty warranty = laptop.getWarranty();
            HBox warrantyBox = new HBox(10);
            ImageView warrantyIcon = loadIcon(iconPath + "warranty.png");
            Label warrantyLabel = new Label("Garanzia:");
            warrantyLabel.setStyle("-fx-font-weight: bold;");
            Label warrantyDetails = new Label(warranty.getWarrantyName() + " - Durata: " + warranty.getWarrantyPeriod() + " anni");

            warrantyBox.getChildren().addAll(warrantyIcon, warrantyLabel, warrantyDetails);
            root.getChildren().add(warrantyBox);
        }


        // Componenti
        if (!laptop.getComponents().isEmpty()) {
            Label componentTitle = new Label("Componenti:");
            componentTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(componentTitle);

            for (Component component : laptop.getComponents()) {
                HBox componentBox = new HBox(10);
                Label componentDetails = null;
                ImageView componentIcon = null;

                if (component instanceof RAM) {
                    componentIcon = loadIcon(iconPath + "ram.png");
                    RAM ram = (RAM) component;
                    componentDetails = new Label("RAM: " + ram.getRamName() + " - Dimensione: " + ram.getRamSize());
                } else if (component instanceof CPU) {
                    componentIcon = loadIcon(iconPath + "cpu.png");
                    CPU cpu = (CPU) component;
                    componentDetails = new Label("CPU: " + cpu.getCPUName() + " - Velocita': " + cpu.getCpuSpeed());
                } else if (component instanceof Display) {
                    componentIcon = loadIcon(iconPath + "display.png");
                    Display display = (Display) component;
                    componentDetails = new Label("Display: " + display.getDisplayName() + " - Risoluzione: " + display.getDisplayResolution());
                } else if (component instanceof GraphicsCard) {
                    componentIcon = loadIcon(iconPath + "graphics.png");
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    componentDetails = new Label("Scheda Grafica: " + graphicsCard.getGraphicCardName() + " - Memoria: " + graphicsCard.getGraphicsMemory());
                } else if (component instanceof OperatingSystem) {
                    componentIcon = loadIcon(iconPath + "os.png");
                    OperatingSystem os = (OperatingSystem) component;
                    componentDetails = new Label("Sistema Operativo: " + os.getOSName() + " - Versione: " + os.getOperatingSystemVersion());
                } else if (component instanceof Storage) {
                    componentIcon = loadIcon(iconPath + "storage.png");
                    Storage storage = (Storage) component;
                    componentDetails = new Label("Memoria: " + storage.getStorageName() + " - Capacita': " + storage.getStorageCapacity());
                }

                componentBox.getChildren().addAll(componentIcon, componentDetails);
                root.getChildren().add(componentBox);
            }
        }

        // Periferiche
        if (!laptop.getPeripherals().isEmpty()) {
            Label peripheralTitle = new Label("Periferiche:");
            peripheralTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(peripheralTitle);

            for (Peripheral peripheral : laptop.getPeripherals()) {
                HBox peripheralBox = new HBox(10);
                Label peripheralDetails = null;
                ImageView peripheralIcon = null;

                if (peripheral instanceof ExternalMonitor) {
                    peripheralIcon = loadIcon(iconPath + "monitor.png");
                    ExternalMonitor monitor = (ExternalMonitor) peripheral;
                    peripheralDetails = new Label("Monitor Esterno: " + monitor.getExMonitorName() + " - Risoluzione: " + monitor.getExternalDisplayResolution());
                } else if (peripheral instanceof ExternalSpeaker) {
                    peripheralIcon = loadIcon(iconPath + "speaker.png");
                    ExternalSpeaker speaker = (ExternalSpeaker) peripheral;
                    peripheralDetails = new Label("Speaker Esterno: " + speaker.getExSpeakerName() + " - Tipo: " + speaker.getExternalAudioSystemType());
                } else if (peripheral instanceof Keyboard) {
                    peripheralIcon = loadIcon(iconPath + "keyboard.png");
                    Keyboard keyboard = (Keyboard) peripheral;
                    peripheralDetails = new Label("Tastiera: " + keyboard.getKeyboardName() + " - Layout: " + keyboard.getKeyboardLayout());
                } else if (peripheral instanceof Mouse) {
                    peripheralIcon = loadIcon(iconPath + "mouse.png");
                    Mouse mouse = (Mouse) peripheral;
                    peripheralDetails = new Label("Mouse: " + mouse.getMouseName() + " - Tipo: " + mouse.getMouseType());
                } else if (peripheral instanceof Webcam) {
                    peripheralIcon = loadIcon(iconPath + "webcam.png");
                    Webcam webcam = (Webcam) peripheral;
                    peripheralDetails = new Label("Webcam: " + webcam.getWebcamName() + " - Risoluzione: " + webcam.getWebcamResolution());
                }

                peripheralBox.getChildren().addAll(peripheralIcon, peripheralDetails);
                root.getChildren().add(peripheralBox);
            }
        }

        // Porte
        if (!laptop.getPorts().isEmpty()) {
            Label portTitle = new Label("Porte:");
            portTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(portTitle);

            for (Port port : laptop.getPorts()) {
                HBox portBox = new HBox(10);
                Label portDetails = null;
                ImageView portIcon = null;

                if (port instanceof Ethernet) {
                    portIcon = loadIcon(iconPath + "ethernet.png");
                    Ethernet ethernet = (Ethernet) port;
                    portDetails = new Label("Ethernet - Nome: " + ethernet.getEthernetName() + " - Velocita': " + ethernet.getEthernetSpeed());
                } else if (port instanceof USB) {
                    portIcon = loadIcon(iconPath + "usb.png");
                    USB usb = (USB) port;
                    portDetails = new Label("USB - Nome: " + usb.getUSBName() + " - Versione: " + usb.getUSBVersion());
                } else if (port instanceof HDMI) {
                    portIcon = loadIcon(iconPath + "hdmi.png");
                    HDMI hdmi = (HDMI) port;
                    portDetails = new Label("HDMI - Nome: " + hdmi.getHDMIName() + " - Versione: " + hdmi.getHDMIVersion());
                }

                portBox.getChildren().addAll(portIcon, portDetails);
                root.getChildren().add(portBox);
            }
        }

        // Sicurezza
        if (!laptop.getSecurities().isEmpty()) {
            Label securityTitle = new Label("Sicurezza:");
            securityTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(securityTitle);

            for (Security security : laptop.getSecurities()) {
                HBox securityBox = new HBox(10);
                Label securityDetails = null;
                ImageView securityIcon = null;

                if (security instanceof Antivirus) {
                    securityIcon = loadIcon(iconPath + "antivirus.png");
                    Antivirus antivirus = (Antivirus) security;
                    securityDetails = new Label("Antivirus: " + antivirus.getAntivirusName() + " - Versione: " + antivirus.getAntivirusVersion());
                } else if (security instanceof ProtectionFeature) {
                    securityIcon = loadIcon(iconPath + "protection.png");
                    ProtectionFeature protection = (ProtectionFeature) security;
                    securityDetails = new Label("Protezione: " + protection.getProtectionFeatureName() + " - Tipo: " + protection.getTypeProtectionFeature());
                }

                securityBox.getChildren().addAll(securityIcon, securityDetails);
                root.getChildren().add(securityBox);
            }
        }

        // Mostra il contenuto in un dialogo
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configurazione Finale");
        alert.setHeaderText("Ecco la tua configurazione finale:");
        alert.getDialogPane().setContent(root);
        alert.showAndWait();
    }

    // Metodo helper per caricare le icone
    private ImageView loadIcon(String path) {
        try {
            Image image = new Image(getClass().getResourceAsStream(path));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(24);  // Imposta la larghezza a 24 pixel
            imageView.setFitHeight(24); // Imposta l'altezza a 24 pixel
            return imageView;
        } catch (Exception e) {
            System.out.println("Impossibile caricare l'icona: " + path);
            return new ImageView(); // Restituisce un'icona vuota in caso di errore
        }
    }

    // Helper methods for showing alerts
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successo");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
