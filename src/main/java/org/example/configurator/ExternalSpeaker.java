package org.example.configurator;

public class ExternalSpeaker extends Peripheral {
    private String exSpeakerName;
    private String externalAudioSystemType;

    public ExternalSpeaker(Laptop peripheralOfLaptop,String connectionType, String exSpeakerName, String externalAudioSystemType) {
        super(peripheralOfLaptop,connectionType);
        this.exSpeakerName = exSpeakerName;
        this.externalAudioSystemType = externalAudioSystemType;
    }
    @Override
    public ExternalSpeaker clone(Laptop laptop) {
        return new ExternalSpeaker(getPeripheralOfLaptop(), getConnectionType(),this.exSpeakerName, this.externalAudioSystemType);
    }
    public String getExternalAudioSystemType() {
        return externalAudioSystemType;
    }

    public void setExternalAudioSystemType(String externalAudioSystemType) {
        this.externalAudioSystemType = externalAudioSystemType;
    }

    public String getExSpeakerName() {
        return exSpeakerName;
    }

    public void setExSpeakerName(String exSpeakerName) {
        this.exSpeakerName = exSpeakerName;
    }
}
