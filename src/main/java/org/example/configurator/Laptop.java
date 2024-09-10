package org.example.configurator;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String laptopName;  // Nome del laptop
    private AudioSystem audioSystem;
    private Colour colour;
    private List<Component> components; // Una lista di componenti
    private List<Peripheral> peripherals; // Una lista di periferiche
    private List<Port> ports; // Una lista di porte
    private List<Security> securities; // Una lista di elementi di sicurezza
    private Warranty warranty;
    private CoolingSystem coolingSystem;
    private Battery battery;

    // Costruttore con il nome del laptop
    public Laptop(String laptopName) {
        this.laptopName = laptopName;
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.ports = new ArrayList<>();
        this.securities = new ArrayList<>();
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public AudioSystem getAudioSystem() {
        return audioSystem;
    }

    public void setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(List<Peripheral> peripherals) {
        this.peripherals = peripherals;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    // Metodi per aggiungere e rimuovere componenti, periferiche, porte, ecc.
    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    public void addPeripheral(Peripheral peripheral) {
        this.peripherals.add(peripheral);
    }

    public void removePeripheral(Peripheral peripheral) {
        this.peripherals.remove(peripheral);
    }

    public void addPort(Port port) {
        this.ports.add(port);
    }

    public void removePort(Port port) {
        this.ports.remove(port);
    }

    public void addSecurity(Security security) {
        this.securities.add(security);
    }

    public void removeSecurity(Security security) {
        this.securities.remove(security);
    }

    // Metodo per clonare la configurazione del laptop
    public Laptop cloneConfiguration() {
        Laptop clonedLaptop = new Laptop(this.laptopName + " - Clone");

        for (Component component : this.components) {
            clonedLaptop.addComponent(component.clone());
        }

        for (Peripheral peripheral : this.peripherals) {
            clonedLaptop.addPeripheral(peripheral.clone(clonedLaptop));
        }

        for (Port port : this.ports) {
            clonedLaptop.addPort(port.clone(clonedLaptop));
        }

        for (Security security : this.securities) {
            clonedLaptop.addSecurity(security.clone(clonedLaptop));
        }

        clonedLaptop.setAudioSystem(this.audioSystem); // Considera di aggiungere il clone anche qui
        clonedLaptop.setColour(this.colour);           // Considera di aggiungere il clone anche qui
        clonedLaptop.setCoolingSystem(this.coolingSystem);
        clonedLaptop.setBattery(this.battery);
        clonedLaptop.setWarranty(this.warranty);

        return clonedLaptop;
    }

    // Metodo per visualizzare la configurazione del laptop
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laptop: ").append(laptopName).append("\n");
        sb.append("Components:\n");
        for (Component component : components) {
            sb.append(" - ").append(component.toString()).append("\n");
        }
        sb.append("Peripherals:\n");
        for (Peripheral peripheral : peripherals) {
            sb.append(" - ").append(peripheral.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean isValidConfiguration() {
        // Logica per validare la configurazione del laptop
        return components.stream().anyMatch(c -> c instanceof CPU) &&
                components.stream().anyMatch(c -> c instanceof RAM) &&
                components.stream().anyMatch(c -> c instanceof Storage) &&
                components.stream().anyMatch(c -> c instanceof GraphicsCard) &&
                components.stream().anyMatch(c -> c instanceof OperatingSystem);
    }

    public void resetConfiguration() {
        components.clear();
        peripherals.clear();
        ports.clear();
        securities.clear();
        audioSystem = null;
        colour = null;
        coolingSystem = null;
        battery = null;
        warranty = null;
    }

    public <T> void addOrReplace(List<T> list, T newItem) {
        // Controlla se esiste già un oggetto dello stesso tipo
        for (int i = 0; i < list.size(); i++) {
            T existingItem = list.get(i);
            if (existingItem.getClass() == newItem.getClass()) {
                // Sostituisci l'elemento esistente con quello nuovo
                list.set(i, newItem);
                System.out.println("Elemento " + newItem.getClass().getSimpleName() + " sostituito.");
                return;
            }
        }
        // Se non esiste già un elemento di questo tipo, aggiungilo
        list.add(newItem);
        System.out.println("Elemento " + newItem.getClass().getSimpleName() + " aggiunto.");
    }
    // Aggiungere o sostituire componenti
    public void addOrReplaceComponent(Component newComponent) {
        addOrReplace(this.components, newComponent);
    }

    // Aggiungere o sostituire periferiche
    public void addOrReplacePeripheral(Peripheral newPeripheral) {
        addOrReplace(this.peripherals, newPeripheral);
    }

    // Aggiungere o sostituire porte
    public void addOrReplacePort(Port newPort) {
        addOrReplace(this.ports, newPort);
    }

    // Aggiungere o sostituire elementi di sicurezza
    public void addOrReplaceSecurity(Security newSecurity) {
        addOrReplace(this.securities, newSecurity);
    }


}
