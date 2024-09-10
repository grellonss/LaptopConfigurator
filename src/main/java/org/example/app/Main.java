package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.LaptopComponentQueryService;
import org.example.ontology.OntologyLoader;
import org.example.ontology.SPARQLQueryExecutor;

import java.util.*;

    public class Main {
        public static void main(String[] args) {
            // Step 1: Carica l'ontologia
            String ontologyFilePath = "LaptopConfigModellazione.rdf";
            OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
            OntModel model = ontologyLoader.getOntologyModel();

            // Verifica che l'ontologia sia stata caricata correttamente
            if (model != null) {
                SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
                LaptopComponentQueryService queryService = new LaptopComponentQueryService(queryExecutor);

                Scanner scanner = new Scanner(System.in);
                Laptop laptop = createLaptop(scanner);

                // Step 3: Gestisci la configurazione del laptop
                configureLaptop(laptop, queryService, scanner);

                // Mostra la configurazione finale
                displayFinalConfiguration(laptop);
            } else {
                System.out.println("Errore nel caricamento dell'ontologia.");
            }
        }

        private static Laptop createLaptop(Scanner scanner) {
            System.out.print("Inserisci il nome del laptop: ");
            String laptopName = scanner.nextLine();
            return new Laptop(laptopName);
        }

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
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }

        // Main menu
        private static int displayMainMenu(Scanner scanner) {
            System.out.println("Cosa vuoi configurare? Seleziona un'opzione digitando il numero:");
            System.out.println("1. Sistema Audio");
            System.out.println("2. Batteria");
            System.out.println("3. Colore");
            System.out.println("4. Componenti");
            System.out.println("5. Sistema Raffreddamento");
            System.out.println("6. Periferiche");
            System.out.println("7. Porte");
            System.out.println("8. Sicurezza");
            System.out.println("9. Garanzia");
            System.out.println("0. Fine configurazione");

            return scanner.nextInt();
        }

        // Configurazione componenti
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
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }

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

        // Configurazione delle periferiche
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

        private static int displayPeripheralMenu(Scanner scanner) {
            System.out.println("Quale periferica vuoi selezionare?");
            System.out.println("1. Monitor Esterno");
            System.out.println("2. Speaker Esterno");
            System.out.println("3. Tastiera");
            System.out.println("4. Mouse");
            System.out.println("5. Videocamera");
            System.out.println("0. Pagina Precedente");
            return scanner.nextInt();
        }

        // Configurazione delle porte
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
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }

        private static int displayPortMenu(Scanner scanner) {
            System.out.println("Che tipo di porta vuoi selezionare?");
            System.out.println("1. Ethernet");
            System.out.println("2. HDMI");
            System.out.println("3. USB");
            System.out.println("0. Pagina Precedente");
            return scanner.nextInt();
        }

        // Configurazione delle opzioni di sicurezza
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
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }

        private static int displaySecurityMenu(Scanner scanner) {
            System.out.println("Quale tipologia di sicurezza vuoi implementare?");
            System.out.println("1. Antivirus");
            System.out.println("2. Funzione di protezione");
            System.out.println("0. Pagina Precedente");
            return scanner.nextInt();
        }


        // Metodo per configurare la RAM
    private static void configureRAM (Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner){
        List<RAM> ramComponents = queryService.getRAMComponents(laptop);
        if (ramComponents.isEmpty()) {
            System.out.println("Nessun componente RAM trovato.");
            return;
        }

        System.out.println("Seleziona una RAM dalla lista:");
        for (int i = 0; i < ramComponents.size(); i++) {
            RAM ram = ramComponents.get(i);
            System.out.println((i + 1) + ". " + ram.getRamName() + " - " + ram.getRamSize() + "GB");
        }

        int ramChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (ramChoice < 1 || ramChoice > ramComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona la RAM scelta e assegnala al laptop
        RAM selectedRAM = ramComponents.get(ramChoice - 1).clone();
        selectedRAM.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedRAM);

        System.out.println("Hai aggiunto " + selectedRAM.getRamName() + " al tuo laptop.");
    }

    // Metodo per configurare la CPU
    private static void configureCPU(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<CPU> cpuComponents = queryService.getCPUComponents(laptop); // Devi implementare il metodo getCPUComponents()
    if (cpuComponents.isEmpty()) {
        System.out.println("Nessuna CPU trovata.");
        return;
    }

    System.out.println("Seleziona una CPU dalla lista:");
    for (int i = 0; i < cpuComponents.size(); i++) {
        CPU cpu = cpuComponents.get(i);
        System.out.println((i + 1) + ". " + cpu.getCPUName() + " - " + cpu.getCpuSpeed());
    }

    int cpuChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (cpuChoice < 1 || cpuChoice > cpuComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la CPU scelta e assegnala al laptop
    CPU selectedCPU = cpuComponents.get(cpuChoice - 1).clone();
    selectedCPU.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedCPU);

    System.out.println("Hai aggiunto " + selectedCPU.getCPUName() + " al tuo laptop.");
}

    // Metodo per configurare il Display
    private static void configureDisplay(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Display> displayComponents = queryService.getDisplayComponents(laptop);
        if (displayComponents.isEmpty()) {
            System.out.println("Nessun display trovato.");
            return;
        }

        // Mostra la lista dei display
        System.out.println("Seleziona un Display dalla lista:");
        for (int i = 0; i < displayComponents.size(); i++) {
            Display display = displayComponents.get(i);
            System.out.println((i + 1) + ". Display: " + display.getDisplayName() + " - Risoluzione: " + display.getDisplayResolution());
        }

        int displayChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (displayChoice < 1 || displayChoice > displayComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona il display scelto e assegnalo al laptop
        Display selectedDisplay = displayComponents.get(displayChoice - 1).clone();
        selectedDisplay.setLaptopOfComponents(laptop);  // Imposta il laptop associato
        laptop.addOrReplaceComponent(selectedDisplay);

        System.out.println("Hai aggiunto il display: " + selectedDisplay.getDisplayName() + " - " + selectedDisplay.getDisplayResolution());
    }

    // Metodo per configurare la Graphics Card
    private static void configureGraphicsCard(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<GraphicsCard> graphicsCards = queryService.getGraphicsCardComponents(laptop);
        if (graphicsCards.isEmpty()) {
            System.out.println("Nessuna scheda grafica trovata.");
            return;
        }

        // Mostra la lista delle schede grafiche
        System.out.println("Seleziona una Scheda Grafica dalla lista:");
        for (int i = 0; i < graphicsCards.size(); i++) {
            GraphicsCard graphicsCard = graphicsCards.get(i);
            System.out.println((i + 1) + ". " + graphicsCard.getGraphicCardName() + " - Memoria: " + graphicsCard.getGraphicsMemory());
        }

        int graphicsChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (graphicsChoice < 1 || graphicsChoice > graphicsCards.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona la scheda grafica scelta e assegnala al laptop
        GraphicsCard selectedGraphicsCard = graphicsCards.get(graphicsChoice - 1).clone();
        selectedGraphicsCard.setLaptopOfComponents(laptop);  // Imposta il laptop associato
        laptop.addOrReplaceComponent(selectedGraphicsCard);

        System.out.println("Hai aggiunto la scheda grafica: " + selectedGraphicsCard.getGraphicCardName() + " con " + selectedGraphicsCard.getGraphicsMemory() + " di memoria.");
    }

    // Metodo per configurare il sistema operativo (OperatingSystem)
    private static void configureOperatingSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<OperatingSystem> operatingSystemComponents = queryService.getOperatingSystemComponents(laptop);

        if (operatingSystemComponents.isEmpty()) {
            System.out.println("Nessun sistema operativo trovato.");
            return;
        }

        System.out.println("Seleziona un sistema operativo dalla lista:");
        for (int i = 0; i < operatingSystemComponents.size(); i++) {
            OperatingSystem os = operatingSystemComponents.get(i);
            System.out.println((i + 1) + ". " + os.getOSName() + " - Versione: " + os.getOperatingSystemVersion());
        }

        int osChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (osChoice < 1 || osChoice > operatingSystemComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona il sistema operativo scelto e assegnalo al laptop
        OperatingSystem selectedOS = operatingSystemComponents.get(osChoice - 1).clone();
        selectedOS.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedOS);

        System.out.println("Hai aggiunto " + selectedOS.getOSName() + " al tuo laptop.");
    }

    // Metodo per configurare lo storage (Storage)
    private static void configureStorage(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Storage> storageComponents = queryService.getStorageComponents(laptop);

        if (storageComponents.isEmpty()) {
            System.out.println("Nessun componente di storage trovato.");
            return;
        }

        System.out.println("Seleziona uno storage dalla lista:");
        for (int i = 0; i < storageComponents.size(); i++) {
            Storage storage = storageComponents.get(i);
            System.out.println((i + 1) + ". " + storage.getStorageName() + " - Capacità: " + storage.getStorageCapacity() + "GB");
        }

        int storageChoice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (storageChoice < 1 || storageChoice > storageComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona lo storage scelto e assegnalo al laptop
        Storage selectedStorage = storageComponents.get(storageChoice - 1).clone();
        selectedStorage.setLaptopOfComponents(laptop);
        laptop.addOrReplaceComponent(selectedStorage);

        System.out.println("Hai aggiunto " + selectedStorage.getStorageName() + " al tuo laptop.");
    }

    private static void configureBattery(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Battery> batteryComponents = queryService.getBatteryComponents(laptop);
    if (batteryComponents.isEmpty()) {
        System.out.println("Nessuna batteria trovata.");
        return;
    }

    System.out.println("Seleziona una batteria dalla lista:");
    for (int i = 0; i < batteryComponents.size(); i++) {
        Battery battery = batteryComponents.get(i);
        System.out.println((i + 1) + ". " + battery.getBatteryName() + " - Capacity: " + battery.getBatteryCapacity() + "mAh");
    }

    int batteryChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (batteryChoice < 1 || batteryChoice > batteryComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la batteria scelta e assegnala al laptop
    Battery selectedBattery = batteryComponents.get(batteryChoice - 1).clone(laptop);
    selectedBattery.setBatteryOfLaptop(laptop);
    laptop.setBattery(selectedBattery);

    System.out.println("Hai aggiunto la batteria " + selectedBattery.getBatteryName() + " al tuo laptop.");
}

    private static void configureColour(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Colour> colourOptions = queryService.getColourComponents(laptop);
    if (colourOptions.isEmpty()) {
        System.out.println("Nessun colore disponibile.");
        return;
    }

    System.out.println("Seleziona un colore dalla lista:");
    for (int i = 0; i < colourOptions.size(); i++) {
        Colour colour = colourOptions.get(i);
        System.out.println((i + 1) + ". " + colour.getColourName());
    }

    int colourChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (colourChoice < 1 || colourChoice > colourOptions.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona il colore scelto e assegnalo al laptop
    Colour selectedColour = colourOptions.get(colourChoice - 1).clone(laptop);
    selectedColour.setColourOfLaptop(laptop);
    laptop.setColour(selectedColour);

    System.out.println("Hai scelto il colore " + selectedColour.getColourName() + " per il tuo laptop.");
}

    private static void configureCoolingSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<CoolingSystem> coolingSystems = queryService.getCoolingSystemComponents(laptop);
    if (coolingSystems.isEmpty()) {
        System.out.println("Nessun sistema di raffreddamento disponibile.");
        return;
    }

    System.out.println("Seleziona un sistema di raffreddamento dalla lista:");
    for (int i = 0; i < coolingSystems.size(); i++) {
        CoolingSystem coolingSystem = coolingSystems.get(i);
        System.out.println((i + 1) + ". " + coolingSystem.getCoolingSystemName() + " - Tipo: " + coolingSystem.getCoolingSystemType());
    }

    int coolingSystemChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (coolingSystemChoice < 1 || coolingSystemChoice > coolingSystems.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona il sistema di raffreddamento scelto e assegnalo al laptop
    CoolingSystem selectedCoolingSystem = coolingSystems.get(coolingSystemChoice - 1).clone(laptop);
    selectedCoolingSystem.setCoolingSystemOfLaptop(laptop);
    laptop.setCoolingSystem(selectedCoolingSystem);

    System.out.println("Hai aggiunto il sistema di raffreddamento " + selectedCoolingSystem.getCoolingSystemName() + " al tuo laptop.");
}

    private static void configureWarranty(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Warranty> warrantyOptions = queryService.getWarrantyComponents(laptop);
    if (warrantyOptions.isEmpty()) {
        System.out.println("Nessuna garanzia disponibile.");
        return;
    }

    System.out.println("Seleziona una garanzia dalla lista:");
    for (int i = 0; i < warrantyOptions.size(); i++) {
        Warranty warranty = warrantyOptions.get(i);
        System.out.println((i + 1) + ". " + warranty.getWarrantyName() + " - Periodo: " + warranty.getWarrantyPeriod() + " anni");
    }

    int warrantyChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (warrantyChoice < 1 || warrantyChoice > warrantyOptions.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la garanzia scelta e assegnala al laptop
    Warranty selectedWarranty = warrantyOptions.get(warrantyChoice - 1).clone(laptop);
    selectedWarranty.setLaptopOfWarranty(laptop);
    laptop.setWarranty(selectedWarranty);

    System.out.println("Hai scelto la garanzia " + selectedWarranty.getWarrantyName() + " per il tuo laptop.");
}

    private static void configureAudioSystem(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<AudioSystem> audioSystemComponents = queryService.getAudioSystemComponents(laptop);
    if (audioSystemComponents.isEmpty()) {
        System.out.println("Nessun sistema audio trovato.");
        return;
    }

    System.out.println("Seleziona un sistema audio dalla lista:");
    for (int i = 0; i < audioSystemComponents.size(); i++) {
        AudioSystem audioSystem = audioSystemComponents.get(i);
        System.out.println((i + 1) + ". " + audioSystem.getAudioSystemName() + " - Tipo: " + audioSystem.getAudioSystemType());
    }

    int audioChoice = scanner.nextInt();
    scanner.nextLine(); // Consuma newline

    if (audioChoice < 1 || audioChoice > audioSystemComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona il sistema audio scelto e assegnalo al laptop
    AudioSystem selectedAudioSystem = audioSystemComponents.get(audioChoice - 1).clone(laptop);
    selectedAudioSystem.setAudioSystemOfLaptop(laptop);
    laptop.setAudioSystem(selectedAudioSystem);

    System.out.println("Hai aggiunto il sistema audio " + selectedAudioSystem.getAudioSystemName() + " al tuo laptop.");
}

// Metodo per configurare i monitor esterni
    private static void configureExternalMonitor(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<ExternalMonitor> monitorComponents = queryService.getExternalMonitorComponents(laptop);
    if (monitorComponents.isEmpty()) {
        System.out.println("Nessun monitor esterno trovato.");
        return;
    }

    System.out.println("Seleziona un monitor esterno dalla lista:");
    for (int i = 0; i < monitorComponents.size(); i++) {
        ExternalMonitor monitor = monitorComponents.get(i);
        System.out.println((i + 1) + ". " + monitor.getExMonitorName() + " - Risoluzione: " + monitor.getExternalDisplayResolution()+ " - Connessione: " + monitor.getConnectionType());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > monitorComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    ExternalMonitor selectedMonitor = monitorComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePeripheral(selectedMonitor);
    System.out.println("Hai aggiunto " + selectedMonitor.getExMonitorName() + " al tuo laptop.");
}

// Metodo per configurare gli altoparlanti esterni
    private static void configureExternalSpeaker(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<ExternalSpeaker> speakerComponents = queryService.getExternalSpeakerComponents(laptop);
    if (speakerComponents.isEmpty()) {
        System.out.println("Nessun altoparlante esterno trovato.");
        return;
    }

    System.out.println("Seleziona un altoparlante esterno dalla lista:");
    for (int i = 0; i < speakerComponents.size(); i++) {
        ExternalSpeaker speaker = speakerComponents.get(i);
        System.out.println((i + 1) + ". " + speaker.getExSpeakerName() + " - Tipo: " + speaker.getExternalAudioSystemType()+ " - Connessione: " + speaker.getConnectionType());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > speakerComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    ExternalSpeaker selectedSpeaker = speakerComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePeripheral(selectedSpeaker);
    System.out.println("Hai aggiunto " + selectedSpeaker.getExSpeakerName() + " al tuo laptop.");
}

// Metodo per configurare le tastiere
    private static void configureKeyboard(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Keyboard> keyboardComponents = queryService.getKeyboardComponents(laptop);
    if (keyboardComponents.isEmpty()) {
        System.out.println("Nessuna tastiera trovata.");
        return;
    }

    System.out.println("Seleziona una tastiera dalla lista:");
    for (int i = 0; i < keyboardComponents.size(); i++) {
        Keyboard keyboard = keyboardComponents.get(i);
        System.out.println((i + 1) + ". " + keyboard.getKeyboardName() + " - Layout: " + keyboard.getKeyboardLayout()+ " - Connessione: " + keyboard.getConnectionType());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > keyboardComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    Keyboard selectedKeyboard = keyboardComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePeripheral(selectedKeyboard);
    System.out.println("Hai aggiunto " + selectedKeyboard.getKeyboardName() + " al tuo laptop.");
}

// Metodo per configurare i mouse
    private static void configureMouse(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Mouse> mouseComponents = queryService.getMouseComponents(laptop);
    if (mouseComponents.isEmpty()) {
        System.out.println("Nessun mouse trovato.");
        return;
    }

    System.out.println("Seleziona un mouse dalla lista:");
    for (int i = 0; i < mouseComponents.size(); i++) {
        Mouse mouse = mouseComponents.get(i);
        System.out.println((i + 1) + ". " + mouse.getMouseName() + " - Tipo: " + mouse.getMouseType()+ " - Connessione: " + mouse.getConnectionType());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > mouseComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    Mouse selectedMouse = mouseComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePeripheral(selectedMouse);
    System.out.println("Hai aggiunto " + selectedMouse.getMouseName() + " al tuo laptop.");
}

// Metodo per configurare le webcam
    private static void configureWebcam(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    List<Webcam> webcamComponents = queryService.getWebcamComponents(laptop);
    if (webcamComponents.isEmpty()) {
        System.out.println("Nessuna webcam trovata.");
        return;
    }

    System.out.println("Seleziona una webcam dalla lista:");
    for (int i = 0; i < webcamComponents.size(); i++) {
        Webcam webcam = webcamComponents.get(i);
        System.out.println((i + 1) + ". " + webcam.getWebcamName() + " - Risoluzione: " + webcam.getWebcamResolution()+ " - Connessione: " + webcam.getConnectionType());
    }

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice < 1 || choice > webcamComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    Webcam selectedWebcam = webcamComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePeripheral(selectedWebcam);
    System.out.println("Hai aggiunto " + selectedWebcam.getWebcamName() + " al tuo laptop.");
}

    private static void configureEthernet(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    // Ottieni le porte Ethernet disponibili dall'ontologia
    List<Ethernet> ethernetComponents = queryService.getEthernetComponents(laptop);
    // Ottieni il numero di oggetti di tipo Port già aggiunti al laptop
    long existingPortsCount = laptop.getPorts().stream()
            .filter(port -> port instanceof Port)  // Filtra solo gli oggetti di tipo Port
            .count();

    if (ethernetComponents.isEmpty()) {
        System.out.println("Nessuna porta Ethernet trovata.");
        return;
    }

    // Mostra la lista delle porte Ethernet
    System.out.println("Seleziona una porta Ethernet dalla lista:");
    for (int i = 0; i < ethernetComponents.size(); i++) {
        Ethernet ethernet = ethernetComponents.get(i);
        System.out.println((i + 1) + ". Per la Porta: " + (existingPortsCount +1) + " - Nome: " + ethernet.getEthernetName()+ " - Velocità: " + ethernet.getEthernetSpeed());
    }

    // Ottieni la scelta dell'utente
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consuma il newline

    // Verifica se la scelta è valida
    if (choice < 1 || choice > ethernetComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la porta Ethernet selezionata e assegnala al laptop
    Ethernet selectedEthernet = ethernetComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePort(selectedEthernet);

    // Conferma l'aggiunta della porta Ethernet al laptop
    System.out.println("Hai aggiunto la porta Ethernet " + selectedEthernet.getPortName() + " con velocità " + selectedEthernet.getEthernetSpeed() + " al tuo laptop.");
}

    private static void configureUSB(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    // Ottieni le porte USB disponibili dall'ontologia
    List<USB> usbComponents = queryService.getUSBComponents(laptop);
    // Ottieni il numero di oggetti di tipo Port già aggiunti al laptop
    long existingPortsCount = laptop.getPorts().stream()
            .filter(port -> port instanceof Port)  // Filtra solo gli oggetti di tipo Port
            .count();

    if (usbComponents.isEmpty()) {
        System.out.println("Nessuna porta USB trovata.");
        return;
    }

    // Mostra la lista delle porte USB
    System.out.println("Seleziona una porta USB dalla lista:");
    for (int i = 0; i < usbComponents.size(); i++) {
        USB usb = usbComponents.get(i);
        System.out.println((i + 1) + ". Porta: " + (existingPortsCount + 1) + " - Nome: " + usb.getUSBName() + " - Versione: " + usb.getUSBVersion());
    }

    // Ottieni la scelta dell'utente
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consuma il newline

    // Verifica se la scelta è valida
    if (choice < 1 || choice > usbComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la porta USB selezionata e assegnala al laptop
    USB selectedUSB = usbComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePort(selectedUSB);

    // Conferma l'aggiunta della porta USB al laptop
    System.out.println("Hai aggiunto la porta USB " + selectedUSB.getPortName() + " con versione " + selectedUSB.getUSBVersion() + " al tuo laptop.");
}

    private static void configureHDMI(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
    // Ottieni le porte HDMI disponibili dall'ontologia
    List<HDMI> hdmiComponents = queryService.getHDMIComponents(laptop);
    // Ottieni il numero di oggetti di tipo Port già aggiunti al laptop
    long existingPortsCount = laptop.getPorts().stream()
            .filter(port -> port instanceof Port)  // Filtra solo gli oggetti di tipo Port
            .count();

    if (hdmiComponents.isEmpty()) {
        System.out.println("Nessuna porta HDMI trovata.");
        return;
    }

    // Mostra la lista delle porte HDMI
    System.out.println("Seleziona una porta HDMI dalla lista:");
    for (int i = 0; i < hdmiComponents.size(); i++) {
        HDMI hdmi = hdmiComponents.get(i);
        System.out.println((i + 1) + ". Porta: " + (existingPortsCount + 1) + " - Nome: " + hdmi.getHDMIName() + " - Versione: " + hdmi.getHDMIVersion());
    }

    // Ottieni la scelta dell'utente
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consuma il newline

    // Verifica se la scelta è valida
    if (choice < 1 || choice > hdmiComponents.size()) {
        System.out.println("Scelta non valida. Riprova.");
        return;
    }

    // Clona la porta HDMI selezionata e assegnala al laptop
    HDMI selectedHDMI = hdmiComponents.get(choice - 1).clone(laptop);
    laptop.addOrReplacePort(selectedHDMI);

    // Conferma l'aggiunta della porta HDMI al laptop
    System.out.println("Hai aggiunto la porta HDMI " + selectedHDMI.getPortName() + " con versione " + selectedHDMI.getHDMIVersion() + " al tuo laptop.");
}

    private static void configureAntivirus(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<Antivirus> antivirusComponents = queryService.getAntivirusComponents(laptop);
        if (antivirusComponents.isEmpty()) {
            System.out.println("Nessun antivirus trovato.");
            return;
        }

        System.out.println("Seleziona un antivirus dalla lista:");
        for (int i = 0; i < antivirusComponents.size(); i++) {
            Antivirus antivirus = antivirusComponents.get(i);
            System.out.println((i + 1) + ". " + antivirus.getAntivirusName() + " - Versione: " + antivirus.getAntivirusVersion());
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (choice < 1 || choice > antivirusComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona l'antivirus selezionato e assegnalo al laptop
        Antivirus selectedAntivirus = antivirusComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplaceSecurity(selectedAntivirus);

        System.out.println("Hai aggiunto l'antivirus " + selectedAntivirus.getAntivirusName() + " al tuo laptop.");
    }

    private static void configureProtectionFeature(Laptop laptop, LaptopComponentQueryService queryService, Scanner scanner) {
        List<ProtectionFeature> protectionFeatureComponents = queryService.getProtectionFeatureComponents(laptop);
        if (protectionFeatureComponents.isEmpty()) {
            System.out.println("Nessuna funzione di protezione trovata.");
            return;
        }

        System.out.println("Seleziona una funzione di protezione dalla lista:");
        for (int i = 0; i < protectionFeatureComponents.size(); i++) {
            ProtectionFeature protectionFeature = protectionFeatureComponents.get(i);
            System.out.println((i + 1) + ". " + protectionFeature.getProtectionFeatureName() + " - Tipo: " + protectionFeature.getTypeProtectionFeature());
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        if (choice < 1 || choice > protectionFeatureComponents.size()) {
            System.out.println("Scelta non valida. Riprova.");
            return;
        }

        // Clona la funzione di protezione selezionata e assegnala al laptop
        ProtectionFeature selectedProtectionFeature = protectionFeatureComponents.get(choice - 1).clone(laptop);
        laptop.addOrReplaceSecurity(selectedProtectionFeature);

        System.out.println("Hai aggiunto la funzione di protezione " + selectedProtectionFeature.getProtectionFeatureName() + " al tuo laptop.");
    }



    private static void displayFinalConfiguration(Laptop laptop) {
        String separator = "----------------------------------------";

        System.out.println(separator);
        System.out.println("Configurazione finale del laptop: " + laptop.getLaptopName());
        System.out.println(separator);

        // Sistema Audio
        if (laptop.getAudioSystem() != null) {
            AudioSystem audioSystem = laptop.getAudioSystem();
            System.out.println("[Sistema Audio]");
            System.out.printf("  Nome: %s%n  Tipo: %s%n", audioSystem.getAudioSystemName(), audioSystem.getAudioSystemType());
            System.out.println(separator);
        }

        // Batteria
        if (laptop.getBattery() != null) {
            Battery battery = laptop.getBattery();
            System.out.println("[Batteria]");
            System.out.printf("  Nome: %s%n  Capacità: %.2f mAh%n", battery.getBatteryName(), battery.getBatteryCapacity());
            System.out.println(separator);
        }

        // Colore
        if (laptop.getColour() != null) {
            Colour colour = laptop.getColour();
            System.out.println("[Colore]");
            System.out.printf("  Nome: %s%n", colour.getColourName());
            System.out.println(separator);
        }

        // Componenti
        if (!laptop.getComponents().isEmpty()) {
            System.out.println("[Componenti]");
            for (Component component : laptop.getComponents()) {
                if (component instanceof RAM) {
                    RAM ram = (RAM) component;
                    System.out.printf("  RAM: %s  -  Size: %sGB%n", ram.getRamName(), ram.getRamSize());
                } else if (component instanceof CPU) {
                    CPU cpu = (CPU) component;
                    System.out.printf("  CPU: %s  -  Speed: %s%n", cpu.getCPUName(), cpu.getCpuSpeed());
                } else if (component instanceof Display) {
                    Display display = (Display) component;
                    System.out.printf("  Schermo: %s  -  Risoluzione: %s%n", display.getDisplayName(), display.getDisplayResolution());
                } else if (component instanceof GraphicsCard) {
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    System.out.printf("  Scheda Grafica: %s  -  Memoria: %s%n", graphicsCard.getGraphicCardName(), graphicsCard.getGraphicsMemory());
                } else if (component instanceof OperatingSystem) {
                    OperatingSystem os = (OperatingSystem) component;
                    System.out.printf("  Sistema Operativo: %s  -  Versione: %s%n", os.getOSName(), os.getOperatingSystemVersion());
                } else if (component instanceof Storage) {
                    Storage storage = (Storage) component;
                    System.out.printf("  Memoria: %s  -  Capacità: %s%n", storage.getStorageName(), storage.getStorageCapacity());
                }
            }
            System.out.println(separator);
        }

        // Sistema Raffreddamento
        if (laptop.getCoolingSystem() != null) {
            CoolingSystem coolingSystem = laptop.getCoolingSystem();
            System.out.println("[Sistema di Raffreddamento]");
            System.out.printf("  Nome: %s  -  Tipo: %s%n", coolingSystem.getCoolingSystemName(), coolingSystem.getCoolingSystemType());
            System.out.println(separator);
        }

        // Garanzia
        if (laptop.getWarranty() != null) {
            Warranty warranty = laptop.getWarranty();
            System.out.println("[Garanzia]");
            System.out.printf("  Nome: %s  -  Durata: %d anni%n", warranty.getWarrantyName(), warranty.getWarrantyPeriod());
            System.out.println(separator);
        }

        // Periferiche
        if (!laptop.getPeripherals().isEmpty()) {
            System.out.println("[Periferiche]");
            for (Peripheral peripheral : laptop.getPeripherals()) {
                if (peripheral instanceof ExternalMonitor) {
                    ExternalMonitor monitor = (ExternalMonitor) peripheral;
                    System.out.printf("  Monitor Esterno: %s  -  Risoluzione: %s%n", monitor.getExMonitorName(), monitor.getExternalDisplayResolution());
                } else if (peripheral instanceof ExternalSpeaker) {
                    ExternalSpeaker speaker = (ExternalSpeaker) peripheral;
                    System.out.printf("  Speaker Esterno: %s  -  Tipo: %s%n", speaker.getExSpeakerName(), speaker.getExternalAudioSystemType());
                } else if (peripheral instanceof Keyboard) {
                    Keyboard keyboard = (Keyboard) peripheral;
                    System.out.printf("  Tastiera: %s  -  Layout: %s%n", keyboard.getKeyboardName(), keyboard.getKeyboardLayout());
                } else if (peripheral instanceof Mouse) {
                    Mouse mouse = (Mouse) peripheral;
                    System.out.printf("  Mouse: %s  -  Tipo: %s%n", mouse.getMouseName(), mouse.getMouseType());
                } else if (peripheral instanceof Webcam) {
                    Webcam webcam = (Webcam) peripheral;
                    System.out.printf("  Webcam: %s  -  Risoluzione: %s%n", webcam.getWebcamName(), webcam.getWebcamResolution());
                }
            }
            System.out.println(separator);
        }

        // Porte
        if (!laptop.getPorts().isEmpty()) {
            System.out.println("[Porte]");
            for (Port port : laptop.getPorts()) {
                if (port instanceof Ethernet) {
                    Ethernet ethernet = (Ethernet) port;
                    System.out.printf("  Ethernet - Porta n. %s  -  Nome: %s  -  Velocità: %s%n", ethernet.getPortName(), ethernet.getEthernetName(), ethernet.getEthernetSpeed());
                } else if (port instanceof USB) {
                    USB usb = (USB) port;
                    System.out.printf("  USB - Porta n. %s  -  Nome: %s  -  Versione: %s%n", usb.getPortName(), usb.getUSBName(), usb.getUSBVersion());
                } else if (port instanceof HDMI) {
                    HDMI hdmi = (HDMI) port;
                    System.out.printf("  HDMI - Porta n. %s  -  Nome: %s  -  Versione: %s%n", hdmi.getPortName(), hdmi.getHDMIName(), hdmi.getHDMIVersion());
                } else {
                    System.out.printf("  Porta sconosciuta: %s%n", port.getPortName());
                }
            }
            System.out.println(separator);
        }

        // Sicurezza
        if (!laptop.getSecurities().isEmpty()) {
            System.out.println("[Sicurezza]");
            for (Security security : laptop.getSecurities()) {
                if (security instanceof Antivirus) {
                    Antivirus antivirus = (Antivirus) security;
                    System.out.printf("  Antivirus: %s  -  Versione: %s%n", antivirus.getAntivirusName(), antivirus.getAntivirusVersion());
                } else if (security instanceof ProtectionFeature) {
                    ProtectionFeature protection = (ProtectionFeature) security;
                    System.out.printf("  Protezione: %s  -  Tipo: %s%n", protection.getProtectionFeatureName(), protection.getTypeProtectionFeature());
                }
            }
            System.out.println(separator);
        }

        System.out.println("Configurazione completata.");
        System.out.println(separator);
    }

}

