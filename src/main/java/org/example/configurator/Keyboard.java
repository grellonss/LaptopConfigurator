package org.example.configurator;

/**
 * Represents a keyboard component in a laptop, including the keyboard's name and layout.
 */
public class Keyboard extends Peripheral {

    private String keyboardName;
    private String keyboardLayout;

    /**
     * Constructor to create a keyboard associated with a specific laptop.
     *
     * @param peripheralOfLaptop The laptop to which the keyboard is associated.
     * @param connectionType     The type of connection for the keyboard (e.g., wired, wireless).
     * @param keyboardName       The name of the keyboard.
     * @param keyboardLayout     The layout of the keyboard (e.g., QWERTY, AZERTY).
     */
    public Keyboard(Laptop peripheralOfLaptop, String connectionType, String keyboardName, String keyboardLayout) {
        super(peripheralOfLaptop, connectionType);
        this.keyboardName = keyboardName;
        this.keyboardLayout = keyboardLayout;
    }

    /**
     * Clones the Keyboard object, preserving the associated laptop.
     *
     * @param laptop The laptop to which the cloned keyboard will be associated.
     * @return A cloned Keyboard object.
     */
    @Override
    public Keyboard clone(Laptop laptop) {
        return new Keyboard(getPeripheralOfLaptop(), getConnectionType(), this.keyboardName, this.keyboardLayout);
    }

    /**
     * Gets the layout of the keyboard.
     *
     * @return The layout of the keyboard.
     */
    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    /**
     * Sets the layout of the keyboard.
     *
     * @param keyboardLayout The layout of the keyboard.
     */
    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }

    /**
     * Gets the name of the keyboard.
     *
     * @return The name of the keyboard.
     */
    public String getKeyboardName() {
        return keyboardName;
    }

    /**
     * Sets the name of the keyboard.
     *
     * @param keyboardName The name of the keyboard.
     */
    public void setKeyboardName(String keyboardName) {
        this.keyboardName = keyboardName;
    }

    /**
     * Returns a string representation of the keyboard, including its name and layout.
     *
     * @return A string representation of the keyboard.
     */
    @Override
    public String toString() {
        return keyboardName + " (Layout: " + keyboardLayout + ")";
    }
}
