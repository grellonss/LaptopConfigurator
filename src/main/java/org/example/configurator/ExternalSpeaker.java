package org.example.configurator;

/**
 * Represents an external speaker component in a laptop, including the speaker's name and audio system type.
 */
public class ExternalSpeaker extends Peripheral {

    private String exSpeakerName;
    private String externalAudioSystemType;

    /**
     * Constructor to create an external speaker associated with a specific laptop.
     *
     * @param peripheralOfLaptop     The laptop to which the external speaker is connected.
     * @param connectionType         The type of connection for the external speaker.
     * @param exSpeakerName          The name of the external speaker.
     * @param externalAudioSystemType The type of the external audio system.
     */
    public ExternalSpeaker(Laptop peripheralOfLaptop, String connectionType, String exSpeakerName, String externalAudioSystemType) {
        super(peripheralOfLaptop, connectionType);
        this.exSpeakerName = exSpeakerName;
        this.externalAudioSystemType = externalAudioSystemType;
    }

    /**
     * Creates a clone of the current ExternalSpeaker object, preserving the laptop association.
     *
     * @param laptop The laptop associated with the cloned external speaker.
     * @return A cloned ExternalSpeaker object.
     */
    @Override
    public ExternalSpeaker clone(Laptop laptop) {
        return new ExternalSpeaker(getPeripheralOfLaptop(), getConnectionType(), this.exSpeakerName, this.externalAudioSystemType);
    }

    /**
     * Gets the type of the external audio system.
     *
     * @return The type of the external audio system.
     */
    public String getExternalAudioSystemType() {
        return externalAudioSystemType;
    }

    /**
     * Sets the type of the external audio system.
     *
     * @param externalAudioSystemType The type of the external audio system.
     */
    public void setExternalAudioSystemType(String externalAudioSystemType) {
        this.externalAudioSystemType = externalAudioSystemType;
    }

    /**
     * Gets the name of the external speaker.
     *
     * @return The name of the external speaker.
     */
    public String getExSpeakerName() {
        return exSpeakerName;
    }

    /**
     * Sets the name of the external speaker.
     *
     * @param exSpeakerName The name of the external speaker.
     */
    public void setExSpeakerName(String exSpeakerName) {
        this.exSpeakerName = exSpeakerName;
    }

    /**
     * Returns a string representation of the external speaker, including its name and audio system type.
     *
     * @return A string representation of the external speaker.
     */
    @Override
    public String toString() {
        return exSpeakerName + " (" + externalAudioSystemType + ")";
    }
}
