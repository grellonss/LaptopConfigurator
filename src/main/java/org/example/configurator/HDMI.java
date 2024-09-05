package org.example.configurator;

public class HDMI extends Port {

    private String HDMIVersion;

    public HDMI(String portName, double price, String HDMIVersion) {
        super(portName, price);
        this.HDMIVersion = HDMIVersion;
    }

    public String getHDMIVersion() {
        return HDMIVersion;
    }

    public void setHDMIVersion(String HDMIVersion) {
        this.HDMIVersion = HDMIVersion;
    }
}
