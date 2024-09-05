package org.example.configurator;

public class Ethernet extends Port {

    private String ethernetSpeed;

    public Ethernet(String portName, double price, String ethernetSpeed) {
        super(portName, price);
        this.ethernetSpeed = ethernetSpeed;
    }


    public String getEthernetSpeed() {
        return ethernetSpeed;
    }

    public void setEthernetSpeed(String ethernetSpeed) {
        this.ethernetSpeed = ethernetSpeed;
    }
}
