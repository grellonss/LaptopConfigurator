package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.Component;
import org.example.configurator.RAM;

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

    // Metodo che esegue la query SPARQL per ottenere i componenti e le loro proprietà
    // Metodo che esegue la query SPARQL per ottenere i componenti e le loro proprietà
    public List<RAM> getRAMComponents() {
        List<RAM> ramList = new ArrayList<>();

        // Query per selezionare le istanze di RAM, i loro nomi e le loro proprietà (es: ramSize)
        String sparqlQuery =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                        "SELECT ?ram ?size WHERE { " +
                        "?ram rdf:type laptop:RAM . " +
                        "?ram laptop:hasRAMSize ?size . " +
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
                RAM ram = new RAM(ramName,ramSize);
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


    // Restituisce il modello Jena caricato
    public OntModel getOntologyModel() {
        return ontologyModel;
    }
}

