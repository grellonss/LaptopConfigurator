package org.example.configurator;

public class HDMI extends Port {

    private String HDMIVersion;

    public HDMI(String portName, String HDMIVersion) {
        super(portName);
        this.HDMIVersion = HDMIVersion;
    }

    public String getHDMIVersion() {
        return HDMIVersion;
    }

    public void setHDMIVersion(String HDMIVersion) {
        this.HDMIVersion = HDMIVersion;
    }
}
