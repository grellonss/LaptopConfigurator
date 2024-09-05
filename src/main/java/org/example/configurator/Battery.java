package org.example.configurator;

public class Battery {

    private double batteryCapacity;

    public Battery(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

}
