package org.example.configurator;

/**
 * Represents the display component of a laptop, including the display name and resolution.
 */
public class Display extends Component {
    private String displayName;
    private String displayResolution;

    /**
     * Constructor to create a display component associated with a specific laptop.
     *
     * @param laptopOfComponents The laptop to which the display belongs.
     * @param displayName        The name of the display.
     * @param displayResolution  The resolution of the display.
     */
    public Display(Laptop laptopOfComponents, String displayName, String displayResolution) {
        super(laptopOfComponents);
        this.displayName = displayName;
        this.displayResolution = displayResolution;
    }

    /**
     * Gets the display resolution.
     *
     * @return The resolution of the display.
     */
    public String getDisplayResolution() {
        return displayResolution;
    }

    /**
     * Sets the display resolution.
     *
     * @param displayResolution The resolution of the display.
     */
    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    /**
     * Creates a clone of the current Display object, preserving the laptop association.
     *
     * @return A cloned Display object.
     */
    @Override
    public Display clone() {
        return new Display(this.getLaptopOfComponents(), this.displayName, this.displayResolution);
    }

    /**
     * Gets the display name.
     *
     * @return The name of the display.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName The name of the display.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns a string representation of the display, including its name and resolution.
     *
     * @return A string representation of the display.
     */
    @Override
    public String toString() {
        return displayName + " (" + displayResolution + ")";
    }
}
