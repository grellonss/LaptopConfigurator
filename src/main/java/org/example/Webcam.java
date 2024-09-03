package org.example;

public class Webcam extends Peripheral {
    private String webcamResolution;

    public Webcam(String connectionType, double price, String webcamResolution) {
        super(connectionType, price);
        this.webcamResolution = webcamResolution;
    }
    public String getWebcamResolution() {
        return webcamResolution;
    }

    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }
}
