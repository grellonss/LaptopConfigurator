package org.example;

public class Antivirus extends Security {
private String antivirusVersion;

    public Antivirus(double price, String securityPacket, String antivirusVersion) {
        super(price, securityPacket);
        this.antivirusVersion = antivirusVersion;
    }
    public String getAntivirusVersion() {
        return antivirusVersion;
    }

    public void setAntivirusVersion(String antivirusVersion) {
        this.antivirusVersion = antivirusVersion;
    }
}
