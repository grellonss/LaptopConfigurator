package org.example.configurator;

/**
 * Represents a port on a laptop.
 */
public class Port {

    private Laptop portOfLaptop;
    // Name of the port type (e.g., Port 1, Port 2)
    private Integer portName;

    /**
     * Constructs a Port with the specified laptop and port name.
     *
     * @param portOfLaptop the laptop to which this port belongs
     * @param portName the name of the port (e.g., Port 1, Port 2)
     */
    public Port(Laptop portOfLaptop, Integer portName) {
        this.portOfLaptop = portOfLaptop;
        this.portName = portName;
    }

    /**
     * Creates a clone of this Port object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned Port
     * @return a new Port object with the same attributes as this one
     */
    public Port clone(Laptop laptop) {
        return new Port(portOfLaptop, this.portName);
    }

    /**
     * Returns the name of the port.
     *
     * @return the name of the port
     */
    public Integer getPortName() {
        return portName;
    }

    /**
     * Sets the name of the port.
     *
     * @param portName the new name of the port
     */
    public void setPortName(Integer portName) {
        this.portName = portName;
    }

    /**
     * Returns the laptop to which this port belongs.
     *
     * @return the laptop to which this port belongs
     */
    public Laptop getPortOfLaptop() {
        return portOfLaptop;
    }

    /**
     * Sets the laptop to which this port belongs.
     *
     * @param portOfLaptop the new laptop to which this port should belong
     */
    public void setPortOfLaptop(Laptop portOfLaptop) {
        this.portOfLaptop = portOfLaptop;
    }
}
