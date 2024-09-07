package org.example.configurator;

public class ExternalMonitor extends Peripheral {
    private String exMonitorName;
    private String externalDisplayResolution;

    public ExternalMonitor(Laptop peripheralOfLaptop, String connectionType, String exMonitorName, String externalDisplayResolution) {
        super(peripheralOfLaptop,connectionType);
        this.exMonitorName = exMonitorName;
        this.externalDisplayResolution = externalDisplayResolution;
    }
    @Override
    public ExternalMonitor clone(Laptop laptop) {
        return new ExternalMonitor(getPeripheralOfLaptop(), getConnectionType(),this.exMonitorName, this.externalDisplayResolution);
    }
    public String getExternalDisplayResolution() {
        return externalDisplayResolution;
    }

    public void setExternalDisplayResolution(String externalDisplayResolution) {
        this.externalDisplayResolution = externalDisplayResolution;
    }

    public String getExMonitorName() {
        return exMonitorName;
    }

    public void setExMonitorName(String exMonitorName) {
        this.exMonitorName = exMonitorName;
    }
}
