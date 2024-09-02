package org.example;

public class Security {
    private Laptop laptopOfSecurity;
    private String securityPacket; //pacchetto di antivirus e features

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
}
