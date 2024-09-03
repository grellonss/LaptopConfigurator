package org.example;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private AudioSystem audioSystem;
    private Colour colour;
    private List<Component> components; // Una lista di componenti
    private List<Peripheral> peripherals; // Una lista di periferiche
    private List<Port> ports; // Una lista di porte
    private List<Security> securities; // Una lista di elementi di sicurezza
    private Warranty warranty;
    private CoolingSystem coolingSystem;
    private Battery battery;

    public Laptop() {
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.ports = new ArrayList<>();
        this.securities = new ArrayList<>();
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

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Component component : components) {
            totalPrice += component.getPrice();
        }
        for (Peripheral peripheral : peripherals) {
            totalPrice += peripheral.getPrice();
        }
        for (Port port : ports) {
            totalPrice += port.getPrice();
        }
        for (Security security : securities) {
            totalPrice += security.getPrice();
        }
        if (audioSystem != null) {
            totalPrice += audioSystem.getPrice();
        }
        if (coolingSystem != null) {
            totalPrice += coolingSystem.getPrice();
        }
        if (battery != null) {
            totalPrice += battery.getPrice();
        }
        if (warranty != null) {
            totalPrice += warranty.getPrice();
        }
        return totalPrice;
    }

    public boolean isValidConfiguration() {
        // Logica per validare la configurazione del laptop
        return components.stream().anyMatch(c -> c instanceof CPU) &&
                components.stream().anyMatch(c -> c instanceof RAM) &&
                components.stream().anyMatch(c -> c instanceof Storage) &&
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

    public Laptop cloneConfiguration() {
        Laptop clonedLaptop = new Laptop();
        clonedLaptop.components.addAll(this.components);
        clonedLaptop.peripherals.addAll(this.peripherals);
        clonedLaptop.ports.addAll(this.ports);
        clonedLaptop.securities.addAll(this.securities);
        clonedLaptop.audioSystem = this.audioSystem;
        clonedLaptop.colour = this.colour;
        clonedLaptop.coolingSystem = this.coolingSystem;
        clonedLaptop.battery = this.battery;
        clonedLaptop.warranty = this.warranty;
        return clonedLaptop;
    }
}
