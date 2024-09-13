package org.example.configurator;

/**
 * Represents an audio system component for a laptop.
 */
public class AudioSystem {

    private Laptop audioSystemOfLaptop;
    private String audioSystemName;
    private String audioSystemType;

    /**
     * Constructor to create an AudioSystem object with a specified laptop, name, and type.
     *
     * @param audioSystemOfLaptop The laptop that the audio system is associated with.
     * @param audioSystemName     The name of the audio system.
     * @param audioSystemType     The type of the audio system.
     */
    public AudioSystem(Laptop audioSystemOfLaptop, String audioSystemName, String audioSystemType) {
        this.audioSystemOfLaptop = audioSystemOfLaptop;
        this.audioSystemName = audioSystemName;
        this.audioSystemType = audioSystemType;
    }

    /**
     * Clones the current AudioSystem object and associates it with the specified laptop.
     *
     * @param laptop The laptop to associate with the cloned audio system.
     * @return A new {@link AudioSystem} object with the same name and type.
     */
    public AudioSystem clone(Laptop laptop) {
        return new AudioSystem(this.audioSystemOfLaptop, this.audioSystemName, this.audioSystemType);
    }

    /**
     * Gets the type of the audio system.
     *
     * @return The type of the audio system.
     */
    public String getAudioSystemType() {
        return audioSystemType;
    }

    /**
     * Sets the type of the audio system.
     *
     * @param audioSystemType The new type of the audio system.
     */
    public void setAudioSystemType(String audioSystemType) {
        this.audioSystemType = audioSystemType;
    }

    /**
     * Gets the name of the audio system.
     *
     * @return The name of the audio system.
     */
    public String getAudioSystemName() {
        return audioSystemName;
    }

    /**
     * Sets the name of the audio system.
     *
     * @param audioSystemName The new name of the audio system.
     */
    public void setAudioSystemName(String audioSystemName) {
        this.audioSystemName = audioSystemName;
    }

    /**
     * Gets the laptop associated with the audio system.
     *
     * @return The laptop associated with the audio system.
     */
    public Laptop getAudioSystemOfLaptop() {
        return audioSystemOfLaptop;
    }

    /**
     * Sets the laptop associated with the audio system.
     *
     * @param audioSystemOfLaptop The new laptop to associate with the audio system.
     */
    public void setAudioSystemOfLaptop(Laptop audioSystemOfLaptop) {
        this.audioSystemOfLaptop = audioSystemOfLaptop;
    }

    /**
     * Returns a string representation of the audio system, including its name and type.
     *
     * @return A string describing the audio system.
     */
    @Override
    public String toString() {
        return audioSystemName + " (Type: " + audioSystemType + ")";
    }
}
