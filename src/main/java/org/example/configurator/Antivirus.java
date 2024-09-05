package org.example.configurator;

public class Antivirus extends Security {
private String antivirusVersion;

    public Antivirus(Laptop laptopOfSecurity, String securityPacket, double price, String antivirusVersion) {
        super(laptopOfSecurity, securityPacket, price);
        this.antivirusVersion = antivirusVersion;
    }

    public String getAntivirusVersion() {
        return antivirusVersion;
    }

    public void setAntivirusVersion(String antivirusVersion) {
        this.antivirusVersion = antivirusVersion;
    }
}
