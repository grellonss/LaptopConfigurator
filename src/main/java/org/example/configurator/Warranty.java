package org.example.configurator;

import org.example.configurator.Laptop;

/**
 * Represents a warranty for a laptop.
 */
public class Warranty {

    private Laptop laptopOfWarranty;
    private String warrantyName;
    private int warrantyPeriod; // Duration of the warranty in years

    /**
     * Constructs a Warranty object with the specified laptop, warranty name, and warranty period.
     *
     * @param laptopOfWarranty the laptop associated with this warranty
     * @param warrantyName the name of the warranty
     * @param warrantyPeriod the duration of the warranty in years
     */
    public Warranty(Laptop laptopOfWarranty, String warrantyName, int warrantyPeriod) {
        this.laptopOfWarranty = laptopOfWarranty;
        this.warrantyName = warrantyName;
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Creates a clone of this Warranty object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned Warranty
     * @return a new Warranty object with the same attributes as this one
     */
    public Warranty clone(Laptop laptop) {
        return new Warranty(laptopOfWarranty, this.warrantyName, this.warrantyPeriod);
    }

    /**
     * Returns the duration of the warranty in years.
     *
     * @return the duration of the warranty in years
     */
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    /**
     * Sets the duration of the warranty.
     *
     * @param warrantyPeriod the new duration of the warranty in years
     */
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Returns the laptop associated with this warranty.
     *
     * @return the laptop associated with this warranty
     */
    public Laptop getLaptopOfWarranty() {
        return laptopOfWarranty;
    }

    /**
     * Sets the laptop associated with this warranty.
     *
     * @param laptopOfWarranty the new laptop to associate with this warranty
     */
    public void setLaptopOfWarranty(Laptop laptopOfWarranty) {
        this.laptopOfWarranty = laptopOfWarranty;
    }

    /**
     * Returns the name of the warranty.
     *
     * @return the name of the warranty
     */
    public String getWarrantyName() {
        return warrantyName;
    }

    /**
     * Sets the name of the warranty.
     *
     * @param warrantyName the new name of the warranty
     */
    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }

    /**
     * Returns a string representation of the warranty.
     *
     * @return a string representing the warranty name and duration
     */
    @Override
    public String toString() {
        return warrantyName + " (Duration: " + warrantyPeriod + " years)";
    }
}
