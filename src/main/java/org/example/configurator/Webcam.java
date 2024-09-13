package org.example.configurator;

import org.example.configurator.Peripheral;

public class Webcam extends Peripheral {
    private String webcamName;
    private String webcamResolution;

    public Webcam(Laptop peripheralOfLaptop, String connectionType, String webcamName, String webcamResolution) {
        super(peripheralOfLaptop,connectionType);
        this.webcamName = webcamName;
        this.webcamResolution = webcamResolution;
    }
    @Override
    public Webcam clone(Laptop laptop) {
        return new Webcam(getPeripheralOfLaptop(), getConnectionType(),this.webcamName, this.webcamResolution);
    }
    public String getWebcamResolution() {
        return webcamResolution;
    }

    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }

    public String getWebcamName() {
        return webcamName;
    }

    public void setWebcamName(String webcamName) {
        this.webcamName = webcamName;
    }

    @Override
    public String toString() {
        return webcamName + " (Risoluzione: " + webcamResolution + ")";
    }
}
