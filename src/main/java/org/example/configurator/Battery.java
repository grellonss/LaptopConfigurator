package org.example.configurator;

public class Battery {

    private Laptop batteryOfLaptop;
    private String batteryName;
    private double batteryCapacity;

    public Battery(Laptop batteryOfLaptop,String batteryName, double batteryCapacity) {
        this.batteryOfLaptop = batteryOfLaptop;
        this.batteryName = batteryName;
        this.batteryCapacity = batteryCapacity;
    }
    public Battery clone(Laptop laptop) {
        return new Battery(batteryOfLaptop,this.batteryName, this.batteryCapacity);
    }
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Laptop getBatteryOfLaptop() {
        return batteryOfLaptop;
    }

    public void setBatteryOfLaptop(Laptop batteryOfLaptop) {
        this.batteryOfLaptop = batteryOfLaptop;
    }

    public String getBatteryName() {
        return batteryName;
    }

    public void setBatteryName(String batteryName) {
        this.batteryName = batteryName;
    }

    @Override
    public String toString() {
        return batteryName + " (" + batteryCapacity + " mAh)";
    }
}
