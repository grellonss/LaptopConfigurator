package org.example.configurator;

/**
 * Represents a peripheral device connected to a laptop.
 */
public class Peripheral {
    private Laptop peripheralOfLaptop;
    private String connectionType; // Bluetooth, USB, Wireless

    /**
     * Constructs a Peripheral with the specified laptop and connection type.
     *
     * @param peripheralOfLaptop the laptop to which this peripheral is connected
     * @param connectionType the type of connection (e.g., Bluetooth, USB, Wireless)
     */
    public Peripheral(Laptop peripheralOfLaptop, String connectionType) {
        this.peripheralOfLaptop = peripheralOfLaptop;
        this.connectionType = connectionType;
    }

    /**
     * Creates a clone of this Peripheral object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned Peripheral
     * @return a new Peripheral object with the same attributes as this one
     */
    public Peripheral clone(Laptop laptop) {
        return new Peripheral(this.peripheralOfLaptop, this.connectionType);
    }

    /**
     * Returns the connection type of the peripheral.
     *
     * @return the connection type of the peripheral
     */
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * Sets the connection type of the peripheral.
     *
     * @param connectionType the new connection type of the peripheral
     */
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    /**
     * Returns the laptop to which this peripheral is connected.
     *
     * @return the laptop to which this peripheral is connected
     */
    public Laptop getPeripheralOfLaptop() {
        return peripheralOfLaptop;
    }

    /**
     * Sets the laptop to which this peripheral is connected.
     *
     * @param peripheralOfLaptop the new laptop to which this peripheral should be connected
     */
    public void setPeripheralOfLaptop(Laptop peripheralOfLaptop) {
        this.peripheralOfLaptop = peripheralOfLaptop;
    }
}
