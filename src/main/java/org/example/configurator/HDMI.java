package org.example.configurator;

public class HDMI extends Port {

    private String HDMIName;

    private String HDMIVersion;

    public HDMI(Laptop portOfLaptop, Integer portName, String HDMIName, String HDMIVersion) {
        super(portOfLaptop, portName);
        this.HDMIName = HDMIName;
        this.HDMIVersion = HDMIVersion;
    }
    @Override
    public HDMI clone(Laptop laptop) {
        return new HDMI(getPortOfLaptop(), this.getPortName(), this.HDMIName, this.HDMIVersion);
    }
    public String getHDMIVersion() {
        return HDMIVersion;
    }

    public void setHDMIVersion(String HDMIVersion) {
        this.HDMIVersion = HDMIVersion;
    }

    public String getHDMIName() {
        return HDMIName;
    }

    public void setHDMIName(String HDMIName) {
        this.HDMIName = HDMIName;
    }

    @Override
    public String toString() {
        return HDMIName + " (Versione: " + HDMIVersion + ")";
    }
}
