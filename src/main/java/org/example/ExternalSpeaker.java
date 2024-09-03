package org.example;

public class ExternalSpeaker extends Peripheral {
    private String externalAudioSystemType;

    public ExternalSpeaker(double price, String externalAudioSystemType) {
        super(price);
        this.externalAudioSystemType = externalAudioSystemType;
    }


    public String getExternalAudioSystemType() {
        return externalAudioSystemType;
    }

    public void setExternalAudioSystemType(String externalAudioSystemType) {
        this.externalAudioSystemType = externalAudioSystemType;
    }
}
