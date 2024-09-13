package org.example.configurator;

/**
 * Represents a Mouse as a type of Peripheral for a laptop.
 */
public class Mouse extends Peripheral {
    private String mouseName;
    private String mouseType;

    /**
     * Constructor to initialize the Mouse with its associated laptop, connection type, name, and type.
     *
     * @param peripheralOfLaptop The laptop to which the mouse is connected.
     * @param connectionType     The connection type of the mouse (e.g., USB, Bluetooth).
     * @param mouseName          The name of the mouse.
     * @param mouseType          The type of the mouse (e.g., optical, laser).
     */
    public Mouse(Laptop peripheralOfLaptop, String connectionType, String mouseName, String mouseType) {
        super(peripheralOfLaptop, connectionType);
        this.mouseName = mouseName;
        this.mouseType = mouseType;
    }

    /**
     * Clones the Mouse object with a reference to a new laptop.
     *
     * @param laptop The laptop to which the cloned mouse will be associated.
     * @return A new Mouse object cloned from the current one.
     */
    @Override
    public Mouse clone(Laptop laptop) {
        return new Mouse(getPeripheralOfLaptop(), getConnectionType(), this.mouseName, this.mouseType);
    }

    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    /**
     * Returns a string representation of the Mouse, including its name and type.
     *
     * @return A string describing the Mouse.
     */
    @Override
    public String toString() {
        return mouseName + " (Type: " + mouseType + ")";
    }
}
