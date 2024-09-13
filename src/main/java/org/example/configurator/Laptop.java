package org.example.configurator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Laptop configuration with various components, peripherals, ports, and security features.
 */
public class Laptop {
    private String laptopName;  // Name of the laptop
    private AudioSystem audioSystem;
    private Colour colour;
    private List<Component> components; // List of components
    private List<Peripheral> peripherals; // List of peripherals
    private List<Port> ports; // List of ports
    private List<Security> securities; // List of security features
    private Warranty warranty;
    private CoolingSystem coolingSystem;
    private Battery battery;

    /**
     * Constructor that initializes a laptop with its name.
     *
     * @param laptopName The name of the laptop.
     */
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

    /**
     * Adds a component to the laptop's component list.
     *
     * @param component The component to add.
     */
    public void addComponent(Component component) {
        this.components.add(component);
    }

    /**
     * Removes a component from the laptop's component list.
     *
     * @param component The component to remove.
     */
    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    /**
     * Adds a peripheral to the laptop's peripherals list.
     *
     * @param peripheral The peripheral to add.
     */
    public void addPeripheral(Peripheral peripheral) {
        this.peripherals.add(peripheral);
    }

    /**
     * Removes a peripheral from the laptop's peripherals list.
     *
     * @param peripheral The peripheral to remove.
     */
    public void removePeripheral(Peripheral peripheral) {
        this.peripherals.remove(peripheral);
    }

    /**
     * Adds a port to the laptop's ports list.
     *
     * @param port The port to add.
     */
    public void addPort(Port port) {
        this.ports.add(port);
    }

    /**
     * Removes a port from the laptop's ports list.
     *
     * @param port The port to remove.
     */
    public void removePort(Port port) {
        this.ports.remove(port);
    }

    /**
     * Adds a security feature to the laptop's security list.
     *
     * @param security The security feature to add.
     */
    public void addSecurity(Security security) {
        this.securities.add(security);
    }

    /**
     * Removes a security feature from the laptop's security list.
     *
     * @param security The security feature to remove.
     */
    public void removeSecurity(Security security) {
        this.securities.remove(security);
    }

    /**
     * Clones the current laptop configuration, including components, peripherals, ports, and security features.
     *
     * @return A new Laptop object with the same configuration.
     */
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

        clonedLaptop.setAudioSystem(this.audioSystem);
        clonedLaptop.setColour(this.colour);
        clonedLaptop.setCoolingSystem(this.coolingSystem);
        clonedLaptop.setBattery(this.battery);
        clonedLaptop.setWarranty(this.warranty);

        return clonedLaptop;
    }

    /**
     * Displays the laptop configuration as a string, including components and peripherals.
     *
     * @return A string representation of the laptop configuration.
     */
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

    /**
     * Validates the laptop configuration to ensure that essential components are present.
     *
     * @return true if the configuration is valid, false otherwise.
     */
    public boolean isValidConfiguration() {
        return components.stream().anyMatch(c -> c instanceof CPU) &&
                components.stream().anyMatch(c -> c instanceof RAM) &&
                components.stream().anyMatch(c -> c instanceof Storage) &&
                components.stream().anyMatch(c -> c instanceof GraphicsCard) &&
                components.stream().anyMatch(c -> c instanceof OperatingSystem);
    }

    /**
     * Resets the laptop configuration, removing all components, peripherals, ports, and security features.
     */
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

    /**
     * Adds or replaces an item in the specified list based on the item's type.
     *
     * @param list    The list in which to add or replace the item.
     * @param newItem The new item to add or replace.
     * @param <T>     The type of the item.
     */
    public <T> void addOrReplace(List<T> list, T newItem) {
        for (int i = 0; i < list.size(); i++) {
            T existingItem = list.get(i);
            if (existingItem.getClass() == newItem.getClass()) {
                list.set(i, newItem);
                System.out.println("Replaced " + newItem.getClass().getSimpleName() + ".");
                return;
            }
        }
        list.add(newItem);
        System.out.println("Added " + newItem.getClass().getSimpleName() + ".");
    }

    /**
     * Adds or replaces a component in the laptop's component list.
     *
     * @param newComponent The new component to add or replace.
     */
    public void addOrReplaceComponent(Component newComponent) {
        addOrReplace(this.components, newComponent);
    }

    /**
     * Adds or replaces a peripheral in the laptop's peripherals list.
     *
     * @param newPeripheral The new peripheral to add or replace.
     */
    public void addOrReplacePeripheral(Peripheral newPeripheral) {
        addOrReplace(this.peripherals, newPeripheral);
    }

    /**
     * Adds or replaces a port in the laptop's ports list.
     *
     * @param newPort The new port to add or replace.
     */
    public void addOrReplacePort(Port newPort) {
        addOrReplace(this.ports, newPort);
    }

    /**
     * Adds or replaces a security feature in the laptop's security list.
     *
     * @param newSecurity The new security feature to add or replace.
     */
    public void addOrReplaceSecurity(Security newSecurity) {
        addOrReplace(this.securities, newSecurity);
    }
}
