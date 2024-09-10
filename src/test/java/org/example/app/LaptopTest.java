package org.example.app;

import org.example.configurator.Laptop;
import org.example.configurator.RAM;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LaptopTest {

    @Test
    public void testLaptopCreationAndConfiguration() {
        // Test della creazione del laptop
        Laptop laptop = new Laptop("TestLaptop");
        assertEquals("TestLaptop", laptop.getLaptopName());

        // Test dell'aggiunta di componenti
        RAM ram = new RAM(laptop, "TestRAM", "16GB");
        laptop.addOrReplaceComponent(ram);

        assertEquals(1, laptop.getComponents().size());
        RAM addedRam = (RAM) laptop.getComponents().get(0);
        assertEquals("TestRAM", addedRam.getRamName());
    }
}

