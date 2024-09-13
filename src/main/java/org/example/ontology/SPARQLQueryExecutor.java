package org.example.ontology;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.InfModel;

/**
 * This class is responsible for executing SPARQL queries on an inferred model.
 */
public class SPARQLQueryExecutor {

    private InfModel inferredModel;

    /**
     * Constructor that accepts the inferred model on which SPARQL queries will be executed.
     *
     * @param inferredModel The inferred model to query.
     */
    public SPARQLQueryExecutor(InfModel inferredModel) {
        this.inferredModel = inferredModel;
    }

    /**
     * Executes a SPARQL query on the inferred model and returns the result set.
     *
     * @param sparqlQuery The SPARQL query to be executed.
     * @return The result set of the query execution, or null if an error occurs.
     */
    public ResultSet executeQuery(String sparqlQuery) {
        try {
            // Create the SPARQL query object
            Query query = QueryFactory.create(sparqlQuery);

            // Execute the query on the inferred model
            QueryExecution qe = QueryExecutionFactory.create(query, inferredModel);
            return qe.execSelect(); // Returns the query results
        } catch (Exception e) {
            System.err.println("Error during query execution: " + e.getMessage());
            return null; // Returns null in case of an error
        }
    }
}
