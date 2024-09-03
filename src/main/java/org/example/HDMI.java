package org.example;

public class HDMI extends Port {

    private String HDMIVersion;

    public HDMI(double price, String HDMIVersion) {
        super(price);
        this.HDMIVersion = HDMIVersion;
    }
    public String getHDMIVersion() {
        return HDMIVersion;
    }

    public void setHDMIVersion(String HDMIVersion) {
        this.HDMIVersion = HDMIVersion;
    }
}
