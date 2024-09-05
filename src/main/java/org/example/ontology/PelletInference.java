package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.ModelFactory;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.reasoner.Reasoner;

public class PelletInference {

    private InfModel inferredModel;

    // Costruttore che accetta un modello di ontologia e crea un modello inferito
    public PelletInference(OntModel ontologyModel) {
        performInference(ontologyModel);
    }

    // Metodo che esegue l'inferenza con Pellet
    private void performInference(OntModel ontologyModel) {
        // Creazione del reasoner con Pellet
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();

        // Associazione del reasoner al modello RDF per creare il modello inferito
        inferredModel = ModelFactory.createInfModel(reasoner, ontologyModel);

        System.out.println("Inferenza completata.");
    }

    // Restituisce il modello inferito
    public InfModel getInferredModel() {
        return inferredModel;
    }
}

