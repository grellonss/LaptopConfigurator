package org.example.configurator;

import org.example.configurator.Peripheral;

public class Webcam extends Peripheral {
    private String webcamResolution;

    public Webcam(String connectionType, String webcamResolution) {
        super(connectionType);
        this.webcamResolution = webcamResolution;
    }
    public String getWebcamResolution() {
        return webcamResolution;
    }

    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }
}
