package org.example;

public class ProtectionFeature extends Security {
    private String typeProtectionFeature;

    public ProtectionFeature(double price, String securityPacket, String typeProtectionFeature) {
        super(price, securityPacket);
        this.typeProtectionFeature = typeProtectionFeature;
    }
    public String getTypeProtectionFeature() {
        return typeProtectionFeature;
    }

    public void setTypeProtectionFeature(String typeProtectionFeature) {
        this.typeProtectionFeature = typeProtectionFeature;
    }
}
