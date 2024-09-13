package org.example.configurator;

import org.example.configurator.Port;

public class USB extends Port {
    private String USBName;
    private String USBVersion;

    public USB(Laptop portOfLaptop,Integer portName, String USBName, String USBVersion) {
        super(portOfLaptop, portName);
        this.USBName = USBName;
        this.USBVersion = USBVersion;
    }
    @Override
    public USB clone(Laptop laptop) {
        return new USB(getPortOfLaptop(), this.getPortName(), this.USBName,this.USBVersion);
    }
    public String getUSBVersion() {
        return USBVersion;
    }

    public void setUSBVersion(String USBVersion) {
        this.USBVersion = USBVersion;
    }

    public String getUSBName() {
        return USBName;
    }

    public void setUSBName(String USBName) {
        this.USBName = USBName;
    }

    @Override
    public String toString() {
        return USBName + " (Versione: " + USBVersion + ")";
    }
}
