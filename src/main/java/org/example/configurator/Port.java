package org.example.configurator;

public class Port {
    //nome della porta tipo (porta 1, porta 2)
    private String portName;
    private double price;

    public Port(String portName, double price) {
        this.portName = portName;
        this.price = price;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
