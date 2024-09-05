package org.example.configurator;

public class ExternalSpeaker extends Peripheral {
    private String externalAudioSystemType;

    public ExternalSpeaker(String connectionType, String externalAudioSystemType) {
        super(connectionType);
        this.externalAudioSystemType = externalAudioSystemType;
    }

    public String getExternalAudioSystemType() {
        return externalAudioSystemType;
    }

    public void setExternalAudioSystemType(String externalAudioSystemType) {
        this.externalAudioSystemType = externalAudioSystemType;
    }
}
