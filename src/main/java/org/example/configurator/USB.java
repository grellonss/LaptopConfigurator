package org.example.configurator;

import org.example.configurator.Port;

public class USB extends Port {
    private String USBVersion;

    public USB(String portName, String USBVersion) {
        super(portName);
        this.USBVersion = USBVersion;
    }

    public String getUSBVersion() {
        return USBVersion;
    }

    public void setUSBVersion(String USBVersion) {
        this.USBVersion = USBVersion;
    }
}
