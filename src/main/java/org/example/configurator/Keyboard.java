package org.example.configurator;

public class Keyboard extends Peripheral {

    private String keyboardLayout;

    public Keyboard(String connectionType, String keyboardLayout) {
        super(connectionType);
        this.keyboardLayout = keyboardLayout;
    }

    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }
}
