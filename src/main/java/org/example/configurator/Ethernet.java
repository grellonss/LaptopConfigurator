package org.example.configurator;

public class Ethernet extends Port {

    private String ethernetSpeed;

    public Ethernet(String portName,  String ethernetSpeed) {
        super(portName);
        this.ethernetSpeed = ethernetSpeed;
    }


    public String getEthernetSpeed() {
        return ethernetSpeed;
    }

    public void setEthernetSpeed(String ethernetSpeed) {
        this.ethernetSpeed = ethernetSpeed;
    }
}
