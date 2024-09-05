package org.example.configurator;

import org.example.configurator.Port;

public class USB extends Port {
    private String USBVersion;

    public USB(String portName, double price, String USBVersion) {
        super(portName, price);
        this.USBVersion = USBVersion;
    }

    public String getUSBVersion() {
        return USBVersion;
    }

    public void setUSBVersion(String USBVersion) {
        this.USBVersion = USBVersion;
    }
}
