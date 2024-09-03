package org.example;

public class Keyboard extends Peripheral {

    private String keyboardLayout;

    public Keyboard(double price, String keyboardLayout) {
        super(price);
        this.keyboardLayout = keyboardLayout;
    }
    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }
}
