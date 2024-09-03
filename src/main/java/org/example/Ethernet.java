package org.example;

public class Ethernet extends Port {

    private String ethernetSpeed;

    public Ethernet(double price, String ethernetSpeed) {
        super(price);
        this.ethernetSpeed = ethernetSpeed;
    }

    public String getEthernetSpeed() {
        return ethernetSpeed;
    }

    public void setEthernetSpeed(String ethernetSpeed) {
        this.ethernetSpeed = ethernetSpeed;
    }
}
