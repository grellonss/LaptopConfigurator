package org.example.configurator;

public class Port {

    private Laptop portOfLaptop;
    //nome della porta tipo (porta 1, porta 2)
    private Integer portName;

    public Port(Laptop portOfLaptop, Integer portName) {
        this.portOfLaptop = portOfLaptop;
        this.portName = portName;
    }
    public Port clone(Laptop laptop) {
        return new Port(portOfLaptop, this.portName);
    }
    public Integer getPortName() {
        return portName;
    }

    public void setPortName(Integer portName) {
        this.portName = portName;
    }

    public Laptop getPortOfLaptop() {
        return portOfLaptop;
    }

    public void setPortOfLaptop(Laptop portOfLaptop) {
        this.portOfLaptop = portOfLaptop;
    }
}
