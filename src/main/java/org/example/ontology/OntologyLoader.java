package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.*;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class OntologyLoader {

    private OntModel ontologyModel;

    // Costruttore che carica l'ontologia dal file specificato
    public OntologyLoader(String filePath) {
        loadOntology(filePath);
    }

    // Metodo che carica il file RDF/OWL nel modello Jena
    private void loadOntology(String filePath) {
        try {
            // Creazione del modello vuoto
            ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

            // Caricamento del file RDF/OWL
            InputStream in =getClass().getClassLoader().getResourceAsStream(filePath);
            if (in == null) {
                throw new FileNotFoundException("File RDF/OWL non trovato: " + filePath);
            }
            // Caricamento del file RDF/OWL
            ontologyModel.read(in, null);

            System.out.println("Ontologia caricata correttamente.");
        } catch (FileNotFoundException e) {
            System.err.println("File RDF/OWL non trovato: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Errore durante il caricamento dell'ontologia: " + e.getMessage());
        }
    }

    // Restituisce il modello Jena caricato
    public OntModel getOntologyModel() {
        return ontologyModel;
    }

    // Metodo che esegue la query SPARQL per ottenere i componenti e le loro proprietà
    public List<RAM> getRAMComponents(Laptop laptop) {
        List<RAM> ramList = new ArrayList<>();

        // Query per selezionare le istanze di RAM, i loro nomi e le loro proprietà (es: ramSize)
        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?ram ?size ?laptop  WHERE { " +
                        "?ram rdf:type laptop:RAM . " +
                        "?ram laptop:hasRAMSize ?size . " +
                        "?ram laptop:isComponentOf ?laptop . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource ramResource = solution.getResource("ram");  // Ottieni l'URI dell'individuo RAM
                String ramName = ramResource.getLocalName();  // Estrai il local name dall'URI
                String ramSize = solution.getLiteral("size").getString();  // Ottieni la dimensione della RAM

                // Crea un oggetto RAM con le proprietà estratte dall'ontologia
                RAM ram = new RAM(laptop, ramName,ramSize);
                ramList.add(ram);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            // Chiude la query execution
            qe.close();
        }
        return ramList;
    }

    // Metodo per ottenere le CPU dall'ontologia
    public List<CPU> getCPUComponents(Laptop laptop) {
        List<CPU> cpuList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?cpu ?speed ?laptop WHERE { " +
                        "?cpu rdf:type laptop:CPU . " +
                        "?cpu laptop:hasCPUSpeed ?speed . " +
                        "?cpu laptop:isComponentOf ?laptop . " +
                        "}";


        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource cpuResource = solution.getResource("cpu");
                String name = cpuResource.getLocalName();
                String speed = solution.getLiteral("speed").getString();

                CPU cpu = new CPU(laptop,name, speed);
                cpuList.add(cpu);
            }
        } finally {
            qe.close();
        }

        return cpuList;
    }

    public List<Display> getDisplayComponents(Laptop laptop) {
        List<Display> displayList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?display ?laptop ?resolution WHERE { " +
                        "?display rdf:type laptop:Display . " +
                        "?display laptop:hasDisplayResolution ?resolution . " +
                        "?display laptop:isComponentOf ?laptop . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource displayResource = solution.getResource("display");
                String name = displayResource.getLocalName();
                String resolution = solution.getLiteral("resolution").getString();

                Display display = new Display(laptop, name, resolution);
                displayList.add(display);
            }
        } finally {
            qe.close();
        }

        return displayList;
    }

    public List<GraphicsCard> getGraphicsCardComponents(Laptop laptop) {
        List<GraphicsCard> graphicsCardList = new ArrayList<>();

        // Query per selezionare le istanze di Graphics Card e le loro proprietà (solo memoria, il nome lo otteniamo dal LocalName)
        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?graphicsCard ?memory WHERE { " +
                        "?graphicsCard rdf:type laptop:GraphicsCard . " +
                        "?graphicsCard laptop:hasGraphicsMemory ?memory . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource graphicsCardResource = solution.getResource("graphicsCard");  // Ottieni l'URI dell'individuo Graphics Card
                String localName = graphicsCardResource.getLocalName();  // Ottieni il local name dall'URI (che rappresenta il nome della Graphics Card)
                String memory = solution.getLiteral("memory").getString();  // Ottieni la memoria della Graphics Card

                // Crea un oggetto GraphicsCard con le proprietà estratte dall'ontologia
                GraphicsCard graphicsCard = new GraphicsCard(laptop, localName, memory);
                graphicsCardList.add(graphicsCard);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            // Chiude la query execution
            qe.close();
        }
        return graphicsCardList;
    }

    public List<OperatingSystem> getOperatingSystemComponents(Laptop laptop) {
        List<OperatingSystem> operatingSystemList = new ArrayList<>();

        // Query per selezionare le istanze di Operating System e le loro proprietà
        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?operatingSystem ?version WHERE { " +
                        "?operatingSystem rdf:type laptop:OperatingSystem . " +
                        "?operatingSystem laptop:hasOperatingSystemVersion ?version . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource operatingSystemResource = solution.getResource("operatingSystem");  // Ottieni l'URI dell'individuo OS
                String localName = operatingSystemResource.getLocalName();  // Ottieni il local name dall'URI (che rappresenta il nome del sistema operativo)
                String version = solution.getLiteral("version").getString();  // Ottieni la versione del sistema operativo

                // Crea un oggetto OperatingSystem con le proprietà estratte dall'ontologia
                OperatingSystem os = new OperatingSystem(laptop, localName, version);
                operatingSystemList.add(os);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            // Chiude la query execution
            qe.close();
        }
        return operatingSystemList;
    }

    public List<Storage> getStorageComponents(Laptop laptop) {
        List<Storage> storageList = new ArrayList<>();

        // Query per selezionare le istanze di Storage e le loro proprietà
        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?storage ?capacity WHERE { " +
                        "?storage rdf:type laptop:Storage . " +
                        "?storage laptop:hasStorageCapacity ?capacity . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource storageResource = solution.getResource("storage");  // Ottieni l'URI dell'individuo Storage
                String localName = storageResource.getLocalName();  // Ottieni il local name dall'URI (che rappresenta il nome dello storage)
                String capacity = solution.getLiteral("capacity").getString();  // Ottieni la capacità di storage

                // Crea un oggetto Storage con le proprietà estratte dall'ontologia
                Storage storage = new Storage(laptop, localName, capacity);
                storageList.add(storage);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            // Chiude la query execution
            qe.close();
        }
        return storageList;
    }

    public List<AudioSystem> getAudioSystemComponents(Laptop laptop) {
        List<AudioSystem> audioSystemList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?audioSystem ?audioSystemType WHERE { " +
                        "?audioSystem rdf:type laptop:AudioSystem . " +
                        "?audioSystem laptop:hasAudioSystemType ?audioSystemType "+
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource audioResource = solution.getResource("audioSystem");
                String localName = audioResource.getLocalName();
                String type = solution.getLiteral("audioSystemType").getString();  // Ottieni la capacità di storage

                AudioSystem audioSystem = new AudioSystem(laptop, localName,type);  // Usa il costruttore corretto
                audioSystemList.add(audioSystem);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            qe.close();
        }

        return audioSystemList;
    }

    public List<Battery> getBatteryComponents(Laptop laptop) {
        List<Battery> batteryList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?battery ?capacity WHERE { " +
                        "?battery rdf:type laptop:Battery . " +
                        "?battery laptop:hasBatteryCapacity ?capacity . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource batteryResource = solution.getResource("battery");
                String localName = batteryResource.getLocalName();  // Otteniamo il local name
                double capacity = solution.getLiteral("capacity").getDouble();

                Battery battery = new Battery(laptop, localName, capacity);
                batteryList.add(battery);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            qe.close();
        }

        return batteryList;
    }

    public List<Colour> getColourComponents(Laptop laptop) {
        List<Colour> colourList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?colour WHERE { " +
                        "?colour rdf:type laptop:Colour . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource colourResource = solution.getResource("colour");
                String localName = colourResource.getLocalName();  // Otteniamo il local name

                Colour colour = new Colour(laptop, localName);
                colourList.add(colour);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            qe.close();
        }

        return colourList;
    }

    public List<CoolingSystem> getCoolingSystemComponents(Laptop laptop) {
        List<CoolingSystem> coolingSystemList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?coolingSystem ?type WHERE { " +
                        "?coolingSystem rdf:type laptop:CoolingSystem . " +
                        "?coolingSystem laptop:hasCoolingSystemType ?type . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource coolingResource = solution.getResource("coolingSystem");
                String localName = coolingResource.getLocalName();  // Otteniamo il local name
                String coolingSystemType = solution.getLiteral("type").getString();

                CoolingSystem coolingSystem = new CoolingSystem(laptop, localName, coolingSystemType);
                coolingSystemList.add(coolingSystem);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            qe.close();
        }

        return coolingSystemList;
    }

    public List<Warranty> getWarrantyComponents(Laptop laptop) {
        List<Warranty> warrantyList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?warranty ?period WHERE { " +
                        "?warranty rdf:type laptop:Warranty . " +
                        "?warranty laptop:hasWarrantyPeriod ?period . " +
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource warrantyResource = solution.getResource("warranty");
                String localName = warrantyResource.getLocalName();  // Otteniamo il local name
                int warrantyPeriod = solution.getLiteral("period").getInt();

                Warranty warranty = new Warranty(laptop, localName, warrantyPeriod);
                warrantyList.add(warranty);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query SPARQL: " + e.getMessage());
        } finally {
            qe.close();
        }

        return warrantyList;
    }

    // Metodo per ottenere tutti i monitor esterni
    public List<ExternalMonitor> getExternalMonitorComponents(Laptop laptop) {
        List<ExternalMonitor> monitorList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?monitor ?resolution ?connection WHERE { " +
                        "?monitor rdf:type laptop:ExternalMonitor . " +
                        "?monitor laptop:hasExternalDisplayResolution ?resolution . " +
                        "?monitor laptop:hasConnectionType ?connection . }";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource monitorResource = solution.getResource("monitor");
                String localName = monitorResource.getLocalName();
                String resolution = solution.getLiteral("resolution").getString();
                String connectionType = solution.getLiteral("connection").getString();

                ExternalMonitor monitor = new ExternalMonitor(laptop, connectionType, localName, resolution);
                monitorList.add(monitor);
            }
        } finally {
            qe.close();
        }

        return monitorList;
    }

    // Metodo per ottenere tutti gli altoparlanti esterni
    public List<ExternalSpeaker> getExternalSpeakerComponents(Laptop laptop) {
        List<ExternalSpeaker> speakerList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?speaker ?audioType ?connection WHERE { " +
                        "?speaker rdf:type laptop:ExternalSpeaker . " +
                        "?speaker laptop:hasExternalAudioSystemType ?audioType . " +
                        "?speaker laptop:hasConnectionType ?connection . }";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource speakerResource = solution.getResource("speaker");
                String localName = speakerResource.getLocalName();
                String audioType = solution.getLiteral("audioType").getString();
                String connectionType = solution.getLiteral("connection").getString();

                ExternalSpeaker speaker = new ExternalSpeaker(laptop, connectionType, localName, audioType);
                speakerList.add(speaker);
            }
        } finally {
            qe.close();
        }

        return speakerList;
    }

    // Metodo per ottenere tutte le tastiere
    public List<Keyboard> getKeyboardComponents(Laptop laptop) {
        List<Keyboard> keyboardList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?keyboard ?layout ?connection WHERE { " +
                        "?keyboard rdf:type laptop:Keyboard . " +
                        "?keyboard laptop:hasKeyboardLayout ?layout . " +
                        "?keyboard laptop:hasConnectionType ?connection . }";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource keyboardResource = solution.getResource("keyboard");
                String localName = keyboardResource.getLocalName();
                String layout = solution.getLiteral("layout").getString();
                String connectionType = solution.getLiteral("connection").getString();

                Keyboard keyboard = new Keyboard(laptop, connectionType, localName, layout);
                keyboardList.add(keyboard);
            }
        } finally {
            qe.close();
        }

        return keyboardList;
    }

    // Metodo per ottenere tutti i mouse
    public List<Mouse> getMouseComponents(Laptop laptop) {
        List<Mouse> mouseList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?mouse ?mouseType ?connectionType WHERE { " +
                        "?mouse rdf:type laptop:Mouse . " +
                        "?mouse laptop:isPeripheralOf ?laptop . " +  // Collegamento diretto con il laptop
                        "?mouse laptop:hasMouseType ?mouseType . " +  // Tipo del mouse
                        "?mouse laptop:hasConnectionType ?connectionType . " +  // Tipo di connessione
                        "FILTER (?laptop = <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#" + laptop.getLaptopName() + ">) " +  // Collega il laptop attuale
                        "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();

            // Processa i risultati
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource mouseResource = solution.getResource("mouse");
                String mouseName = mouseResource.getLocalName();
                String mouseType = solution.getLiteral("mouseType").getString();
                String connectionType = solution.getLiteral("connectionType").getString();

                // Crea un oggetto Mouse e aggiungilo alla lista
                Mouse mouse = new Mouse(laptop, mouseName, mouseType, connectionType);
                mouseList.add(mouse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            qe.close();
        }

        return mouseList;
    }





    // Metodo per ottenere tutte le webcam
    public List<Webcam> getWebcamComponents(Laptop laptop) {
        List<Webcam> webcamList = new ArrayList<>();

        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?webcam ?resolution ?connection WHERE { " +
                        "?webcam rdf:type laptop:Webcam . " +
                        "?webcam laptop:hasWebcamResolution ?resolution . " +
                        "?webcam laptop:hasConnectionType ?connection . }";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qe = QueryExecutionFactory.create(query, ontologyModel);

        try {
            ResultSet results = qe.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource webcamResource = solution.getResource("webcam");
                String localName = webcamResource.getLocalName();
                String resolution = solution.getLiteral("resolution").getString();
                String connectionType = solution.getLiteral("connection").getString();

                Webcam webcam = new Webcam(laptop, connectionType, localName, resolution);
                webcamList.add(webcam);
            }
        } finally {
            qe.close();
        }

        return webcamList;
    }




}

