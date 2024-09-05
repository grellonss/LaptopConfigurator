package org.example.configurator;

public class AudioSystem {

    private String audioSystemType;

    public AudioSystem(String audioSystemType) {
        this.audioSystemType = audioSystemType;
    }


    public String getAudioSystemType() {
        return audioSystemType;
    }

    public void setAudioSystemType(String audioSystemType) {
        this.audioSystemType = audioSystemType;
    }

}
