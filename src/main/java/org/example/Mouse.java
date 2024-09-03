package org.example;

public class Mouse extends Peripheral {
    private String mouseType;

    public Mouse(double price, String mouseType) {
        super(price);
        this.mouseType = mouseType;
    }
    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }
}
