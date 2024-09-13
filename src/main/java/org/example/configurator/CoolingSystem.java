package org.example.configurator;

/**
 * Represents the cooling system of a laptop.
 * It includes the name and type of the cooling system.
 */
public class CoolingSystem {

    private Laptop coolingSystemOfLaptop;
    private String coolingSystemName;
    private String coolingSystemType;

    /**
     * Constructor to create a CoolingSystem object associated with a specific laptop.
     *
     * @param coolingSystemOfLaptop The laptop to which the cooling system belongs.
     * @param coolingSystemName     The name of the cooling system.
     * @param coolingSystemType     The type of the cooling system.
     */
    public CoolingSystem(Laptop coolingSystemOfLaptop, String coolingSystemName, String coolingSystemType) {
        this.coolingSystemOfLaptop = coolingSystemOfLaptop;
        this.coolingSystemName = coolingSystemName;
        this.coolingSystemType = coolingSystemType;
    }

    /**
     * Creates a copy of the current cooling system object associated with a given laptop.
     *
     * @param laptop The laptop for which the clone is created.
     * @return A cloned CoolingSystem object.
     */
    public CoolingSystem clone(Laptop laptop) {
        return new CoolingSystem(coolingSystemOfLaptop, this.coolingSystemName, this.coolingSystemType);
    }

    /**
     * Gets the type of the cooling system.
     *
     * @return The type of the cooling system.
     */
    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    /**
     * Sets the type of the cooling system.
     *
     * @param coolingSystemType The type of the cooling system.
     */
    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }

    /**
     * Gets the laptop associated with the cooling system.
     *
     * @return The laptop this cooling system belongs to.
     */
    public Laptop getCoolingSystemOfLaptop() {
        return coolingSystemOfLaptop;
    }

    /**
     * Sets the laptop associated with the cooling system.
     *
     * @param coolingSystemOfLaptop The laptop to associate with the cooling system.
     */
    public void setCoolingSystemOfLaptop(Laptop coolingSystemOfLaptop) {
        this.coolingSystemOfLaptop = coolingSystemOfLaptop;
    }

    /**
     * Gets the name of the cooling system.
     *
     * @return The name of the cooling system.
     */
    public String getCoolingSystemName() {
        return coolingSystemName;
    }

    /**
     * Sets the name of the cooling system.
     *
     * @param coolingSystemName The name of the cooling system.
     */
    public void setCoolingSystemName(String coolingSystemName) {
        this.coolingSystemName = coolingSystemName;
    }

    /**
     * Returns a string representation of the cooling system, including its name and type.
     *
     * @return A string representation of the cooling system.
     */
    @Override
    public String toString() {
        return coolingSystemName + " (Type: " + coolingSystemType + ")";
    }
}
