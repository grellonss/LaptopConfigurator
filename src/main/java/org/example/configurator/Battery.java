package org.example.configurator;

/**
 * Represents a battery component for a laptop.
 */
public class Battery {

    private Laptop batteryOfLaptop;
    private String batteryName;
    private double batteryCapacity;

    /**
     * Constructor to create a Battery object with a specified laptop, name, and capacity.
     *
     * @param batteryOfLaptop The laptop that the battery is associated with.
     * @param batteryName     The name of the battery.
     * @param batteryCapacity The capacity of the battery in mAh.
     */
    public Battery(Laptop batteryOfLaptop, String batteryName, double batteryCapacity) {
        this.batteryOfLaptop = batteryOfLaptop;
        this.batteryName = batteryName;
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * Clones the current Battery object and associates it with the specified laptop.
     *
     * @param laptop The laptop to associate with the cloned battery.
     * @return A new {@link Battery} object with the same name and capacity.
     */
    public Battery clone(Laptop laptop) {
        return new Battery(batteryOfLaptop, this.batteryName, this.batteryCapacity);
    }

    /**
     * Gets the battery capacity.
     *
     * @return The capacity of the battery in mAh.
     */
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * Sets the battery capacity.
     *
     * @param batteryCapacity The new capacity of the battery in mAh.
     */
    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * Gets the laptop associated with the battery.
     *
     * @return The laptop associated with the battery.
     */
    public Laptop getBatteryOfLaptop() {
        return batteryOfLaptop;
    }

    /**
     * Sets the laptop associated with the battery.
     *
     * @param batteryOfLaptop The new laptop to associate with the battery.
     */
    public void setBatteryOfLaptop(Laptop batteryOfLaptop) {
        this.batteryOfLaptop = batteryOfLaptop;
    }

    /**
     * Gets the battery name.
     *
     * @return The name of the battery.
     */
    public String getBatteryName() {
        return batteryName;
    }

    /**
     * Sets the battery name.
     *
     * @param batteryName The new name of the battery.
     */
    public void setBatteryName(String batteryName) {
        this.batteryName = batteryName;
    }

    /**
     * Returns a string representation of the battery, including its name and capacity.
     *
     * @return A string describing the battery.
     */
    @Override
    public String toString() {
        return batteryName + " (" + batteryCapacity + " mAh)";
    }
}
