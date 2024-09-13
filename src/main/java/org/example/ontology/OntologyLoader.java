package org.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.InputStream;
import java.io.FileNotFoundException;

/**
 * This class is responsible for loading an RDF/OWL ontology into a Jena OntModel.
 */
public class OntologyLoader {

    private OntModel ontologyModel;

    /**
     * Constructor that loads the ontology from the specified file path.
     *
     * @param filePath The file path of the RDF/OWL ontology.
     */
    public OntologyLoader(String filePath) {
        loadOntology(filePath);
    }

    /**
     * Loads the RDF/OWL ontology file into the Jena OntModel.
     *
     * @param filePath The file path of the ontology to be loaded.
     */
    private void loadOntology(String filePath) {
        try {
            // Create an empty ontology model
            ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

            // Load the RDF/OWL file
            InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
            if (in == null) {
                throw new FileNotFoundException("RDF/OWL file not found: " + filePath);
            }
            // Read the RDF/OWL file into the ontology model
            ontologyModel.read(in, null);
        } catch (FileNotFoundException e) {
            System.err.println("RDF/OWL file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error loading the ontology: " + e.getMessage());
        }
    }

    /**
     * Returns the loaded Jena OntModel containing the ontology.
     *
     * @return The loaded ontology model.
     */
    public OntModel getOntologyModel() {
        return ontologyModel;
    }

}
