package org.example.configurator;

public class Mouse extends Peripheral {
    private String mouseName;
    private String mouseType;

    public Mouse(Laptop peripheralOfLaptop, String connectionType, String mouseName,String mouseType) {
        super(peripheralOfLaptop,connectionType);
        this.mouseName = mouseName;
        this.mouseType = mouseType;
    }
    @Override
    public Mouse clone(Laptop laptop) {
        return new Mouse(getPeripheralOfLaptop(), getConnectionType(),this.mouseName, this.mouseType);
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

    @Override
    public String toString() {
        return mouseName + " (Tipo: " + mouseType + ")";
    }
}
