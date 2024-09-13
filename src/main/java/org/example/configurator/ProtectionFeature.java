package org.example.configurator;

/**
 * Represents a protection feature of a laptop's security system.
 */
public class ProtectionFeature extends Security {
    private String protectionFeatureName;
    private String typeProtectionFeature;

    /**
     * Constructs a ProtectionFeature with the specified laptop, protection feature name, and type of protection feature.
     *
     * @param laptopOfSecurity the laptop associated with this security feature
     * @param protectionFeatureName the name of the protection feature
     * @param typeProtectionFeature the type of the protection feature
     */
    public ProtectionFeature(Laptop laptopOfSecurity, String protectionFeatureName, String typeProtectionFeature) {
        super(laptopOfSecurity);
        this.protectionFeatureName = protectionFeatureName;
        this.typeProtectionFeature = typeProtectionFeature;
    }

    /**
     * Returns the type of the protection feature.
     *
     * @return the type of the protection feature
     */
    public String getTypeProtectionFeature() {
        return typeProtectionFeature;
    }

    /**
     * Sets the type of the protection feature.
     *
     * @param typeProtectionFeature the new type of the protection feature
     */
    public void setTypeProtectionFeature(String typeProtectionFeature) {
        this.typeProtectionFeature = typeProtectionFeature;
    }

    /**
     * Returns the name of the protection feature.
     *
     * @return the name of the protection feature
     */
    public String getProtectionFeatureName() {
        return protectionFeatureName;
    }

    /**
     * Sets the name of the protection feature.
     *
     * @param protectionFeatureName the new name of the protection feature
     */
    public void setProtectionFeatureName(String protectionFeatureName) {
        this.protectionFeatureName = protectionFeatureName;
    }

    /**
     * Creates a clone of this ProtectionFeature object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned ProtectionFeature
     * @return a new ProtectionFeature object with the same attributes as this one
     */
    @Override
    public ProtectionFeature clone(Laptop laptop) {
        return new ProtectionFeature(getLaptopOfSecurity(), this.protectionFeatureName, this.typeProtectionFeature);
    }

    /**
     * Returns a string representation of the protection feature.
     *
     * @return a string representing the protection feature name and type
     */
    @Override
    public String toString() {
        return protectionFeatureName + " (Type: " + typeProtectionFeature + ")";
    }
}
