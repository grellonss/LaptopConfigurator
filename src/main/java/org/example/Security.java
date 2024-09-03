package org.example;

public class Security {
    private Laptop laptopOfSecurity;
    private String securityPacket; //pacchetto di antivirus e features

    private double price;

    public Security(Laptop laptopOfSecurity, String securityPacket, double price) {
        this.laptopOfSecurity = laptopOfSecurity;
        this.securityPacket = securityPacket;
        this.price = price;
    }

    // Costruttore che accetta il prezzo

    public Laptop getLaptopOfSecurity() {
        return laptopOfSecurity;
    }

    public void setLaptopOfSecurity(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }

    public String getSecurityPacket() {
        return securityPacket;
    }

    public void setSecurityPacket(String securityPacket) {
        this.securityPacket = securityPacket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
