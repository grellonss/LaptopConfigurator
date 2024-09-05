package org.example.configurator;

public class Port {
    //nome della porta tipo (porta 1, porta 2)
    private String portName;

    public Port(String portName) {
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

}
