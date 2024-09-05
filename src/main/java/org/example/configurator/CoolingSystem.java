package org.example.configurator;

public class CoolingSystem {

    private String coolingSystemType;

    public CoolingSystem(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }
    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }

}
