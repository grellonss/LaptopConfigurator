package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.OntologyLoader;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Step 1: Carica l'ontologia
        String ontologyFilePath = "LaptopConfigModellazione.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        // Verifica che l'ontologia sia stata caricata correttamente
        if (model != null) {
            System.out.println("Ontologia caricata con successo!");

            // Step 2: Richiedi il nome del laptop all'utente
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci il nome del laptop: ");
            String laptopName = scanner.nextLine();
            Laptop laptop = new Laptop(laptopName);

            // Step 3: Offri all'utente la possibilità di configurare il laptop
            while (true) {
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

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consuma newline dopo l'input numerico

                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        boolean componentMenuActive = true;
                        while (componentMenuActive) {
                            System.out.println("Quale componente vuoi selezionare?");
                            System.out.println("1. CPU");
                            System.out.println("2. Schermo");
                            System.out.println("3. Scheda Grafica");
                            System.out.println("4. Sistema Operativo");
                            System.out.println("5. RAM");
                            System.out.println("6. Memoria");
                            System.out.println("0. Pagina Precedente");

                            int choice1 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice1) {
                                case 1:
                                    configureCPU(laptop, ontologyLoader, scanner);
                                    break;
                                case 2:
                                    configureDisplay(laptop, ontologyLoader, scanner);
                                    break;
                                case 3:
                                    configureGraphicsCard(laptop, ontologyLoader, scanner);
                                    break;
                                case 4:
                                    configureOperatingSystem(laptop, ontologyLoader, scanner);
                                    break;
                                case 5:
                                    configureRAM(laptop, ontologyLoader, scanner);
                                    break;
                                case 6:
                                    configureStorage(laptop, ontologyLoader, scanner);
                                    break;
                                case 0:
                                    componentMenuActive = false;
                                    break;
                                default:
                                    System.out.println("Scelta non valida. Riprova.");
                                    break;
                            }
                        }
                        break;
                    case 5:
                        // Aggiungi qui logica per configurare Peripherals
                        break;
                    case 6:
                        boolean componentMenuActive1 = true;
                        while (componentMenuActive1) {
                            System.out.println("Quale periferica vuoi selezionare?");
                            System.out.println("1. Monitorn Esterno");
                            System.out.println("2. Speaker Esterno");
                            System.out.println("3. Tastiera");
                            System.out.println("4. Mouse");
                            System.out.println("5. Videocamera");
                            System.out.println("0. Pagina Precedente");

                            int choice2 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice2) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 0:
                                    componentMenuActive1 = false;
                                    break;
                                default:
                                    System.out.println("Scelta non valida. Riprova.");
                                    break;
                            }
                        }
                        break;
                    case 7:
                        boolean componentMenuActive2 = true;
                        while (componentMenuActive2) {
                            System.out.println("Che tipo di porta vuoi selezionare?");
                            System.out.println("1. Ethernet");
                            System.out.println("2. HDMI");
                            System.out.println("3. USB");
                            System.out.println("0. Pagina Precedente");

                            int choice3 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice3) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 0:
                                    componentMenuActive2 = false;
                                    break;
                                default:
                                    System.out.println("Scelta non valida. Riprova.");
                                    break;
                            }
                        }
                        break;
                    case 8:
                        boolean componentMenuActive3 = true;
                        while (componentMenuActive3) {
                            System.out.println("Quale tipologia di sicurezza vuoi implementare??");
                            System.out.println("1. Antivirus");
                            System.out.println("2. Plug-in di protezione");
                            System.out.println("0. Pagina Precedente");

                            int choice4 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice4) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 0:
                                    componentMenuActive3 = false;
                                    break;
                                default:
                                    System.out.println("Scelta non valida. Riprova.");
                                    break;
                            }
                        }
                        break;
                    case 9:
                        break;
                    case 0:
                        System.out.println("Configurazione completata.");
                        displayFinalConfiguration(laptop);
                        return; // Esce dal ciclo e termina il programma
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        }
                }
            } else{
                System.out.println("Errore nel caricamento dell'ontologia.");
            }
        }

        // Metodo per configurare la RAM
        private static void configureRAM (Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner){
            List<RAM> ramComponents = ontologyLoader.getRAMComponents(laptop);
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
        private static void configureCPU(Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner) {
        List<CPU> cpuComponents = ontologyLoader.getCPUComponents(laptop); // Devi implementare il metodo getCPUComponents()
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
        private static void configureDisplay(Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner) {
            List<Display> displayComponents = ontologyLoader.getDisplayComponents(laptop);
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
        private static void configureGraphicsCard(Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner) {
            List<GraphicsCard> graphicsCards = ontologyLoader.getGraphicsCardComponents(laptop);
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
        private static void configureOperatingSystem(Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner) {
            List<OperatingSystem> operatingSystemComponents = ontologyLoader.getOperatingSystemComponents(laptop);

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
        private static void configureStorage(Laptop laptop, OntologyLoader ontologyLoader, Scanner scanner) {
            List<Storage> storageComponents = ontologyLoader.getStorageComponents(laptop);

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






        // Metodo per mostrare la configurazione finale del laptop
        private static void displayFinalConfiguration (Laptop laptop){
            System.out.println("Configurazione finale del laptop " + laptop.getLaptopName() + ":");
            for (Component component : laptop.getComponents()) {
                if (component instanceof RAM) {
                    RAM ram = (RAM) component;
                    System.out.println("RAM: " + ram.getRamName() + " - Size: " + ram.getRamSize() + "GB");
                }else if (component instanceof CPU) {
                    CPU cpu = (CPU) component;
                    System.out.println("CPU: " + cpu.getCPUName() + " - Speed: " + cpu.getCpuSpeed());
                }else if (component instanceof Display) {
                    Display display = (Display) component;
                    System.out.println("Schermo: " + display.getDisplayName() + " - Risoluzione: " + display.getDisplayResolution());
                }else if (component instanceof GraphicsCard) {
                    GraphicsCard graphicsCard = (GraphicsCard) component;
                    System.out.println("Scheda Grafica: " + graphicsCard.getGraphicCardName() + " - Memoria: " + graphicsCard.getGraphicsMemory());
                } else if (component instanceof OperatingSystem) {
                OperatingSystem os = (OperatingSystem) component;
                System.out.println("Sistema Operativo: " + os.getOSName() + " - Versione: " + os.getOperatingSystemVersion());
                } else if (component instanceof Storage) {
                Storage storage = (Storage) component;
                System.out.println("Memoria: " + storage.getStorageName() + " - Capacità: " + storage.getStorageCapacity() + "GB");

            }
        }
    }
    }
