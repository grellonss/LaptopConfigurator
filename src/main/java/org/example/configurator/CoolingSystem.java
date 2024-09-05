package org.example.configurator;

public class CoolingSystem {

    private String coolingSystemType;
    private double price;

    public CoolingSystem(String coolingSystemType, double price) {
        this.coolingSystemType = coolingSystemType;
        this.price = price;
    }
    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
