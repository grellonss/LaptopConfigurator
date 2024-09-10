package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.Laptop;
import org.example.configurator.RAM;
import org.example.ontology.LaptopComponentQueryService;
import org.example.ontology.OntologyLoader;
import org.example.ontology.SPARQLQueryExecutor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class OntologyLoaderTest {

    @Test
    public void testOntologyLoadingAndComponentQuery() {
        // Carica l'ontologia
        String ontologyFilePath = "LaptopConfigModellazione.rdf";
        OntologyLoader loader = new OntologyLoader(ontologyFilePath);
        OntModel model = loader.getOntologyModel();

        // Verifica che l'ontologia sia stata caricata correttamente
        assertNotNull(model);

        // Crea l'istanza del servizio di query
        SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
        LaptopComponentQueryService queryService = new LaptopComponentQueryService(queryExecutor);

        // Verifica la query per ottenere i componenti RAM
        Laptop laptop = new Laptop("TestLaptop");
        List<RAM> ramComponents = queryService.getRAMComponents(laptop);

        // Supponendo che ci sia almeno un componente RAM nell'ontologia
        assertNotNull(ramComponents);
        assertFalse(ramComponents.isEmpty());
    }
}
