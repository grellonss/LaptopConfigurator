package org.example;

public class ExternalMonitor extends Peripheral {
    private String externalDisplayResolution;

    public ExternalMonitor(double price, String externalDisplayResolution) {
        super(price);
        this.externalDisplayResolution = externalDisplayResolution;
    }


    public String getExternalDisplayResolution() {
        return externalDisplayResolution;
    }

    public void setExternalDisplayResolution(String externalDisplayResolution) {
        this.externalDisplayResolution = externalDisplayResolution;
    }
}
