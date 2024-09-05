package org.example.ontology;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.InfModel;

public class SPARQLQueryExecutor {

    private InfModel inferredModel;

    // Costruttore che accetta il modello inferito
    public SPARQLQueryExecutor(InfModel inferredModel) {
        this.inferredModel = inferredModel;
    }

    // Metodo per eseguire una query SPARQL
    public void executeQuery(String sparqlQuery) {
        try {
            // Creazione del Query object
            Query query = QueryFactory.create(sparqlQuery);

            // Esecuzione della query sul modello inferito
            try (QueryExecution qe = QueryExecutionFactory.create(query, inferredModel)) {
                ResultSet results = qe.execSelect();

                // Stampa dei risultati
                ResultSetFormatter.out(System.out, results, query);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query: " + e.getMessage());
        }
    }
}
