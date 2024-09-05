package org.example.configurator;

public class Mouse extends Peripheral {
    private String mouseType;

    public Mouse(String connectionType, double price, String mouseType) {
        super(connectionType, price);
        this.mouseType = mouseType;
    }

    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }
}
