package org.example.configurator;

import org.example.configurator.Laptop;

/**
 * Represents the security features of a laptop.
 */
public class Security {
    private Laptop laptopOfSecurity;

    /**
     * Constructs a Security object with the specified laptop.
     *
     * @param laptopOfSecurity the laptop associated with this security feature
     */
    public Security(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }

    /**
     * Creates a clone of this Security object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned Security
     * @return a new Security object with the same attributes as this one
     */
    public Security clone(Laptop laptop) {
        return new Security(laptopOfSecurity);
    }

    /**
     * Returns the laptop associated with this security feature.
     *
     * @return the laptop associated with this security feature
     */
    public Laptop getLaptopOfSecurity() {
        return laptopOfSecurity;
    }

    /**
     * Sets the laptop associated with this security feature.
     *
     * @param laptopOfSecurity the new laptop to associate with this security feature
     */
    public void setLaptopOfSecurity(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }
}
