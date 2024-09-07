package org.example.configurator;

public class ProtectionFeature extends Security {
    private String protectionFeatureName;
    private String typeProtectionFeature;

    public ProtectionFeature(Laptop laptopOfSecurity, String protectionFeatureName, String typeProtectionFeature) {
        super(laptopOfSecurity);
        this.protectionFeatureName = protectionFeatureName;
        this.typeProtectionFeature = typeProtectionFeature;
    }

    public String getTypeProtectionFeature() {
        return typeProtectionFeature;
    }

    public void setTypeProtectionFeature(String typeProtectionFeature) {
        this.typeProtectionFeature = typeProtectionFeature;
    }

    public String getProtectionFeatureName() {
        return protectionFeatureName;
    }

    public void setProtectionFeatureName(String protectionFeatureName) {
        this.protectionFeatureName = protectionFeatureName;
    }
    @Override
    public ProtectionFeature clone(Laptop laptop) {
        return new ProtectionFeature(getLaptopOfSecurity(), this.protectionFeatureName, this.typeProtectionFeature);
    }
}
