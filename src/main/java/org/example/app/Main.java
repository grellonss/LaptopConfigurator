package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.Laptop;
import org.example.configurator.RAM;
import org.example.ontology.OntologyLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Carica l'ontologia
        String ontologyFilePath = "LaptopConfigModellazione.rdf"; // Assumendo che sia nella cartella resources
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        // Verifica che l'ontologia sia stata caricata correttamente
        if (model != null) {
            System.out.println("Ontologia caricata con successo!");

            // Step 2: Recupera i componenti RAM dall'ontologia
            List<RAM> ramComponents = ontologyLoader.getRAMComponents();

            // Step 3: Visualizza le RAM recuperate dall'ontologia
            if (!ramComponents.isEmpty()) {
                System.out.println("Componenti RAM trovati:");
                for (RAM ram : ramComponents) {
                    System.out.println("RAM trovata: " + ram.getRamName() + " - Size: " + ram.getRamSize() + "GB");
                }
            } else {
                System.out.println("Nessun componente RAM trovato.");
            }
        } else {
            System.out.println("Errore nel caricamento dell'ontologia.");
        }
    }
}
