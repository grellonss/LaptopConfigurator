package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
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




}

