package org.example.configurator;

public class Antivirus extends Security {
    private String antivirusName;
    private String antivirusVersion;

    public Antivirus(Laptop laptopOfSecurity,String antivirusName, String antivirusVersion) {
        super(laptopOfSecurity);
        this.antivirusName = antivirusName;
        this.antivirusVersion = antivirusVersion;
    }

    public String getAntivirusVersion() {
        return antivirusVersion;
    }

    public void setAntivirusVersion(String antivirusVersion) {
        this.antivirusVersion = antivirusVersion;
    }

    public String getAntivirusName() {
        return antivirusName;
    }

    public void setAntivirusName(String antivirusName) {
        this.antivirusName = antivirusName;
    }

    @Override
    public Antivirus clone(Laptop laptop) {
        return new Antivirus(getLaptopOfSecurity(), this.antivirusName, this.antivirusName);
    }

    @Override
    public String toString() {
        return antivirusName + " (Versione: " + antivirusVersion + ")";
    }
}
