package org.example.configurator;

/**
 * Represents an HDMI port component in a laptop, including the HDMI port's name and version.
 */
public class HDMI extends Port {

    private String HDMIName;
    private String HDMIVersion;

    /**
     * Constructor to create an HDMI port associated with a specific laptop.
     *
     * @param portOfLaptop The laptop to which the HDMI port is associated.
     * @param portName     The name/identifier of the port.
     * @param HDMIName     The name of the HDMI port.
     * @param HDMIVersion  The version of the HDMI port.
     */
    public HDMI(Laptop portOfLaptop, Integer portName, String HDMIName, String HDMIVersion) {
        super(portOfLaptop, portName);
        this.HDMIName = HDMIName;
        this.HDMIVersion = HDMIVersion;
    }

    /**
     * Clones the HDMI object, preserving the associated laptop.
     *
     * @param laptop The laptop to which the cloned HDMI port will be associated.
     * @return A cloned HDMI object.
     */
    @Override
    public HDMI clone(Laptop laptop) {
        return new HDMI(getPortOfLaptop(), this.getPortName(), this.HDMIName, this.HDMIVersion);
    }

    /**
     * Gets the version of the HDMI port.
     *
     * @return The version of the HDMI port.
     */
    public String getHDMIVersion() {
        return HDMIVersion;
    }

    /**
     * Sets the version of the HDMI port.
     *
     * @param HDMIVersion The version of the HDMI port.
     */
    public void setHDMIVersion(String HDMIVersion) {
        this.HDMIVersion = HDMIVersion;
    }

    /**
     * Gets the name of the HDMI port.
     *
     * @return The name of the HDMI port.
     */
    public String getHDMIName() {
        return HDMIName;
    }

    /**
     * Sets the name of the HDMI port.
     *
     * @param HDMIName The name of the HDMI port.
     */
    public void setHDMIName(String HDMIName) {
        this.HDMIName = HDMIName;
    }

    /**
     * Returns a string representation of the HDMI port, including its name and version.
     *
     * @return A string representation of the HDMI port.
     */
    @Override
    public String toString() {
        return HDMIName + " (Version: " + HDMIVersion + ")";
    }
}
