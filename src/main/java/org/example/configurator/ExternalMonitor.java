package org.example.configurator;

public class ExternalMonitor extends Peripheral {
    private String externalDisplayResolution;

    public ExternalMonitor(String connectionType, String externalDisplayResolution) {
        super(connectionType);
        this.externalDisplayResolution = externalDisplayResolution;
    }

    public String getExternalDisplayResolution() {
        return externalDisplayResolution;
    }

    public void setExternalDisplayResolution(String externalDisplayResolution) {
        this.externalDisplayResolution = externalDisplayResolution;
    }
}
