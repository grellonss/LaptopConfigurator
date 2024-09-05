package org.example.configurator;

public class Peripheral {
    private String connectionType; //Bluetooth, USB, Wireless

    public Peripheral(String connectionType) {
        this.connectionType = connectionType;
    }
    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

}
