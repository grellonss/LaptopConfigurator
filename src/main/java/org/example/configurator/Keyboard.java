package org.example.configurator;

public class Keyboard extends Peripheral {

    private String keyboardName;
    private String keyboardLayout;

    public Keyboard(Laptop peripheralOfLaptop,String connectionType, String keyboardName, String keyboardLayout) {
        super(peripheralOfLaptop,connectionType);
        this.keyboardName = keyboardName;
        this.keyboardLayout = keyboardLayout;
    }
    @Override
    public Keyboard clone(Laptop laptop) {
        return new Keyboard(getPeripheralOfLaptop(), getConnectionType(),this.keyboardName, this.keyboardLayout);
    }
    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }

    public String getKeyboardName() {
        return keyboardName;
    }

    public void setKeyboardName(String keyboardName) {
        this.keyboardName = keyboardName;
    }
}
