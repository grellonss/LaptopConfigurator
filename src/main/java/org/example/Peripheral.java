package org.example;

public class Peripheral {
    private String connectionType; //Bluetooth, USB, Wireless
    private double price;

    public Peripheral(String connectionType, double price) {
        this.connectionType = connectionType;
        this.price = price;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
