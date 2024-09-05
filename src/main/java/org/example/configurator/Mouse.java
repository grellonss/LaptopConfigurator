package org.example.configurator;

public class Mouse extends Peripheral {
    private String mouseType;

    public Mouse(String connectionType, String mouseType) {
        super(connectionType);
        this.mouseType = mouseType;
    }

    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }
}
