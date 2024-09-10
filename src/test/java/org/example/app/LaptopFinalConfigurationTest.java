package org.example.app;

import org.example.configurator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LaptopFinalConfigurationTest {

    @Test
    public void testFinalLaptopConfiguration() {
        // Crea un'istanza di Laptop
        Laptop laptop = new Laptop("TestLaptop");

        // Aggiungi RAM e CPU al laptop
        RAM ram = new RAM(laptop, "TestRAM", "16GB");
        CPU cpu = new CPU(laptop, "TestCPU", "3.2GHz");
        laptop.addOrReplaceComponent(ram);
        laptop.addOrReplaceComponent(cpu);

        // Verifica che i componenti siano stati aggiunti correttamente
        assertEquals(2, laptop.getComponents().size());

        // Verifica che RAM e CPU siano nel laptop
        assertTrue(laptop.getComponents().stream().anyMatch(c -> c instanceof RAM));
        assertTrue(laptop.getComponents().stream().anyMatch(c -> c instanceof CPU));
    }
}

