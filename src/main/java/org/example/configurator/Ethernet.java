package org.example.configurator;

/**
 * Represents an Ethernet port component in a laptop, including the port's name and speed.
 */
public class Ethernet extends Port {

    private String ethernetName;
    private String ethernetSpeed;

    /**
     * Constructor to create an Ethernet port associated with a specific laptop.
     *
     * @param portOfLaptop The laptop to which the Ethernet port belongs.
     * @param portName     The name/identifier of the port.
     * @param ethernetName The name of the Ethernet port.
     * @param ethernetSpeed The speed of the Ethernet port.
     */
    public Ethernet(Laptop portOfLaptop, Integer portName, String ethernetName, String ethernetSpeed) {
        super(portOfLaptop, portName);
        this.ethernetName = ethernetName;
        this.ethernetSpeed = ethernetSpeed;
    }

    /**
     * Creates a clone of the current Ethernet object, preserving the laptop association.
     *
     * @param laptop The laptop associated with the cloned Ethernet port.
     * @return A cloned Ethernet object.
     */
    @Override
    public Ethernet clone(Laptop laptop) {
        return new Ethernet(getPortOfLaptop(), this.getPortName(), this.ethernetName, this.getEthernetSpeed());
    }

    /**
     * Gets the Ethernet speed.
     *
     * @return The speed of the Ethernet port.
     */
    public String getEthernetSpeed() {
        return ethernetSpeed;
    }

    /**
     * Sets the Ethernet speed.
     *
     * @param ethernetSpeed The speed of the Ethernet port.
     */
    public void setEthernetSpeed(String ethernetSpeed) {
        this.ethernetSpeed = ethernetSpeed;
    }

    /**
     * Gets the Ethernet name.
     *
     * @return The name of the Ethernet port.
     */
    public String getEthernetName() {
        return ethernetName;
    }

    /**
     * Sets the Ethernet name.
     *
     * @param ethernetName The name of the Ethernet port.
     */
    public void setEthernetName(String ethernetName) {
        this.ethernetName = ethernetName;
    }

    /**
     * Returns a string representation of the Ethernet port, including its name and speed.
     *
     * @return A string representation of the Ethernet port.
     */
    @Override
    public String toString() {
        return ethernetName + " (Speed: " + ethernetSpeed + ")";
    }
}
