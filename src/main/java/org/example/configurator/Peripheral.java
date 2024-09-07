package org.example.configurator;

public class Peripheral {
    private Laptop peripheralOfLaptop;
    private String connectionType; //Bluetooth, USB, Wireless

    public Peripheral(Laptop peripheralOfLaptop, String connectionType) {
        this.peripheralOfLaptop = peripheralOfLaptop;
        this.connectionType = connectionType;
    }
    public Peripheral clone(Laptop laptop) {
        return new Peripheral(this.peripheralOfLaptop,this.connectionType);
    }
    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public Laptop getPeripheralOfLaptop() {
        return peripheralOfLaptop;
    }

    public void setPeripheralOfLaptop(Laptop peripheralOfLaptop) {
        this.peripheralOfLaptop = peripheralOfLaptop;
    }

}
