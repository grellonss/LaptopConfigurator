package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.LaptopComponentQueryService;
import org.example.ontology.OntologyLoader;
import org.example.ontology.SPARQLQueryExecutor;

import java.util.*;

/**
 * The Main class provides a console-based interface to configure a laptop.
 * It loads the ontology, allows the user to configure components, and displays the final configuration.
 */
public class Main {
    /**
     * The main method that initiates the program by loading the ontology and providing options to configure a laptop.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

            String ontologyFilePath = "LaptopConfigModellazione.rdf";
            OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
            OntModel model = ontologyLoader.getOntologyModel();

            if (model != null) {
                SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
                LaptopComponentQueryService queryService = new LaptopComponentQueryService(queryExecutor);

                Scanner scanner = new Scanner(System.in);
                Laptop laptop = createLaptop(scanner);

                configureLaptop(laptop, queryService, scanner);

                displayFinalConfiguration(laptop);
            } else {
                System.out.println("Error loading the ontology.");
            }
        }

        /**
         * Prompts the user to input a name for the laptop and creates a new Laptop object.
         *
         * @param scanner The scanner used to read user input
         * @return A new Laptop object with the user's input name
         */
        private static Laptop createLaptop(Scanner scanner) {
            System.out.print("Enter the laptop name: ");
            String laptopName = scanner.nextLine();
            return new Laptop(laptopName);
        }

        /**
         * Provides a loop for the user to configure the various laptop components.
         * Displays a menu with options to select different laptop parts.
         *
         * @param laptop The laptop being configured
         * @param queryService The service for querying laptop components from the ontology
         * @param scanner The scanner used to read user input
         */
        private static void configureLaptop(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
            boolean configMenuActive = true;
            while (configMenuActive) {
                int choice = displayMainMenu(scanner);
                switch (choice) {
                    case 1:
                        configureAudioSystem(laptop, queryService, scanner);
                        break;
                    case 2:
                        configureBattery(laptop, queryService, scanner);
                        break;
                    case 3:
                        configureColour(laptop, queryService, scanner);
                        break;
                    case 4:
                        configureComponentsMenu(laptop, queryService, scanner);
                        break;
                    case 5:
                        configureCoolingSystem(laptop, queryService, scanner);
                        break;
                    case 6:
                        configurePeripheralsMenu(laptop, queryService, scanner);
                        break;
                    case 7:
                        configurePortsMenu(laptop, queryService, scanner);
                        break;
                    case 8:
                        configureSecurityMenu(laptop, queryService, scanner);
                        break;
                    case 9:
                        configureWarranty(laptop, queryService, scanner);
                        break;
                    case 0:
                        configMenuActive = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        /**
         * Displays the main menu to the user for selecting the component to configure.
         *
         * @param scanner The scanner used to read user input
         * @return The user's selected option as an integer
         */
        private static int displayMainMenu(Scanner scanner) {
            System.out.println("What do you want to configure? Select an option by typing the number:");
            System.out.println("1. Audio System");
            System.out.println("2. Battery");
            System.out.println("3. Colour");
            System.out.println("4. Components");
            System.out.println("5. Cooling System");
            System.out.println("6. Peripherals");
            System.out.println("7. Ports");
            System.out.println("8. Security");
            System.out.println("9. Warranty");
            System.out.println("0. End configuration");

            return scanner.nextInt();
        }

        /**
         * Provides a submenu for selecting and configuring different laptop components.
         *
         * @param laptop The laptop being configured
         * @param queryService The service for querying laptop components from the ontology
         * @param scanner The scanner used to read user input
         */
        private static void configureComponentsMenu(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
            boolean componentMenuActive = true;
            while (componentMenuActive) {
                int choice = displayComponentMenu(scanner);
                switch (choice) {
                    case 1:
                        configureCPU(laptop, queryService, scanner);
                        break;
                    case 2:
                        configureDisplay(laptop, queryService, scanner);
                        break;
                    case 3:
                        configureGraphicsCard(laptop, queryService, scanner);
                        break;
                    case 4:
                        configureOperatingSystem(laptop, queryService, scanner);
                        break;
                    case 5:
                        configureRAM(laptop, queryService, scanner);
                        break;
                    case 6:
                        configureStorage(laptop, queryService, scanner);
                        break;
                    case 0:
                        componentMenuActive = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        /**
         * Displays the submenu for selecting which component to configure.
         *
         * @param scanner The scanner used to read user input
         * @return The user's selected option as an integer
         */
        private static int displayComponentMenu(Scanner scanner) {
            System.out.println("Quale componente vuoi selezionare?");
            System.out.println("1. CPU");
            System.out.println("2. Schermo");
            System.out.println("3. Scheda Grafica");
            System.out.println("4. Sistema Operativo");
            System.out.println("5. RAM");
            System.out.println("6. Memoria");
            System.out.println("0. Pagina Precedente");
            return scanner.nextInt();
        }

        /**
         * Provides a submenu for selecting and configuring different peripherals for the laptop.
         *
         * @param laptop The laptop being configured
         * @param queryService The service for querying laptop components from the ontology
         * @param scanner The scanner used to read user input
         */
        private static void configurePeripheralsMenu(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
            boolean componentMenuActive = true;
            while (componentMenuActive) {
                int choice = displayPeripheralMenu(scanner);
                switch (choice) {
                    case 1:
                        configureExternalMonitor(laptop, queryService, scanner);
                        break;
                    case 2:
                        configureExternalSpeaker(laptop, queryService, scanner);
                        break;
                    case 3:
                        configureKeyboard(laptop, queryService, scanner);
                        break;
                    case 4:
                        configureMouse(laptop, queryService, scanner);
                        break;
                    case 5:
                        configureWebcam(laptop, queryService, scanner);
                        break;
                    case 0:
                        componentMenuActive = false;
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }
        /**
         * Displays the submenu for selecting which peripheral to configure.
         *
         * @param scanner The scanner used to read user input
         * @return The user's selected option as an integer
         */
        private static int displayPeripheralMenu(Scanner scanner) {
            System.out.println("Which peripheral do you want to select?");
            System.out.println("1. External Monitor");
            System.out.println("2. External Speaker");
            System.out.println("3. Keyboard");
            System.out.println("4. Mouse");
            System.out.println("5. Webcam");
            System.out.println("0. Previous Page");
            return scanner.nextInt();
        }

        /**
         * Provides a submenu for selecting and configuring different ports for the laptop.
         *
         * @param laptop The laptop being configured
         * @param queryService The service for querying laptop components from the ontology
         * @param scanner The scanner used to read user input
         */
        private static void configurePortsMenu(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
            boolean componentMenuActive = true;
            while (componentMenuActive) {
                int choice = displayPortMenu(scanner);
                switch (choice) {
                    case 1:
                        configureEthernet(laptop, queryService, scanner);
                        break;
                    case 2:
                        configureHDMI(laptop, queryService, scanner);
                        break;
                    case 3:
                        configureUSB(laptop, queryService, scanner);
                        break;
                    case 0:
                        componentMenuActive = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        /**
         * Displays the submenu for selecting which port to configure.
         *
         * @param scanner The scanner used to read user input
         * @return The user's selected option as an integer
         */
        private static int displayPortMenu(Scanner scanner) {
            System.out.println("Which type of port do you want to select?");
            System.out.println("1. Ethernet");
            System.out.println("2. HDMI");
            System.out.println("3. USB");
            System.out.println("0. Previous Page");
            return scanner.nextInt();
        }

        /**
         * Provides a submenu for selecting and configuring security features for the laptop.
         *
         * @param laptop The laptop being configured
         * @param queryService The service for querying laptop components from the ontology
         * @param scanner The scanner used to read user input
         */
        private static void configureSecurityMenu(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
            boolean componentMenuActive = true;
            while (componentMenuActive) {
                int choice = displaySecurityMenu(scanner);
                switch (choice) {
                    case 1:
                        configureAntivirus(laptop, queryService, scanner);
                        break;
                    case 2:
                        configureProtectionFeature(laptop, queryService, scanner);
                        break;
                    case 0:
                        componentMenuActive = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        /**
         * Displays the submenu for selecting which security feature to configure.
         *
         * @param scanner The scanner used to read user input
         * @return The user's selected option as an integer
         */
        private static int displaySecurityMenu(Scanner scanner) {
            System.out.println("Which type of security do you want to implement?");
            System.out.println("1. Antivirus");
            System.out.println("2. Protection Feature");
            System.out.println("0. Previous Page");
            return scanner.nextInt();
        }


    private static void configureRAM (Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner){
        List<RAM> ramComponents = queryService.getRAMComponents(laptop);
        if (ramComponents.isEmpty()) {
            System.out.println("No RAM component found.");
            return;
        }

        System.out.println("Select a RAM from the list:");
        for (int i = 0; i < ramComponents.size(); i++) {
            RAM ram = ramComponents.get(i);
            System.out.println((i + 1) + ". " + ram.getRamName() + " - " + ram.getRamSize());
        }

        int ramChoice = scanner.nextInt();
        scanner.nextLine();

        if (ramChoice < 1 || ramChoice > ramComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        RAM selectedRAM = ramComponents.get(ramChoice - 1).clone();
        selectedRAM.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedRAM);

        System.out.println("You have added " + selectedRAM.getRamName() + " to your laptop.");
    }

    private static void configureCPU(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<CPU> cpuComponents = queryService.getCPUComponents(laptop);
    if (cpuComponents.isEmpty()) {
        System.out.println("No CPU found.");
        return;
    }

    System.out.println("Select a CPU from the list:");
    for (int i = 0; i < cpuComponents.size(); i++) {
        CPU cpu = cpuComponents.get(i);
        System.out.println((i + 1) + ". " + cpu.getCPUName() + " - " + cpu.getCpuSpeed());
    }

    int cpuChoice = scanner.nextInt();
    scanner.nextLine();

    if (cpuChoice < 1 || cpuChoice > cpuComponents.size()) {
        System.out.println("Invalid choice. Please try again.");
        return;
    }

    CPU selectedCPU = cpuComponents.get(cpuChoice - 1).clone();
    selectedCPU.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedCPU);

    System.out.println("You have added " + selectedCPU.getCPUName() + " to your laptop.");
}

    private static void configureDisplay(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Display> displayComponents = queryService.getDisplayComponents(laptop);
        if (displayComponents.isEmpty()) {
            System.out.println("No display found.");
            return;
        }

        System.out.println("Select a display from the list:");
        for (int i = 0; i < displayComponents.size(); i++) {
            Display display = displayComponents.get(i);
            System.out.println((i + 1) + ". Display: " + display.getDisplayName() + " - Resolution: " + display.getDisplayResolution());
        }

        int displayChoice = scanner.nextInt();
        scanner.nextLine();

        if (displayChoice < 1 || displayChoice > displayComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Display selectedDisplay = displayComponents.get(displayChoice - 1).clone();
        selectedDisplay.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedDisplay);

        System.out.println("You have added the display: " + selectedDisplay.getDisplayName() + " - " + selectedDisplay.getDisplayResolution());
    }

    private static void configureGraphicsCard(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<GraphicsCard> graphicsCards = queryService.getGraphicsCardComponents(laptop);
        if (graphicsCards.isEmpty()) {
            System.out.println("No graphics card found.");
            return;
        }

        System.out.println("Select a graphics card from the list:");
        for (int i = 0; i < graphicsCards.size(); i++) {
            GraphicsCard graphicsCard = graphicsCards.get(i);
            System.out.println((i + 1) + ". " + graphicsCard.getGraphicCardName() + " - Memory: " + graphicsCard.getGraphicsMemory());
        }

        int graphicsChoice = scanner.nextInt();
        scanner.nextLine();

        if (graphicsChoice < 1 || graphicsChoice > graphicsCards.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        GraphicsCard selectedGraphicsCard = graphicsCards.get(graphicsChoice - 1).clone();
        selectedGraphicsCard.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedGraphicsCard);

        System.out.println("You have added the graphics card: " + selectedGraphicsCard.getGraphicCardName() + " with " + selectedGraphicsCard.getGraphicsMemory() + " of memory.");
    }

    private static void configureOperatingSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<OperatingSystem> operatingSystemComponents = queryService.getOperatingSystemComponents(laptop);

        if (operatingSystemComponents.isEmpty()) {
            System.out.println("No operating system found.");
            return;
        }

        System.out.println("Select an operating system from the list:");
        for (int i = 0; i < operatingSystemComponents.size(); i++) {
            OperatingSystem os = operatingSystemComponents.get(i);
            System.out.println((i + 1) + ". " + os.getOsName() + " - Version: " + os.getOperatingSystemVersion());
        }

        int osChoice = scanner.nextInt();
        scanner.nextLine();

        if (osChoice < 1 || osChoice > operatingSystemComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        OperatingSystem selectedOS = operatingSystemComponents.get(osChoice - 1).clone();
        selectedOS.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedOS);

        System.out.println("You have added " + selectedOS.getOsName() + " to your laptop.");
    }

    private static void configureStorage(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Storage> storageComponents = queryService.getStorageComponents(laptop);

        if (storageComponents.isEmpty()) {
            System.out.println("No storage component found.");
            return;
        }

        System.out.println("Select a storage from the list:");
        for (int i = 0; i < storageComponents.size(); i++) {
            Storage storage = storageComponents.get(i);
            System.out.println((i + 1) + ". " + storage.getStorageName() + " - Capacity: " + storage.getStorageCapacity() + "GB");
        }

        int storageChoice = scanner.nextInt();
        scanner.nextLine();

        if (storageChoice < 1 || storageChoice > storageComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Storage selectedStorage = storageComponents.get(storageChoice - 1).clone();
        selectedStorage.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedStorage);

        System.out.println("You have added " + selectedStorage.getStorageName() + " to your laptop.");
    }

    private static void configureBattery(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Battery> batteryComponents = queryService.getBatteryComponents(laptop);
        if (batteryComponents.isEmpty()) {
            System.out.println("No battery found.");
            return;
        }

        System.out.println("Select a battery from the list:");
        for (int i = 0; i < batteryComponents.size(); i++) {
            Battery battery = batteryComponents.get(i);
            System.out.println((i + 1) + ". " + battery.getBatteryName() + " - Capacity: " + battery.getBatteryCapacity() + "mAh");
        }

        int batteryChoice = scanner.nextInt();
        scanner.nextLine();

        if (batteryChoice < 1 || batteryChoice > batteryComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Battery selectedBattery = batteryComponents.get(batteryChoice - 1).clone(laptop);
        selectedBattery.setBatteryOfLaptop(laptop);
        laptop.setBattery(selectedBattery);

        System.out.println("You have added the battery " + selectedBattery.getBatteryName() + " to your laptop.");
    }

    private static void configureColour(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Colour> colourOptions = queryService.getColourComponents(laptop);
        if (colourOptions.isEmpty()) {
            System.out.println("No colour available.");
            return;
        }

        System.out.println("Select a colour from the list:");
        for (int i = 0; i < colourOptions.size(); i++) {
            Colour colour = colourOptions.get(i);
            System.out.println((i + 1) + ". " + colour.getColourName());
        }

        int colourChoice = scanner.nextInt();
        scanner.nextLine();

        if (colourChoice < 1 || colourChoice > colourOptions.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Colour selectedColour = colourOptions.get(colourChoice - 1).clone(laptop);
        selectedColour.setColourOfLaptop(laptop);
        laptop.setColour(selectedColour);

        System.out.println("You have chosen the colour " + selectedColour.getColourName() + " for your laptop.");
    }

    private static void configureCoolingSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<CoolingSystem> coolingSystems = queryService.getCoolingSystemComponents(laptop);
        if (coolingSystems.isEmpty()) {
            System.out.println("No cooling system available.");
            return;
        }

        System.out.println("Select a cooling system from the list:");
        for (int i = 0; i < coolingSystems.size(); i++) {
            CoolingSystem coolingSystem = coolingSystems.get(i);
            System.out.println((i + 1) + ". " + coolingSystem.getCoolingSystemName() + " - Type: " + coolingSystem.getCoolingSystemType());
        }

        int coolingSystemChoice = scanner.nextInt();
        scanner.nextLine();

        if (coolingSystemChoice < 1 || coolingSystemChoice > coolingSystems.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        CoolingSystem selectedCoolingSystem = coolingSystems.get(coolingSystemChoice - 1).clone(laptop);
        selectedCoolingSystem.setCoolingSystemOfLaptop(laptop);
        laptop.setCoolingSystem(selectedCoolingSystem);

        System.out.println("You have added the cooling system " + selectedCoolingSystem.getCoolingSystemName() + " to your laptop.");
    }

    private static void configureWarranty(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Warranty> warrantyOptions = queryService.getWarrantyComponents(laptop);
        if (warrantyOptions.isEmpty()) {
            System.out.println("No warranty available.");
            return;
        }

        System.out.println("Select a warranty from the list:");
        for (int i = 0; i < warrantyOptions.size(); i++) {
            Warranty warranty = warrantyOptions.get(i);
            System.out.println((i + 1) + ". " + warranty.getWarrantyName() + " - Period: " + warranty.getWarrantyPeriod() + " years");
        }

        int warrantyChoice = scanner.nextInt();
        scanner.nextLine();

        if (warrantyChoice < 1 || warrantyChoice > warrantyOptions.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Warranty selectedWarranty = warrantyOptions.get(warrantyChoice - 1).clone(laptop);
        selectedWarranty.setLaptopOfWarranty(laptop);
        laptop.setWarranty(selectedWarranty);

        System.out.println("You have chosen the warranty " + selectedWarranty.getWarrantyName() + " for your laptop.");
    }

    private static void configureAudioSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<AudioSystem> audioSystemComponents = queryService.getAudioSystemComponents(laptop);
        if (audioSystemComponents.isEmpty()) {
            System.out.println("No audio system found.");
            return;
        }

        System.out.println("Select an audio system from the list:");
        for (int i = 0; i < audioSystemComponents.size(); i++) {
            AudioSystem audioSystem = audioSystemComponents.get(i);
            System.out.println((i + 1) + ". " + audioSystem.getAudioSystemName() + " - Type: " + audioSystem.getAudioSystemType());
        }

        int audioChoice = scanner.nextInt();
        scanner.nextLine();

        if (audioChoice < 1 || audioChoice > audioSystemComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        AudioSystem selectedAudioSystem = audioSystemComponents.get(audioChoice - 1).clone(laptop);
        selectedAudioSystem.setAudioSystemOfLaptop(laptop);
        laptop.setAudioSystem(selectedAudioSystem);

        System.out.println("You have added the audio system " + selectedAudioSystem.getAudioSystemName() + " to your laptop.");
    }

    private static void configureExternalMonitor(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<ExternalMonitor> monitorComponents = queryService.getExternalMonitorComponents(laptop);
        if (monitorComponents.isEmpty()) {
            System.out.println("No external monitor found.");
            return;
        }

        System.out.println("Select an external monitor from the list:");
        for (int i = 0; i < monitorComponents.size(); i++) {
            ExternalMonitor monitor = monitorComponents.get(i);
            System.out.println((i + 1) + ". " + monitor.getExMonitorName() + " - Resolution: " + monitor.getExternalDisplayResolution() + " - Connection: " + monitor.getConnectionType());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > monitorComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        ExternalMonitor selectedMonitor = monitorComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePeripheral(selectedMonitor);
        System.out.println("You have added " + selectedMonitor.getExMonitorName() + " to your laptop.");
    }

    private static void configureExternalSpeaker(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<ExternalSpeaker> speakerComponents = queryService.getExternalSpeakerComponents(laptop);
        if (speakerComponents.isEmpty()) {
            System.out.println("No external speaker found.");
            return;
        }

        System.out.println("Select an external speaker from the list:");
        for (int i = 0; i < speakerComponents.size(); i++) {
            ExternalSpeaker speaker = speakerComponents.get(i);
            System.out.println((i + 1) + ". " + speaker.getExSpeakerName() + " - Type: " + speaker.getExternalAudioSystemType() + " - Connection: " + speaker.getConnectionType());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > speakerComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        ExternalSpeaker selectedSpeaker = speakerComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePeripheral(selectedSpeaker);
        System.out.println("You have added " + selectedSpeaker.getExSpeakerName() + " to your laptop.");
    }

    private static void configureKeyboard(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Keyboard> keyboardComponents = queryService.getKeyboardComponents(laptop);
        if (keyboardComponents.isEmpty()) {
            System.out.println("No keyboard found.");
            return;
        }

        System.out.println("Select a keyboard from the list:");
        for (int i = 0; i < keyboardComponents.size(); i++) {
            Keyboard keyboard = keyboardComponents.get(i);
            System.out.println((i + 1) + ". " + keyboard.getKeyboardName() + " - Layout: " + keyboard.getKeyboardLayout() + " - Connection: " + keyboard.getConnectionType());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > keyboardComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Keyboard selectedKeyboard = keyboardComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePeripheral(selectedKeyboard);
        System.out.println("You have added " + selectedKeyboard.getKeyboardName() + " to your laptop.");
    }

    private static void configureMouse(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Mouse> mouseComponents = queryService.getMouseComponents(laptop);
        if (mouseComponents.isEmpty()) {
            System.out.println("No mouse found.");
            return;
        }

        System.out.println("Select a mouse from the list:");
        for (int i = 0; i < mouseComponents.size(); i++) {
            Mouse mouse = mouseComponents.get(i);
            System.out.println((i + 1) + ". " + mouse.getMouseName() + " - Type: " + mouse.getMouseType() + " - Connection: " + mouse.getConnectionType());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > mouseComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Mouse selectedMouse = mouseComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePeripheral(selectedMouse);
        System.out.println("You have added " + selectedMouse.getMouseName() + " to your laptop.");
    }

    private static void configureWebcam(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Webcam> webcamComponents = queryService.getWebcamComponents(laptop);
        if (webcamComponents.isEmpty()) {
            System.out.println("No webcam found.");
            return;
        }

        System.out.println("Select a webcam from the list:");
        for (int i = 0; i < webcamComponents.size(); i++) {
            Webcam webcam = webcamComponents.get(i);
            System.out.println((i + 1) + ". " + webcam.getWebcamName() + " - Resolution: " + webcam.getWebcamResolution() + " - Connection: " + webcam.getConnectionType());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > webcamComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Webcam selectedWebcam = webcamComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePeripheral(selectedWebcam);
        System.out.println("You have added " + selectedWebcam.getWebcamName() + " to your laptop.");
    }

    private static void configureEthernet(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Ethernet> ethernetComponents = queryService.getEthernetComponents(laptop);
        long existingPortsCount = laptop.getPorts().stream()
                .filter(port -> port instanceof Port)
                .count();

        if (ethernetComponents.isEmpty()) {
            System.out.println("No Ethernet ports found.");
            return;
        }

        System.out.println("Select an Ethernet port from the list:");
        for (int i = 0; i < ethernetComponents.size(); i++) {
            Ethernet ethernet = ethernetComponents.get(i);
            System.out.println((i + 1) + ". For Port: " + (existingPortsCount + 1) + " - Name: " + ethernet.getEthernetName() + " - Speed: " + ethernet.getEthernetSpeed());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > ethernetComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Ethernet selectedEthernet = ethernetComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePort(selectedEthernet);

        System.out.println("You have added the Ethernet port " + selectedEthernet.getPortName() + " with speed " + selectedEthernet.getEthernetSpeed() + " to your laptop.");
    }

    private static void configureUSB(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<USB> usbComponents = queryService.getUSBComponents(laptop);
        long existingPortsCount = laptop.getPorts().stream()
                .filter(port -> port instanceof Port)
                .count();

        if (usbComponents.isEmpty()) {
            System.out.println("No USB ports found.");
            return;
        }

        System.out.println("Select a USB port from the list:");
        for (int i = 0; i < usbComponents.size(); i++) {
            USB usb = usbComponents.get(i);
            System.out.println((i + 1) + ". Port: " + (existingPortsCount + 1) + " - Name: " + usb.getUsbName() + " - Version: " + usb.getUsbVersion());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > usbComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        USB selectedUSB = usbComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePort(selectedUSB);

        System.out.println("You have added the USB port " + selectedUSB.getPortName() + " with version " + selectedUSB.getUsbVersion() + " to your laptop.");
    }

    private static void configureHDMI(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<HDMI> hdmiComponents = queryService.getHDMIComponents(laptop);
        long existingPortsCount = laptop.getPorts().stream()
                .filter(port -> port instanceof Port)
                .count();

        if (hdmiComponents.isEmpty()) {
            System.out.println("No HDMI ports found.");
            return;
        }

        System.out.println("Select an HDMI port from the list:");
        for (int i = 0; i < hdmiComponents.size(); i++) {
            HDMI hdmi = hdmiComponents.get(i);
            System.out.println((i + 1) + ". Port: " + (existingPortsCount + 1) + " - Name: " + hdmi.getHDMIName() + " - Version: " + hdmi.getHDMIVersion());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > hdmiComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        HDMI selectedHDMI = hdmiComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplacePort(selectedHDMI);

        System.out.println("You have added the HDMI port " + selectedHDMI.getPortName() + " with version " + selectedHDMI.getHDMIVersion() + " to your laptop.");
    }

    private static void configureAntivirus(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Antivirus> antivirusComponents = queryService.getAntivirusComponents(laptop);
        if (antivirusComponents.isEmpty()) {
            System.out.println("No antivirus found.");
            return;
        }

        System.out.println("Select an antivirus from the list:");
        for (int i = 0; i < antivirusComponents.size(); i++) {
            Antivirus antivirus = antivirusComponents.get(i);
            System.out.println((i + 1) + ". " + antivirus.getAntivirusName() + " - Version: " + antivirus.getAntivirusVersion());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > antivirusComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Antivirus selectedAntivirus = antivirusComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplaceSecurity(selectedAntivirus);

        System.out.println("You have added the antivirus " + selectedAntivirus.getAntivirusName() + " to your laptop.");
    }

    private static void configureProtectionFeature(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<ProtectionFeature> protectionFeatureComponents = queryService.getProtectionFeatureComponents(laptop);
        if (protectionFeatureComponents.isEmpty()) {
            System.out.println("No protection feature found.");
            return;
        }

        System.out.println("Select a protection feature from the list:");
        for (int i = 0; i < protectionFeatureComponents.size(); i++) {
            ProtectionFeature protectionFeature = protectionFeatureComponents.get(i);
            System.out.println((i + 1) + ". " + protectionFeature.getProtectionFeatureName() + " - Type: " + protectionFeature.getTypeProtectionFeature());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > protectionFeatureComponents.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        ProtectionFeature selectedProtectionFeature = protectionFeatureComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplaceSecurity(selectedProtectionFeature);

        System.out.println("You have added the protection feature " + selectedProtectionFeature.getProtectionFeatureName() + " to your laptop.");
    }

    /**
     * Displays the final configuration of the laptop, showing all selected components.
     *
     * @param laptop The laptop whose configuration will be displayed
     */
    private static void displayFinalConfiguration(Laptop laptop) {
        String separator = "----------------------------------------";

        System.out.println(separator);
        System.out.println("Final configuration of the laptop: " + laptop.getLaptopName());
        System.out.println(separator);

        // Audio System
        if (laptop.getAudioSystem() != null) {
            AudioSystem audioSystem = laptop.getAudioSystem();
            System.out.println("[Audio System]");
            System.out.printf("  Name: %s%n  Type: %s%n", audioSystem.getAudioSystemName(), audioSystem.getAudioSystemType());
            System.out.println(separator);
        }

        // Battery
        if (laptop.getBattery() != null) {
            Battery battery = laptop.getBattery();
            System.out.println("[Battery]");
            System.out.printf("  Name: %s%n  Capacity: %.2f mAh%n", battery.getBatteryName(), battery.getBatteryCapacity());
            System.out.println(separator);
        }

        // Colour
        if (laptop.getColour() != null) {
            Colour colour = laptop.getColour();
            System.out.println("[Colour]");
            System.out.printf("  Name: %s%n", colour.getColourName());
            System.out.println(separator);
        }

        // Components
        if (!laptop.getComponents().isEmpty()) {
            System.out.println("[Components]");
            for (Component component : laptop.getComponents()) {
                if (component instanceof RAM) {
                    RAM ram = (RAM) component;
                    System.out.printf("  RAM: %s  -  Size: %s%n", ram.getRamName(), ram.getRamSize());
                } else if (component instanceof CPU) {
                    CPU cpu = (CPU) component;
                    System.out.printf("  CPU: %s  -  Speed: %s%n", cpu.getCPUName(), cpu.getCpuSpeed());
                } else if (component instanceof Display) {
                    Display display = (Display) component;
                    System.out.printf("  Display: %s  -  Resolution: %s%n", display.getDisplayName(), display.getDisplayResolution());
                } else if (component instanceof GraphicsCard) {
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    System.out.printf("  Graphics Card: %s  -  Memory: %s%n", graphicsCard.getGraphicCardName(), graphicsCard.getGraphicsMemory());
                } else if (component instanceof OperatingSystem) {
                    OperatingSystem os = (OperatingSystem) component;
                    System.out.printf("  Operating System: %s  -  Version: %s%n", os.getOsName(), os.getOperatingSystemVersion());
                } else if (component instanceof Storage) {
                    Storage storage = (Storage) component;
                    System.out.printf("  Storage: %s  -  Capacity: %s%n", storage.getStorageName(), storage.getStorageCapacity());
                }
            }
            System.out.println(separator);
        }

        // Cooling System
        if (laptop.getCoolingSystem() != null) {
            CoolingSystem coolingSystem = laptop.getCoolingSystem();
            System.out.println("[Cooling System]");
            System.out.printf("  Name: %s  -  Type: %s%n", coolingSystem.getCoolingSystemName(), coolingSystem.getCoolingSystemType());
            System.out.println(separator);
        }

        // Warranty
        if (laptop.getWarranty() != null) {
            Warranty warranty = laptop.getWarranty();
            System.out.println("[Warranty]");
            System.out.printf("  Name: %s  -  Duration: %d years%n", warranty.getWarrantyName(), warranty.getWarrantyPeriod());
            System.out.println(separator);
        }

        // Peripherals
        if (!laptop.getPeripherals().isEmpty()) {
            System.out.println("[Peripherals]");
            for (Peripheral peripheral : laptop.getPeripherals()) {
                if (peripheral instanceof ExternalMonitor) {
                    ExternalMonitor monitor = (ExternalMonitor) peripheral;
                    System.out.printf("  External Monitor: %s  -  Resolution: %s%n", monitor.getExMonitorName(), monitor.getExternalDisplayResolution());
                } else if (peripheral instanceof ExternalSpeaker) {
                    ExternalSpeaker speaker = (ExternalSpeaker) peripheral;
                    System.out.printf("  External Speaker: %s  -  Type: %s%n", speaker.getExSpeakerName(), speaker.getExternalAudioSystemType());
                } else if (peripheral instanceof Keyboard) {
                    Keyboard keyboard = (Keyboard) peripheral;
                    System.out.printf("  Keyboard: %s  -  Layout: %s%n", keyboard.getKeyboardName(), keyboard.getKeyboardLayout());
                } else if (peripheral instanceof Mouse) {
                    Mouse mouse = (Mouse) peripheral;
                    System.out.printf("  Mouse: %s  -  Type: %s%n", mouse.getMouseName(), mouse.getMouseType());
                } else if (peripheral instanceof Webcam) {
                    Webcam webcam = (Webcam) peripheral;
                    System.out.printf("  Webcam: %s  -  Resolution: %s%n", webcam.getWebcamName(), webcam.getWebcamResolution());
                }
            }
            System.out.println(separator);
        }

        // Ports
        if (!laptop.getPorts().isEmpty()) {
            System.out.println("[Ports]");
            for (Port port : laptop.getPorts()) {
                if (port instanceof Ethernet) {
                    Ethernet ethernet = (Ethernet) port;
                    System.out.printf("  Ethernet - Port No.%s  -  Name: %s  -  Speed: %s%n", ethernet.getPortName(), ethernet.getEthernetName(), ethernet.getEthernetSpeed());
                } else if (port instanceof USB) {
                    USB usb = (USB) port;
                    System.out.printf("  USB - Port No.%s  -  Name: %s  -  Version: %s%n", usb.getPortName(), usb.getUsbName(), usb.getUsbVersion());
                } else if (port instanceof HDMI) {
                    HDMI hdmi = (HDMI) port;
                    System.out.printf("  HDMI - Port No.%s  -  Name: %s  -  Version: %s%n", hdmi.getPortName(), hdmi.getHDMIName(), hdmi.getHDMIVersion());
                } else {
                    System.out.printf("  Unknown Port: %s%n", port.getPortName());
                }
            }
            System.out.println(separator);
        }

        // Security
        if (!laptop.getSecurities().isEmpty()) {
            System.out.println("[Security]");
            for (Security security : laptop.getSecurities()) {
                if (security instanceof Antivirus) {
                    Antivirus antivirus = (Antivirus) security;
                    System.out.printf("  Antivirus: %s  -  Version: %s%n", antivirus.getAntivirusName(), antivirus.getAntivirusVersion());
                } else if (security instanceof ProtectionFeature) {
                    ProtectionFeature protection = (ProtectionFeature) security;
                    System.out.printf("  Protection: %s  -  Type: %s%n", protection.getProtectionFeatureName(), protection.getTypeProtectionFeature());
                }
            }
            System.out.println(separator);
        }

        System.out.println("Configuration complete.");
        System.out.println(separator);
    }



}

