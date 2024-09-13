package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.ModelFactory;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.reasoner.Reasoner;

/**
 * This class performs inference on an ontology model using the Pellet reasoner.
 */
public class PelletInference {

    private InfModel inferredModel;

    /**
     * Constructor that accepts an ontology model and creates an inferred model using Pellet.
     *
     * @param ontologyModel The ontology model to perform inference on.
     */
    public PelletInference(OntModel ontologyModel) {
        performInference(ontologyModel);
    }

    /**
     * Performs inference on the given ontology model using the Pellet reasoner.
     *
     * @param ontologyModel The ontology model on which to perform the inference.
     */
    private void performInference(OntModel ontologyModel) {
        // Create the reasoner with Pellet
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();

        // Associate the reasoner with the RDF model to create the inferred model
        inferredModel = ModelFactory.createInfModel(reasoner, ontologyModel);

        System.out.println("Inference completed.");
    }

    /**
     * Returns the inferred model after the reasoning process.
     *
     * @return The inferred model.
     */
    public InfModel getInferredModel() {
        return inferredModel;
    }
}
