package org.example.configurator;

public class CoolingSystem {

    private Laptop coolingSystemOfLaptop;
    private String coolingSystemName;
    private String coolingSystemType;

    public CoolingSystem(Laptop coolingSystemOfLaptop, String coolingSystemName, String coolingSystemType) {
        this.coolingSystemOfLaptop = coolingSystemOfLaptop;
        this.coolingSystemName = coolingSystemName;
        this.coolingSystemType = coolingSystemType;
    }
    public CoolingSystem clone(Laptop laptop) {
        return new CoolingSystem(coolingSystemOfLaptop, this.coolingSystemName, this.coolingSystemType);
    }
    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }

    public Laptop getCoolingSystemOfLaptop() {
        return coolingSystemOfLaptop;
    }

    public void setCoolingSystemOfLaptop(Laptop coolingSystemOfLaptop) {
        this.coolingSystemOfLaptop = coolingSystemOfLaptop;
    }

    public String getCoolingSystemName() {
        return coolingSystemName;
    }

    public void setCoolingSystemName(String coolingSystemName) {
        this.coolingSystemName = coolingSystemName;
    }
}
