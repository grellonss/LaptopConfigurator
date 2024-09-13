package org.example.configurator;

public class AudioSystem {

    private Laptop audioSystemOfLaptop;
    private String audioSystemName;
    private String audioSystemType;

    public AudioSystem(Laptop audioSystemOfLaptop, String audioSystemName, String audioSystemType) {
        this.audioSystemOfLaptop = audioSystemOfLaptop;
        this.audioSystemName = audioSystemName;
        this.audioSystemType = audioSystemType;
    }
    public AudioSystem clone(Laptop laptop){
        return new AudioSystem(this.audioSystemOfLaptop, this.audioSystemName, this.audioSystemType);
    }

    public String getAudioSystemType() {
        return audioSystemType;
    }

    public void setAudioSystemType(String audioSystemType) {
        this.audioSystemType = audioSystemType;
    }

    public String getAudioSystemName() {
        return audioSystemName;
    }

    public void setAudioSystemName(String audioSystemName) {
        this.audioSystemName = audioSystemName;
    }

    public Laptop getAudioSystemOfLaptop() {
        return audioSystemOfLaptop;
    }

    public void setAudioSystemOfLaptop(Laptop audioSystemOfLaptop) {
        this.audioSystemOfLaptop = audioSystemOfLaptop;
    }

    @Override
    public String toString() {
        return audioSystemName + " (Tipo: " + audioSystemType + ")";
    }
}
