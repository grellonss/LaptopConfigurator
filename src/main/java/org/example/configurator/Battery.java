package org.example.configurator;

public class Battery {

    private double batteryCapacity;
    private double price;

    public Battery(double batteryCapacity, double price) {
        this.batteryCapacity = batteryCapacity;
        this.price = price;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
