package org.example.configurator;

public class AudioSystem {

    private String audioSystemType;
    private double price;

    public AudioSystem(String audioSystemType, double price) {
        this.audioSystemType = audioSystemType;
        this.price = price;
    }


    public String getAudioSystemType() {
        return audioSystemType;
    }

    public void setAudioSystemType(String audioSystemType) {
        this.audioSystemType = audioSystemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
