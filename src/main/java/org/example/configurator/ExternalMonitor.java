package org.example.configurator;

public class ExternalMonitor extends Peripheral {
    private String externalDisplayResolution;

    public ExternalMonitor(String connectionType, double price, String externalDisplayResolution) {
        super(connectionType, price);
        this.externalDisplayResolution = externalDisplayResolution;
    }

    public String getExternalDisplayResolution() {
        return externalDisplayResolution;
    }

    public void setExternalDisplayResolution(String externalDisplayResolution) {
        this.externalDisplayResolution = externalDisplayResolution;
    }
}
