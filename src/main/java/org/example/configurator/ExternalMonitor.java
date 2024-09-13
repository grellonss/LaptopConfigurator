package org.example.configurator;

/**
 * Represents an external monitor component in a laptop, including the monitor's name and display resolution.
 */
public class ExternalMonitor extends Peripheral {

    private String exMonitorName;
    private String externalDisplayResolution;

    /**
     * Constructor to create an external monitor associated with a specific laptop.
     *
     * @param peripheralOfLaptop The laptop to which the external monitor is connected.
     * @param connectionType     The type of connection for the external monitor.
     * @param exMonitorName      The name of the external monitor.
     * @param externalDisplayResolution The resolution of the external monitor.
     */
    public ExternalMonitor(Laptop peripheralOfLaptop, String connectionType, String exMonitorName, String externalDisplayResolution) {
        super(peripheralOfLaptop, connectionType);
        this.exMonitorName = exMonitorName;
        this.externalDisplayResolution = externalDisplayResolution;
    }

    /**
     * Creates a clone of the current ExternalMonitor object, preserving the laptop association.
     *
     * @param laptop The laptop associated with the cloned external monitor.
     * @return A cloned ExternalMonitor object.
     */
    @Override
    public ExternalMonitor clone(Laptop laptop) {
        return new ExternalMonitor(getPeripheralOfLaptop(), getConnectionType(), this.exMonitorName, this.externalDisplayResolution);
    }

    /**
     * Gets the resolution of the external monitor.
     *
     * @return The resolution of the external monitor.
     */
    public String getExternalDisplayResolution() {
        return externalDisplayResolution;
    }

    /**
     * Sets the resolution of the external monitor.
     *
     * @param externalDisplayResolution The resolution of the external monitor.
     */
    public void setExternalDisplayResolution(String externalDisplayResolution) {
        this.externalDisplayResolution = externalDisplayResolution;
    }

    /**
     * Gets the name of the external monitor.
     *
     * @return The name of the external monitor.
     */
    public String getExMonitorName() {
        return exMonitorName;
    }

    /**
     * Sets the name of the external monitor.
     *
     * @param exMonitorName The name of the external monitor.
     */
    public void setExMonitorName(String exMonitorName) {
        this.exMonitorName = exMonitorName;
    }

    /**
     * Returns a string representation of the external monitor, including its name and resolution.
     *
     * @return A string representation of the external monitor.
     */
    @Override
    public String toString() {
        return exMonitorName + " (" + externalDisplayResolution + ")";
    }
}
