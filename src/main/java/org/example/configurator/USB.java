package org.example.configurator;

import org.example.configurator.Port;

/**
 * Represents a USB port on a laptop.
 */
public class USB extends Port {
    private String usbName;
    private String usbVersion;

    /**
     * Constructs a USB object with the specified laptop, port name, USB name, and USB version.
     *
     * @param portOfLaptop the laptop associated with this USB port
     * @param portName the name of the port
     * @param usbName the name of the USB
     * @param usbVersion the version of the USB
     */
    public USB(Laptop portOfLaptop, Integer portName, String usbName, String usbVersion) {
        super(portOfLaptop, portName);
        this.usbName = usbName;
        this.usbVersion = usbVersion;
    }

    /**
     * Creates a clone of this USB object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned USB
     * @return a new USB object with the same attributes as this one
     */
    @Override
    public USB clone(Laptop laptop) {
        return new USB(getPortOfLaptop(), this.getPortName(), this.usbName, this.usbVersion);
    }

    /**
     * Returns the version of the USB.
     *
     * @return the version of the USB
     */
    public String getUsbVersion() {
        return usbVersion;
    }

    /**
     * Sets the version of the USB.
     *
     * @param usbVersion the new version of the USB
     */
    public void setUsbVersion(String usbVersion) {
        this.usbVersion = usbVersion;
    }

    /**
     * Returns the name of the USB.
     *
     * @return the name of the USB
     */
    public String getUsbName() {
        return usbName;
    }

    /**
     * Sets the name of the USB.
     *
     * @param usbName the new name of the USB
     */
    public void setUsbName(String usbName) {
        this.usbName = usbName;
    }

    /**
     * Returns a string representation of the USB.
     *
     * @return a string representing the USB name and version
     */
    @Override
    public String toString() {
        return usbName + " (Version: " + usbVersion + ")";
    }
}
