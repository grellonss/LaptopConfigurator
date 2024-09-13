package org.example.configurator;

import org.example.configurator.Peripheral;

/**
 * Represents a webcam peripheral for a laptop.
 */
public class Webcam extends Peripheral {
    private String webcamName;
    private String webcamResolution;

    /**
     * Constructs a Webcam object with the specified laptop, connection type, webcam name, and resolution.
     *
     * @param peripheralOfLaptop the laptop associated with this webcam
     * @param connectionType the connection type of the webcam (e.g., Bluetooth, USB, Wireless)
     * @param webcamName the name of the webcam
     * @param webcamResolution the resolution of the webcam
     */
    public Webcam(Laptop peripheralOfLaptop, String connectionType, String webcamName, String webcamResolution) {
        super(peripheralOfLaptop, connectionType);
        this.webcamName = webcamName;
        this.webcamResolution = webcamResolution;
    }

    /**
     * Creates a clone of this Webcam object with the specified laptop.
     *
     * @param laptop the laptop to associate with the cloned Webcam
     * @return a new Webcam object with the same attributes as this one
     */
    @Override
    public Webcam clone(Laptop laptop) {
        return new Webcam(getPeripheralOfLaptop(), getConnectionType(), this.webcamName, this.webcamResolution);
    }

    /**
     * Returns the resolution of the webcam.
     *
     * @return the resolution of the webcam
     */
    public String getWebcamResolution() {
        return webcamResolution;
    }

    /**
     * Sets the resolution of the webcam.
     *
     * @param webcamResolution the new resolution of the webcam
     */
    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }

    /**
     * Returns the name of the webcam.
     *
     * @return the name of the webcam
     */
    public String getWebcamName() {
        return webcamName;
    }

    /**
     * Sets the name of the webcam.
     *
     * @param webcamName the new name of the webcam
     */
    public void setWebcamName(String webcamName) {
        this.webcamName = webcamName;
    }

    /**
     * Returns a string representation of the webcam.
     *
     * @return a string representing the webcam name and resolution
     */
    @Override
    public String toString() {
        return webcamName + " (Resolution: " + webcamResolution + ")";
    }
}
