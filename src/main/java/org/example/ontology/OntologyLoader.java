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

}

