package org.example.configurator;

public class Ethernet extends Port {

    private String ethernetName;
    private String ethernetSpeed;

    public Ethernet(Laptop portOfLaptop, Integer portName, String ethernetName, String ethernetSpeed) {
        super(portOfLaptop, portName);
        this.ethernetName = ethernetName;
        this.ethernetSpeed = ethernetSpeed;
    }
    @Override
    public Ethernet clone(Laptop laptop) {
        return new Ethernet(getPortOfLaptop(), this.getPortName(), this.ethernetName, this.getEthernetSpeed());
    }

    public String getEthernetSpeed() {
        return ethernetSpeed;
    }

    public void setEthernetSpeed(String ethernetSpeed) {
        this.ethernetSpeed = ethernetSpeed;
    }

    public String getEthernetName() {
        return ethernetName;
    }

    public void setEthernetName(String ethernetName) {
        this.ethernetName = ethernetName;
    }
}
