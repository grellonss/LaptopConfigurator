package org.example.app;

import org.example.configurator.Laptop;
import org.example.configurator.RAM;
import org.example.ontology.LaptopComponentQueryService;
import org.example.ontology.SPARQLQueryExecutor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LaptopComponentQueryServiceTest {

    @Test
    public void testQueryServiceAndComponentAddition() {
        // Crea un'istanza del laptop
        Laptop laptop = new Laptop("TestLaptop");

        // Mock di SPARQLQueryExecutor (in un vero test, potresti usare Mockito o una libreria simile)
        SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(null);  // Mocking o uso reale
        LaptopComponentQueryService queryService = new LaptopComponentQueryService(queryExecutor);

        // Esegui la query per i componenti della RAM (supponendo che il risultato sia vuoto)
        List<RAM> ramComponents = queryService.getRAMComponents(laptop);

        // Verifica che i componenti siano stati restituiti correttamente (lista vuota per ora)
        assertNotNull(ramComponents);
        assertTrue(ramComponents.isEmpty());  // Se non ci sono componenti RAM definiti
    }
}

