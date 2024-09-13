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
import java.util.Locale;

/**
 * LaptopConfiguratorApp is the main class that launches the laptop configuration interface.
 * It allows users to select and configure different components of a laptop using a graphical interface.
 * The application uses an ontology to load component data and configure the laptop.
 */
public class LaptopConfiguratorApp extends Application {

    private Laptop laptop;
    private LaptopComponentQueryService queryService;

    /**
     * Starts the JavaFX application, initializes the GUI components, and loads the ontology.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.ENGLISH);
        primaryStage.setTitle("Laptop Configurator");

        String ontologyFilePath = "LaptopConfigModellazione.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
            queryService = new LaptopComponentQueryService(queryExecutor);

            laptop = new Laptop("MyLaptop");

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20, 20, 20, 20));
            layout.setStyle("-fx-background-color: #f0f0f0;"); // Background color

            Label welcomeLabel = new Label("Welcome to the laptop configurator!");
            welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");


            ComboBox<String> componentSelector = new ComboBox<>();
            componentSelector.getItems().addAll("Audio System", "Battery", "Color", "Components", "Cooling System", "Peripherals", "Ports", "Security", "Warranty");
            componentSelector.setPromptText("Choose a component to configure");
            componentSelector.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;");

            Button configureButton = new Button("Configure");
            configureButton.setStyle(
                    "-fx-background-color: #4CAF50;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-radius: 5px;" +
                            "-fx-padding: 10 20 10 20;"
            );

            // Button "Show Final Configuration"
            Button finalizeButton = new Button("Show Final Configuration");
            finalizeButton.setStyle(
                    "-fx-background-color: #2196F3;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 14px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-radius: 5px;" +
                            "-fx-padding: 10 20 10 20;"
            );

            String buttonHoverStyle = "-fx-background-color: #555555; -fx-text-fill: white;";

            configureButton.setOnMouseEntered(e -> configureButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));
            configureButton.setOnMouseExited(e -> configureButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));

            finalizeButton.setOnMouseEntered(e -> finalizeButton.setStyle("-fx-background-color: #1976D2; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));
            finalizeButton.setOnMouseExited(e -> finalizeButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-padding: 10 20 10 20;"));

            configureButton.setOnAction(e -> configureComponent(componentSelector.getValue()));
            finalizeButton.setOnAction(e -> displayFinalConfiguration());


            layout.getChildren().addAll(welcomeLabel, componentSelector, configureButton, finalizeButton);

            Scene scene = new Scene(layout, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.show();

        } else {
            showError("Error loading the ontology.");
        }
    }

    /**
     * Configures the selected laptop component based on user selection.
     *
     * @param selectedComponent the component chosen by the user from the ComboBox
     */
    private void configureComponent(String selectedComponent) {
        if (selectedComponent == null) {
            showError("Please select a component.");
            return;
        }

        switch (selectedComponent) {
            case "Audio System":
                configureAudioSystem();
                break;
            case "Battery":
                configureBattery();
                break;
            case "Color":
                configureColour();
                break;
            case "Components":
                configureComponents();
                break;
            case "Cooling System":
                configureCoolingSystem();
                break;
            case "Peripherals":
                configurePeripherals();
                break;
            case "Ports":
                configurePorts();
                break;
            case "Security":
                configureSecurity();
                break;
            case "Warranty":
                configureWarranty();
                break;
            default:
                showError("Invalid option.");
        }
    }

    /**
     * Configures the audio system component.
     */
    private void configureAudioSystem() {
        List<AudioSystem> audioSystems = queryService.getAudioSystemComponents(laptop);
        if (audioSystems.isEmpty()) {
            showError("No audio system found.");
            return;
        }

        ChoiceDialog<AudioSystem> audioDialog = new ChoiceDialog<>(audioSystems.get(0), audioSystems);
        audioDialog.setTitle("Audio System Configuration");
        audioDialog.setHeaderText("Select an audio system");
        audioDialog.setContentText("Audio System:");

        audioDialog.showAndWait().ifPresent(selectedAudioSystem -> {
            laptop.setAudioSystem(selectedAudioSystem);
            showSuccess("You have added the audio system: " + selectedAudioSystem.getAudioSystemName());
        });
    }

    /**
     * Configures the battery component.
     */
    private void configureBattery() {
        List<Battery> batteries = queryService.getBatteryComponents(laptop);
        if (batteries.isEmpty()) {
            showError("No battery found.");
            return;
        }

        ChoiceDialog<Battery> batteryDialog = new ChoiceDialog<>(batteries.get(0), batteries);
        batteryDialog.setTitle("Battery Configuration");
        batteryDialog.setHeaderText("Select a battery system");
        batteryDialog.setContentText("Battery System:");

        batteryDialog.showAndWait().ifPresent(selectedbattery -> {
            laptop.setBattery(selectedbattery);
            showSuccess("You have added the battery system: " + selectedbattery.getBatteryName());
        });
    }

    /**
     * Configures the color component.
     */
    private void configureColour() {
        List<Colour> colours = queryService.getColourComponents(laptop);
        if (colours.isEmpty()) {
            showError("No color found.");
            return;
        }

        ChoiceDialog<Colour> colourDialog = new ChoiceDialog<>(colours.get(0), colours);
        colourDialog.setTitle("Color Configuration");
        colourDialog.setHeaderText("Select a color system");
        colourDialog.setContentText("Color System:");

        colourDialog.showAndWait().ifPresent(selectedcolour -> {
            laptop.setColour(selectedcolour);
            showSuccess("You have added the color system: " + selectedcolour.getColourName());
        });
    }

    /**
     * Configures multiple hardware components such as CPU, RAM, Display, and more.
     */
    private void configureComponents() {
        // Create a menu to select the type of component to configure
        List<String> componentOptions = new ArrayList<>();
        componentOptions.add("CPU");
        componentOptions.add("RAM");
        componentOptions.add("Display");
        componentOptions.add("Graphics Card");
        componentOptions.add("Operating System");
        componentOptions.add("Storage");

        ChoiceDialog<String> componentDialog = new ChoiceDialog<>(componentOptions.get(0), componentOptions);
        componentDialog.setTitle("Component Configuration");
        componentDialog.setHeaderText("Select the component you want to configure:");
        componentDialog.setContentText("Component:");

        // Show the dialog and act based on the choice
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
                case "Operating System":
                    configureOperatingSystem();
                    break;
                case "Storage":
                    configureStorage();
                    break;
                default:
                    showError("Invalid component.");
            }
        });
    }

    /**
     * Configures the CPU component.
     */
    private void configureCPU() {
        List<CPU> cpuComponents = queryService.getCPUComponents(laptop);
        if (cpuComponents.isEmpty()) {
            showError("No CPU found.");
            return;
        }

        ChoiceDialog<CPU> cpuDialog = new ChoiceDialog<>(cpuComponents.get(0), cpuComponents);
        cpuDialog.setTitle("CPU Configuration");
        cpuDialog.setHeaderText("Select a CPU:");
        cpuDialog.setContentText("CPU:");

        cpuDialog.showAndWait().ifPresent(selectedCPU -> {
            laptop.addOrReplaceComponent(selectedCPU);
            showSuccess("You have added the CPU: " + selectedCPU.getCPUName());
        });
    }

    /**
     * Configures the RAM component.
     */
    private void configureRAM() {
        List<RAM> ramComponents = queryService.getRAMComponents(laptop);
        if (ramComponents.isEmpty()) {
            showError("No RAM found.");
            return;
        }

        ChoiceDialog<RAM> ramDialog = new ChoiceDialog<>(ramComponents.get(0), ramComponents);
        ramDialog.setTitle("RAM Configuration");
        ramDialog.setHeaderText("Select a RAM:");
        ramDialog.setContentText("RAM:");

        ramDialog.showAndWait().ifPresent(selectedRAM -> {
            laptop.addOrReplaceComponent(selectedRAM);
            showSuccess("You have added the RAM: " + selectedRAM.getRamName() + " with capacity " + selectedRAM.getRamSize());
        });
    }

    /**
     * Configures the display component.
     */
    private void configureDisplay() {
        List<Display> displayComponents = queryService.getDisplayComponents(laptop);
        if (displayComponents.isEmpty()) {
            showError("No display found.");
            return;
        }

        ChoiceDialog<Display> displayDialog = new ChoiceDialog<>(displayComponents.get(0), displayComponents);
        displayDialog.setTitle("Display Configuration");
        displayDialog.setHeaderText("Select a Display:");
        displayDialog.setContentText("Display:");

        displayDialog.showAndWait().ifPresent(selectedDisplay -> {
            laptop.addOrReplaceComponent(selectedDisplay);
            showSuccess("You have added the display: " + selectedDisplay.getDisplayName() + " with resolution " + selectedDisplay.getDisplayResolution());
        });
    }

    /**
     * Configures the graphics card component.
     */
    private void configureGraphicsCard() {
        List<GraphicsCard> graphicsCardComponents = queryService.getGraphicsCardComponents(laptop);
        if (graphicsCardComponents.isEmpty()) {
            showError("No graphics card found.");
            return;
        }

        ChoiceDialog<GraphicsCard> graphicsCardDialog = new ChoiceDialog<>(graphicsCardComponents.get(0), graphicsCardComponents);
        graphicsCardDialog.setTitle("Graphics Card Configuration");
        graphicsCardDialog.setHeaderText("Select a graphics card:");
        graphicsCardDialog.setContentText("Graphics Card:");

        graphicsCardDialog.showAndWait().ifPresent(selectedGraphicsCard -> {
            laptop.addOrReplaceComponent(selectedGraphicsCard);
            showSuccess("You have added the graphics card: " + selectedGraphicsCard.getGraphicCardName() + " with " + selectedGraphicsCard.getGraphicsMemory() + " memory.");
        });
    }

    /**
     * Configures the operating system component.
     */
    private void configureOperatingSystem() {
        List<OperatingSystem> osComponents = queryService.getOperatingSystemComponents(laptop);
        if (osComponents.isEmpty()) {
            showError("No operating system found.");
            return;
        }

        ChoiceDialog<OperatingSystem> osDialog = new ChoiceDialog<>(osComponents.get(0), osComponents);
        osDialog.setTitle("Operating System Configuration");
        osDialog.setHeaderText("Select an Operating System:");
        osDialog.setContentText("Operating System:");

        osDialog.showAndWait().ifPresent(selectedOS -> {
            laptop.addOrReplaceComponent(selectedOS);
            showSuccess("You have added the operating system: " + selectedOS.getOsName() + " version " + selectedOS.getOperatingSystemVersion());
        });
    }

    /**
     * Configures the storage component.
     */
    private void configureStorage() {
        List<Storage> storageComponents = queryService.getStorageComponents(laptop);
        if (storageComponents.isEmpty()) {
            showError("No storage component found.");
            return;
        }

        ChoiceDialog<Storage> storageDialog = new ChoiceDialog<>(storageComponents.get(0), storageComponents);
        storageDialog.setTitle("Storage Configuration");
        storageDialog.setHeaderText("Select a storage:");
        storageDialog.setContentText("Storage:");

        storageDialog.showAndWait().ifPresent(selectedStorage -> {
            laptop.addOrReplaceComponent(selectedStorage);
            showSuccess("You have added the storage: " + selectedStorage.getStorageName() + " with capacity " + selectedStorage.getStorageCapacity() + "GB.");
        });
    }

    /**
     * Configures the cooling system component.
     */
    private void configureCoolingSystem() {
        List<CoolingSystem> coolingSystems = queryService.getCoolingSystemComponents(laptop);
        if (coolingSystems.isEmpty()) {
            showError("No cooling system found.");
            return;
        }

        ChoiceDialog<CoolingSystem> coolingDialog = new ChoiceDialog<>(coolingSystems.get(0), coolingSystems);
        coolingDialog.setTitle("Cooling System Configuration");
        coolingDialog.setHeaderText("Select a cooling system");
        coolingDialog.setContentText("Cooling System:");

        coolingDialog.showAndWait().ifPresent(selectedCoolingSystem -> {
            laptop.setCoolingSystem(selectedCoolingSystem);
            showSuccess("You have added the cooling system: " + selectedCoolingSystem.getCoolingSystemName());
        });
    }

    /**
     * Configures peripherals like monitors, speakers, keyboards, and more.
     */
    private void configurePeripherals() {
        // Create a menu to select the peripheral to configure
        List<String> peripheralOptions = new ArrayList<>();
        peripheralOptions.add("External Monitor");
        peripheralOptions.add("External Speaker");
        peripheralOptions.add("Keyboard");
        peripheralOptions.add("Mouse");
        peripheralOptions.add("Webcam");

        ChoiceDialog<String> peripheralDialog = new ChoiceDialog<>(peripheralOptions.get(0), peripheralOptions);
        peripheralDialog.setTitle("Peripheral Configuration");
        peripheralDialog.setHeaderText("Select the peripheral you want to configure:");
        peripheralDialog.setContentText("Peripheral:");

        // Show the dialog and act based on the choice
        peripheralDialog.showAndWait().ifPresent(selectedPeripheral -> {
            switch (selectedPeripheral) {
                case "External Monitor":
                    configureExternalMonitor();
                    break;
                case "External Speaker":
                    configureExternalSpeaker();
                    break;
                case "Keyboard":
                    configureKeyboard();
                    break;
                case "Mouse":
                    configureMouse();
                    break;
                case "Webcam":
                    configureWebcam();
                    break;
                default:
                    showError("Invalid peripheral.");
            }
        });
    }

    /**
     * Configures the external monitor peripheral.
     */
    private void configureExternalMonitor() {
        List<ExternalMonitor> monitorComponents = queryService.getExternalMonitorComponents(laptop);
        if (monitorComponents.isEmpty()) {
            showError("No external monitor found.");
            return;
        }

        ChoiceDialog<ExternalMonitor> monitorDialog = new ChoiceDialog<>(monitorComponents.get(0), monitorComponents);
        monitorDialog.setTitle("External Monitor Configuration");
        monitorDialog.setHeaderText("Select an external monitor:");
        monitorDialog.setContentText("Monitor:");

        monitorDialog.showAndWait().ifPresent(selectedMonitor -> {
            laptop.addOrReplacePeripheral(selectedMonitor);
            showSuccess("You have added the external monitor: " + selectedMonitor.getExMonitorName() + " with resolution " + selectedMonitor.getExternalDisplayResolution());
        });
    }

    /**
     * Configures the external speaker peripheral.
     */
    private void configureExternalSpeaker() {
        List<ExternalSpeaker> speakerComponents = queryService.getExternalSpeakerComponents(laptop);
        if (speakerComponents.isEmpty()) {
            showError("No external speaker found.");
            return;
        }

        ChoiceDialog<ExternalSpeaker> speakerDialog = new ChoiceDialog<>(speakerComponents.get(0), speakerComponents);
        speakerDialog.setTitle("External Speaker Configuration");
        speakerDialog.setHeaderText("Select an external speaker:");
        speakerDialog.setContentText("Speaker:");

        speakerDialog.showAndWait().ifPresent(selectedSpeaker -> {
            laptop.addOrReplacePeripheral(selectedSpeaker);
            showSuccess("You have added the external speaker: " + selectedSpeaker.getExSpeakerName() + " of type " + selectedSpeaker.getExternalAudioSystemType());
        });
    }

    /**
     * Configures the keyboard peripheral.
     */
    private void configureKeyboard() {
        List<Keyboard> keyboardComponents = queryService.getKeyboardComponents(laptop);
        if (keyboardComponents.isEmpty()) {
            showError("No keyboard found.");
            return;
        }

        ChoiceDialog<Keyboard> keyboardDialog = new ChoiceDialog<>(keyboardComponents.get(0), keyboardComponents);
        keyboardDialog.setTitle("Keyboard Configuration");
        keyboardDialog.setHeaderText("Select a keyboard:");
        keyboardDialog.setContentText("Keyboard:");

        keyboardDialog.showAndWait().ifPresent(selectedKeyboard -> {
            laptop.addOrReplacePeripheral(selectedKeyboard);
            showSuccess("You have added the keyboard: " + selectedKeyboard.getKeyboardName() + " with layout " + selectedKeyboard.getKeyboardLayout());
        });
    }

    /**
     * Configures the mouse peripheral.
     */
    private void configureMouse() {
        List<Mouse> mouseComponents = queryService.getMouseComponents(laptop);
        if (mouseComponents.isEmpty()) {
            showError("No mouse found.");
            return;
        }

        ChoiceDialog<Mouse> mouseDialog = new ChoiceDialog<>(mouseComponents.get(0), mouseComponents);
        mouseDialog.setTitle("Mouse Configuration");
        mouseDialog.setHeaderText("Select a mouse:");
        mouseDialog.setContentText("Mouse:");

        mouseDialog.showAndWait().ifPresent(selectedMouse -> {
            laptop.addOrReplacePeripheral(selectedMouse);
            showSuccess("You have added the mouse: " + selectedMouse.getMouseName() + " of type " + selectedMouse.getMouseType());
        });
    }

    /**
     * Configures the webcam peripheral.
     */
    private void configureWebcam() {
        List<Webcam> webcamComponents = queryService.getWebcamComponents(laptop);
        if (webcamComponents.isEmpty()) {
            showError("No webcam found.");
            return;
        }

        ChoiceDialog<Webcam> webcamDialog = new ChoiceDialog<>(webcamComponents.get(0), webcamComponents);
        webcamDialog.setTitle("Webcam Configuration");
        webcamDialog.setHeaderText("Select a webcam:");
        webcamDialog.setContentText("Webcam:");

        webcamDialog.showAndWait().ifPresent(selectedWebcam -> {
            laptop.addOrReplacePeripheral(selectedWebcam);
            showSuccess("You have added the webcam: " + selectedWebcam.getWebcamName() + " with resolution " + selectedWebcam.getWebcamResolution());
        });
    }

    /**
     * Configures ports like Ethernet, USB, and HDMI.
     */
    private void configurePorts() {
        // Create a menu to select the port to configure
        List<String> portOptions = new ArrayList<>();
        portOptions.add("Ethernet");
        portOptions.add("USB");
        portOptions.add("HDMI");

        ChoiceDialog<String> portDialog = new ChoiceDialog<>(portOptions.get(0), portOptions);
        portDialog.setTitle("Port Configuration");
        portDialog.setHeaderText("Select the type of port you want to configure:");
        portDialog.setContentText("Port:");

        // Show the dialog and act based on the choice
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
                    showError("Invalid port type.");
            }
        });
    }

    /**
     * Configures the Ethernet port.
     */
    private void configureEthernet() {
        List<Ethernet> ethernetComponents = queryService.getEthernetComponents(laptop);
        if (ethernetComponents.isEmpty()) {
            showError("No Ethernet port found.");
            return;
        }

        ChoiceDialog<Ethernet> ethernetDialog = new ChoiceDialog<>(ethernetComponents.get(0), ethernetComponents);
        ethernetDialog.setTitle("Ethernet Port Configuration");
        ethernetDialog.setHeaderText("Select an Ethernet port:");
        ethernetDialog.setContentText("Ethernet:");

        ethernetDialog.showAndWait().ifPresent(selectedEthernet -> {
            laptop.addOrReplacePort(selectedEthernet);
            showSuccess("You have added the Ethernet port: " + selectedEthernet.getEthernetName() + " with speed " + selectedEthernet.getEthernetSpeed());
        });
    }

    /**
     * Configures the USB port.
     */
    private void configureUSB() {
        List<USB> usbComponents = queryService.getUSBComponents(laptop);
        if (usbComponents.isEmpty()) {
            showError("No USB port found.");
            return;
        }

        ChoiceDialog<USB> usbDialog = new ChoiceDialog<>(usbComponents.get(0), usbComponents);
        usbDialog.setTitle("USB Port Configuration");
        usbDialog.setHeaderText("Select a USB port:");
        usbDialog.setContentText("USB:");

        usbDialog.showAndWait().ifPresent(selectedUSB -> {
            laptop.addOrReplacePort(selectedUSB);
            showSuccess("You have added the USB port: " + selectedUSB.getUsbName() + " with version " + selectedUSB.getUsbVersion());
        });
    }

    /**
     * Configures the HDMI port.
     */
    private void configureHDMI() {
        List<HDMI> hdmiComponents = queryService.getHDMIComponents(laptop);
        if (hdmiComponents.isEmpty()) {
            showError("No HDMI port found.");
            return;
        }

        ChoiceDialog<HDMI> hdmiDialog = new ChoiceDialog<>(hdmiComponents.get(0), hdmiComponents);
        hdmiDialog.setTitle("HDMI Port Configuration");
        hdmiDialog.setHeaderText("Select an HDMI port:");
        hdmiDialog.setContentText("HDMI:");

        hdmiDialog.showAndWait().ifPresent(selectedHDMI -> {
            laptop.addOrReplacePort(selectedHDMI);
            showSuccess("You have added the HDMI port: " + selectedHDMI.getHDMIName() + " with version " + selectedHDMI.getHDMIVersion());
        });
    }

    /**
     * Configures the security components such as antivirus and protection features.
     */
    private void configureSecurity() {
        // Create a menu to select the type of security to configure
        List<String> securityOptions = new ArrayList<>();
        securityOptions.add("Antivirus");
        securityOptions.add("Protection Feature");

        ChoiceDialog<String> securityDialog = new ChoiceDialog<>(securityOptions.get(0), securityOptions);
        securityDialog.setTitle("Security Configuration");
        securityDialog.setHeaderText("Select the type of security you want to configure:");
        securityDialog.setContentText("Security:");

        // Show the dialog and act based on the choice
        securityDialog.showAndWait().ifPresent(selectedSecurity -> {
            switch (selectedSecurity) {
                case "Antivirus":
                    configureAntivirus();
                    break;
                case "Protection Feature":
                    configureProtectionFeature();
                    break;
                default:
                    showError("Invalid security type.");
            }
        });
    }

    /**
     * Configures the antivirus component.
     */
    private void configureAntivirus() {
        List<Antivirus> antivirusComponents = queryService.getAntivirusComponents(laptop);
        if (antivirusComponents.isEmpty()) {
            showError("No antivirus found.");
            return;
        }

        ChoiceDialog<Antivirus> antivirusDialog = new ChoiceDialog<>(antivirusComponents.get(0), antivirusComponents);
        antivirusDialog.setTitle("Antivirus Configuration");
        antivirusDialog.setHeaderText("Select an antivirus:");
        antivirusDialog.setContentText("Antivirus:");

        antivirusDialog.showAndWait().ifPresent(selectedAntivirus -> {
            laptop.addOrReplaceSecurity(selectedAntivirus);
            showSuccess("You have added the antivirus: " + selectedAntivirus.getAntivirusName() + " with version " + selectedAntivirus.getAntivirusVersion());
        });
    }

    /**
     * Configures the protection feature component.
     */
    private void configureProtectionFeature() {
        List<ProtectionFeature> protectionFeatureComponents = queryService.getProtectionFeatureComponents(laptop);
        if (protectionFeatureComponents.isEmpty()) {
            showError("No protection feature found.");
            return;
        }

        ChoiceDialog<ProtectionFeature> protectionDialog = new ChoiceDialog<>(protectionFeatureComponents.get(0), protectionFeatureComponents);
        protectionDialog.setTitle("Protection Feature Configuration");
        protectionDialog.setHeaderText("Select a protection feature:");
        protectionDialog.setContentText("Protection Feature:");

        protectionDialog.showAndWait().ifPresent(selectedProtectionFeature -> {
            laptop.addOrReplaceSecurity(selectedProtectionFeature);
            showSuccess("You have added the protection feature: " + selectedProtectionFeature.getProtectionFeatureName() + " of type " + selectedProtectionFeature.getTypeProtectionFeature());
        });
    }

    /**
     * Configures the warranty component.
     */
    private void configureWarranty() {
        List<Warranty> warranties = queryService.getWarrantyComponents(laptop);
        if (warranties.isEmpty()) {
            showError("No warranty found.");
            return;
        }

        ChoiceDialog<Warranty> warrantyDialog = new ChoiceDialog<>(warranties.get(0), warranties);
        warrantyDialog.setTitle("Warranty Configuration");
        warrantyDialog.setHeaderText("Select a warranty");
        warrantyDialog.setContentText("Warranty:");

        warrantyDialog.showAndWait().ifPresent(selectedWarranty -> {
            laptop.setWarranty(selectedWarranty);
            showSuccess("You have added the warranty: " + selectedWarranty.getWarrantyName());
        });
    }

    /**
     * Displays the final configuration of the laptop, showing all selected components.
     */
    private void displayFinalConfiguration() {
        VBox root = new VBox(10); // Vertical layout for information
        root.setAlignment(Pos.TOP_LEFT);

        String iconPath = "/icons/"; // Ensure the icons are here

        // Laptop Title
        Label laptopNameLabel = new Label("Laptop Name:");
        laptopNameLabel.setStyle("-fx-font-weight: bold;");
        Label laptopName = new Label(laptop.getLaptopName());

        root.getChildren().addAll(laptopNameLabel, laptopName);

        // Audio System
        if (laptop.getAudioSystem() != null) {
            AudioSystem audioSystem = laptop.getAudioSystem();
            HBox audioBox = new HBox(10);
            ImageView audioIcon = loadIcon(iconPath + "audio.png");
            Label audioLabel = new Label("Audio System:");
            audioLabel.setStyle("-fx-font-weight: bold;");
            Label audioDetails = new Label(audioSystem.getAudioSystemName() + " - Type: " + audioSystem.getAudioSystemType());

            audioBox.getChildren().addAll(audioIcon, audioLabel, audioDetails);
            root.getChildren().add(audioBox);
        }

        // Battery
        if (laptop.getBattery() != null) {
            Battery battery = laptop.getBattery();
            HBox batteryBox = new HBox(10);
            ImageView batteryIcon = loadIcon(iconPath + "battery.png");
            Label batteryLabel = new Label("Battery:");
            batteryLabel.setStyle("-fx-font-weight: bold;");
            Label batteryDetails = new Label(battery.getBatteryName() + " - Capacity: " + String.format("%.2f mAh", battery.getBatteryCapacity()));

            batteryBox.getChildren().addAll(batteryIcon, batteryLabel, batteryDetails);
            root.getChildren().add(batteryBox);
        }

        // Color
        if (laptop.getColour() != null) {
            Colour colour = laptop.getColour();
            HBox colourBox = new HBox(10);
            ImageView colourIcon = loadIcon(iconPath + "colour.png");
            Label colourLabel = new Label("Color:");
            colourLabel.setStyle("-fx-font-weight: bold;");
            Label colourDetails = new Label(colour.getColourName());

            colourBox.getChildren().addAll(colourIcon, colourLabel, colourDetails);
            root.getChildren().add(colourBox);
        }
        // Cooling System
        if (laptop.getCoolingSystem() != null) {
            CoolingSystem coolingSystem = laptop.getCoolingSystem();
            HBox coolingBox = new HBox(10);
            ImageView coolingIcon = loadIcon(iconPath + "cooling.png");
            Label coolingLabel = new Label("Cooling System:");
            coolingLabel.setStyle("-fx-font-weight: bold;");
            Label coolingDetails = new Label(coolingSystem.getCoolingSystemName() + " - Type: " + coolingSystem.getCoolingSystemType());

            coolingBox.getChildren().addAll(coolingIcon, coolingLabel, coolingDetails);
            root.getChildren().add(coolingBox);
        }

        // Warranty
        if (laptop.getWarranty() != null) {
            Warranty warranty = laptop.getWarranty();
            HBox warrantyBox = new HBox(10);
            ImageView warrantyIcon = loadIcon(iconPath + "warranty.png");
            Label warrantyLabel = new Label("Warranty:");
            warrantyLabel.setStyle("-fx-font-weight: bold;");
            Label warrantyDetails = new Label(warranty.getWarrantyName() + " - Duration: " + warranty.getWarrantyPeriod() + " years");

            warrantyBox.getChildren().addAll(warrantyIcon, warrantyLabel, warrantyDetails);
            root.getChildren().add(warrantyBox);
        }


        // Components
        if (!laptop.getComponents().isEmpty()) {
            Label componentTitle = new Label("Components:");
            componentTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(componentTitle);

            for (Component component : laptop.getComponents()) {
                HBox componentBox = new HBox(10);
                Label componentDetails = null;
                ImageView componentIcon = null;

                if (component instanceof RAM) {
                    componentIcon = loadIcon(iconPath + "ram.png");
                    RAM ram = (RAM) component;
                    componentDetails = new Label("RAM: " + ram.getRamName() + " - Size: " + ram.getRamSize());
                } else if (component instanceof CPU) {
                    componentIcon = loadIcon(iconPath + "cpu.png");
                    CPU cpu = (CPU) component;
                    componentDetails = new Label("CPU: " + cpu.getCPUName() + " - Speed: " + cpu.getCpuSpeed());
                } else if (component instanceof Display) {
                    componentIcon = loadIcon(iconPath + "display.png");
                    Display display = (Display) component;
                    componentDetails = new Label("Display: " + display.getDisplayName() + " - Resolution: " + display.getDisplayResolution());
                } else if (component instanceof GraphicsCard) {
                    componentIcon = loadIcon(iconPath + "graphics.png");
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    componentDetails = new Label("Graphics Card: " + graphicsCard.getGraphicCardName() + " - Memory: " + graphicsCard.getGraphicsMemory());
                } else if (component instanceof OperatingSystem) {
                    componentIcon = loadIcon(iconPath + "os.png");
                    OperatingSystem os = (OperatingSystem) component;
                    componentDetails = new Label("Operating System: " + os.getOsName() + " - Version: " + os.getOperatingSystemVersion());
                } else if (component instanceof Storage) {
                    componentIcon = loadIcon(iconPath + "storage.png");
                    Storage storage = (Storage) component;
                    componentDetails = new Label("Storage: " + storage.getStorageName() + " - Capacity: " + storage.getStorageCapacity());
                }

                componentBox.getChildren().addAll(componentIcon, componentDetails);
                root.getChildren().add(componentBox);
            }
        }

        // Peripherals
        if (!laptop.getPeripherals().isEmpty()) {
            Label peripheralTitle = new Label("Peripherals:");
            peripheralTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(peripheralTitle);

            for (Peripheral peripheral : laptop.getPeripherals()) {
                HBox peripheralBox = new HBox(10);
                Label peripheralDetails = null;
                ImageView peripheralIcon = null;

                if (peripheral instanceof ExternalMonitor) {
                    peripheralIcon = loadIcon(iconPath + "monitor.png");
                    ExternalMonitor monitor = (ExternalMonitor) peripheral;
                    peripheralDetails = new Label("External Monitor: " + monitor.getExMonitorName() + " - Resolution: " + monitor.getExternalDisplayResolution());
                } else if (peripheral instanceof ExternalSpeaker) {
                    peripheralIcon = loadIcon(iconPath + "speaker.png");
                    ExternalSpeaker speaker = (ExternalSpeaker) peripheral;
                    peripheralDetails = new Label("External Speaker: " + speaker.getExSpeakerName() + " - Type: " + speaker.getExternalAudioSystemType());
                } else if (peripheral instanceof Keyboard) {
                    peripheralIcon = loadIcon(iconPath + "keyboard.png");
                    Keyboard keyboard = (Keyboard) peripheral;
                    peripheralDetails = new Label("Keyboard: " + keyboard.getKeyboardName() + " - Layout: " + keyboard.getKeyboardLayout());
                } else if (peripheral instanceof Mouse) {
                    peripheralIcon = loadIcon(iconPath + "mouse.png");
                    Mouse mouse = (Mouse) peripheral;
                    peripheralDetails = new Label("Mouse: " + mouse.getMouseName() + " - Type: " + mouse.getMouseType());
                } else if (peripheral instanceof Webcam) {
                    peripheralIcon = loadIcon(iconPath + "webcam.png");
                    Webcam webcam = (Webcam) peripheral;
                    peripheralDetails = new Label("Webcam: " + webcam.getWebcamName() + " - Resolution: " + webcam.getWebcamResolution());
                }

                peripheralBox.getChildren().addAll(peripheralIcon, peripheralDetails);
                root.getChildren().add(peripheralBox);
            }
        }

        // Ports
        if (!laptop.getPorts().isEmpty()) {
            Label portTitle = new Label("Ports:");
            portTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(portTitle);

            for (Port port : laptop.getPorts()) {
                HBox portBox = new HBox(10);
                Label portDetails = null;
                ImageView portIcon = null;

                if (port instanceof Ethernet) {
                    portIcon = loadIcon(iconPath + "ethernet.png");
                    Ethernet ethernet = (Ethernet) port;
                    portDetails = new Label("Ethernet - Name: " + ethernet.getEthernetName() + " - Speed: " + ethernet.getEthernetSpeed());
                } else if (port instanceof USB) {
                    portIcon = loadIcon(iconPath + "usb.png");
                    USB usb = (USB) port;
                    portDetails = new Label("USB - Name: " + usb.getUsbName() + " - Version: " + usb.getUsbVersion());
                } else if (port instanceof HDMI) {
                    portIcon = loadIcon(iconPath + "hdmi.png");
                    HDMI hdmi = (HDMI) port;
                    portDetails = new Label("HDMI - Name: " + hdmi.getHDMIName() + " - Version: " + hdmi.getHDMIVersion());
                }

                portBox.getChildren().addAll(portIcon, portDetails);
                root.getChildren().add(portBox);
            }
        }

        // Security
        if (!laptop.getSecurities().isEmpty()) {
            Label securityTitle = new Label("Security:");
            securityTitle.setStyle("-fx-font-weight: bold;");
            root.getChildren().add(securityTitle);

            for (Security security : laptop.getSecurities()) {
                HBox securityBox = new HBox(10);
                Label securityDetails = null;
                ImageView securityIcon = null;

                if (security instanceof Antivirus) {
                    securityIcon = loadIcon(iconPath + "antivirus.png");
                    Antivirus antivirus = (Antivirus) security;
                    securityDetails = new Label("Antivirus: " + antivirus.getAntivirusName() + " - Version: " + antivirus.getAntivirusVersion());
                } else if (security instanceof ProtectionFeature) {
                    securityIcon = loadIcon(iconPath + "protection.png");
                    ProtectionFeature protection = (ProtectionFeature) security;
                    securityDetails = new Label("Protection: " + protection.getProtectionFeatureName() + " - Type: " + protection.getTypeProtectionFeature());
                }

                securityBox.getChildren().addAll(securityIcon, securityDetails);
                root.getChildren().add(securityBox);
            }
        }

        // Show the content in a dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Final Configuration");
        alert.setHeaderText("Here is your final configuration:");
        alert.getDialogPane().setContent(root);
        alert.showAndWait();
    }

    // Helper method to load icons
    private ImageView loadIcon(String path) {
        try {
            Image image = new Image(getClass().getResourceAsStream(path));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(24);  // Set the width to 24 pixels
            imageView.setFitHeight(24); // Set the height to 24 pixels
            return imageView;
        } catch (Exception e) {
            System.out.println("Unable to load icon: " + path);
            return new ImageView(); // Returns an empty icon in case of an error
        }
    }

    // Helper methods for showing alerts
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * The main method that launches the JavaFX application.
     * It serves as the entry point for the program.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
