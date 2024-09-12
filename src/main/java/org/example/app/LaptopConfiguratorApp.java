package org.example.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

            Label welcomeLabel = new Label("Benvenuto nel configuratore di laptop!");

            // ComboBox per selezionare il componente da configurare
            ComboBox<String> componentSelector = new ComboBox<>();
            componentSelector.getItems().addAll("Sistema Audio", "Batteria", "Colore", "Componenti", "Sistema di Raffreddamento", "Periferiche", "Porte", "Sicurezza", "Garanzia");
            componentSelector.setPromptText("Scegli un componente da configurare");

            Button configureButton = new Button("Configura");
            configureButton.setOnAction(e -> configureComponent(componentSelector.getValue()));

            Button finalizeButton = new Button("Mostra Configurazione Finale");
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
                showSuccess("Hai aggiunto la RAM: " + selectedRAM.getRamName() + " con capacità " + selectedRAM.getRamSize() + "GB.");
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

    // Metodo per visualizzare la configurazione finale
    private void displayFinalConfiguration() {
        StringBuilder configurationSummary = new StringBuilder();

        String separator = "----------------------------------------\n";
        configurationSummary.append(separator);
        configurationSummary.append("Configurazione finale del laptop: ").append(laptop.getLaptopName()).append("\n");
        configurationSummary.append(separator);

        // Sistema Audio
        if (laptop.getAudioSystem() != null) {
            AudioSystem audioSystem = laptop.getAudioSystem();
            configurationSummary.append("[Sistema Audio]\n");
            configurationSummary.append(String.format("  Nome: %s\n  Tipo: %s\n", audioSystem.getAudioSystemName(), audioSystem.getAudioSystemType()));
            configurationSummary.append(separator);
        }

        // Batteria
        if (laptop.getBattery() != null) {
            Battery battery = laptop.getBattery();
            configurationSummary.append("[Batteria]\n");
            configurationSummary.append(String.format("  Nome: %s\n  Capacità: %.2f mAh\n", battery.getBatteryName(), battery.getBatteryCapacity()));
            configurationSummary.append(separator);
        }

        // Colore
        if (laptop.getColour() != null) {
            Colour colour = laptop.getColour();
            configurationSummary.append("[Colore]\n");
            configurationSummary.append(String.format("  Nome: %s\n", colour.getColourName()));
            configurationSummary.append(separator);
        }

        // Componenti
        if (!laptop.getComponents().isEmpty()) {
            configurationSummary.append("[Componenti]\n");
            for (Component component : laptop.getComponents()) {
                if (component instanceof RAM) {
                    RAM ram = (RAM) component;
                    configurationSummary.append(String.format("  RAM: %s  -  Dimensione: %sGB\n", ram.getRamName(), ram.getRamSize()));
                } else if (component instanceof CPU) {
                    CPU cpu = (CPU) component;
                    configurationSummary.append(String.format("  CPU: %s  -  Velocità: %s\n", cpu.getCPUName(), cpu.getCpuSpeed()));
                } else if (component instanceof Display) {
                    Display display = (Display) component;
                    configurationSummary.append(String.format("  Display: %s  -  Risoluzione: %s\n", display.getDisplayName(), display.getDisplayResolution()));
                } else if (component instanceof GraphicsCard) {
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    configurationSummary.append(String.format("  Scheda Grafica: %s  -  Memoria: %s\n", graphicsCard.getGraphicCardName(), graphicsCard.getGraphicsMemory()));
                } else if (component instanceof OperatingSystem) {
                    OperatingSystem os = (OperatingSystem) component;
                    configurationSummary.append(String.format("  Sistema Operativo: %s  -  Versione: %s\n", os.getOSName(), os.getOperatingSystemVersion()));
                } else if (component instanceof Storage) {
                    Storage storage = (Storage) component;
                    configurationSummary.append(String.format("  Memoria: %s  -  Capacità: %sGB\n", storage.getStorageName(), storage.getStorageCapacity()));
                }
            }
            configurationSummary.append(separator);
        }

        // Sistema Raffreddamento
        if (laptop.getCoolingSystem() != null) {
            CoolingSystem coolingSystem = laptop.getCoolingSystem();
            configurationSummary.append("[Sistema di Raffreddamento]\n");
            configurationSummary.append(String.format("  Nome: %s  -  Tipo: %s\n", coolingSystem.getCoolingSystemName(), coolingSystem.getCoolingSystemType()));
            configurationSummary.append(separator);
        }

        // Garanzia
        if (laptop.getWarranty() != null) {
            Warranty warranty = laptop.getWarranty();
            configurationSummary.append("[Garanzia]\n");
            configurationSummary.append(String.format("  Nome: %s  -  Durata: %d anni\n", warranty.getWarrantyName(), warranty.getWarrantyPeriod()));
            configurationSummary.append(separator);
        }

        // Periferiche
        if (!laptop.getPeripherals().isEmpty()) {
            configurationSummary.append("[Periferiche]\n");
            for (Peripheral peripheral : laptop.getPeripherals()) {
                if (peripheral instanceof ExternalMonitor) {
                    ExternalMonitor monitor = (ExternalMonitor) peripheral;
                    configurationSummary.append(String.format("  Monitor Esterno: %s  -  Risoluzione: %s\n", monitor.getExMonitorName(), monitor.getExternalDisplayResolution()));
                } else if (peripheral instanceof ExternalSpeaker) {
                    ExternalSpeaker speaker = (ExternalSpeaker) peripheral;
                    configurationSummary.append(String.format("  Speaker Esterno: %s  -  Tipo: %s\n", speaker.getExSpeakerName(), speaker.getExternalAudioSystemType()));
                } else if (peripheral instanceof Keyboard) {
                    Keyboard keyboard = (Keyboard) peripheral;
                    configurationSummary.append(String.format("  Tastiera: %s  -  Layout: %s\n", keyboard.getKeyboardName(), keyboard.getKeyboardLayout()));
                } else if (peripheral instanceof Mouse) {
                    Mouse mouse = (Mouse) peripheral;
                    configurationSummary.append(String.format("  Mouse: %s  -  Tipo: %s\n", mouse.getMouseName(), mouse.getMouseType()));
                } else if (peripheral instanceof Webcam) {
                    Webcam webcam = (Webcam) peripheral;
                    configurationSummary.append(String.format("  Webcam: %s  -  Risoluzione: %s\n", webcam.getWebcamName(), webcam.getWebcamResolution()));
                }
            }
            configurationSummary.append(separator);
        }

        // Porte
        if (!laptop.getPorts().isEmpty()) {
            configurationSummary.append("[Porte]\n");
            for (Port port : laptop.getPorts()) {
                if (port instanceof Ethernet) {
                    Ethernet ethernet = (Ethernet) port;
                    configurationSummary.append(String.format("  Ethernet - Porta n.%s  -  Nome: %s  -  Velocità: %s\n", ethernet.getPortName(), ethernet.getEthernetName(), ethernet.getEthernetSpeed()));
                } else if (port instanceof USB) {
                    USB usb = (USB) port;
                    configurationSummary.append(String.format("  USB - Porta n.%s  -  Nome: %s  -  Versione: %s\n", usb.getPortName(), usb.getUSBName(), usb.getUSBVersion()));
                } else if (port instanceof HDMI) {
                    HDMI hdmi = (HDMI) port;
                    configurationSummary.append(String.format("  HDMI - Porta n.%s  -  Nome: %s  -  Versione: %s\n", hdmi.getPortName(), hdmi.getHDMIName(), hdmi.getHDMIVersion()));
                }
            }
            configurationSummary.append(separator);
        }

        // Sicurezza
        if (!laptop.getSecurities().isEmpty()) {
            configurationSummary.append("[Sicurezza]\n");
            for (Security security : laptop.getSecurities()) {
                if (security instanceof Antivirus) {
                    Antivirus antivirus = (Antivirus) security;
                    configurationSummary.append(String.format("  Antivirus: %s  -  Versione: %s\n", antivirus.getAntivirusName(), antivirus.getAntivirusVersion()));
                } else if (security instanceof ProtectionFeature) {
                    ProtectionFeature protection = (ProtectionFeature) security;
                    configurationSummary.append(String.format("  Protezione: %s  -  Tipo: %s\n", protection.getProtectionFeatureName(), protection.getTypeProtectionFeature()));
                }
            }
            configurationSummary.append(separator);
        }

        configurationSummary.append("Configurazione completata.\n");
        configurationSummary.append(separator);

        // Mostra la configurazione finale in una finestra di dialogo
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configurazione Finale");
        alert.setHeaderText("Ecco la tua configurazione finale:");
        alert.setContentText(configurationSummary.toString());
        alert.showAndWait();
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
