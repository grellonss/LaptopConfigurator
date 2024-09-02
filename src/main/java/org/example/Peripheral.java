package org.example;

public class Peripheral {
    private String connectionType; //Bluetooth, USB, Wireless

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}
