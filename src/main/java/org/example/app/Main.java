package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.configurator.Laptop;
import org.example.ontology.OntologyLoader;

public class Main {
    public static void main(String[] args) {
        // Step 1: Carica l'ontologia
        String ontologyFilePath = "LaptopConfigModellazione.rdf"; // Assumendo che sia nella cartella resources
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        // Verifica che l'ontologia sia stata caricata correttamente
        if (model != null) {
            System.out.println("Ontologia caricata con successo!");

            // Step 2: Eventuale logica per la configurazione del laptop
            // Puoi qui iniziare a costruire la logica per ottenere informazioni
            // dall'ontologia, interagire con le classi Laptop, Component, ecc.

            // Per esempio, visualizza le classi definite nell'ontologia
            model.listClasses().forEachRemaining(ontClass -> {
                System.out.println("Classe nell'ontologia: " + ontClass.getLocalName());
            });

            // Step 3: Implementa la logica del configuratore di laptop
            // Potresti iniziare a creare un oggetto Laptop, aggiungere componenti, ecc.

            // Esempio:
            Laptop laptop = new Laptop();
            // Configurazione del laptop qui...

        } else {
            System.out.println("Errore nel caricamento dell'ontologia.");
        }
    }
}
