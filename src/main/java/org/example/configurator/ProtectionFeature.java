package org.example.configurator;

public class ProtectionFeature extends Security {
    private String typeProtectionFeature;

    public ProtectionFeature(Laptop laptopOfSecurity, String securityPacket, double price, String typeProtectionFeature) {
        super(laptopOfSecurity, securityPacket, price);
        this.typeProtectionFeature = typeProtectionFeature;
    }

    public String getTypeProtectionFeature() {
        return typeProtectionFeature;
    }

    public void setTypeProtectionFeature(String typeProtectionFeature) {
        this.typeProtectionFeature = typeProtectionFeature;
    }
}
