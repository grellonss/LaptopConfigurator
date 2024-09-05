package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class OperatingSystem extends Component {
    private String operatingSystemVersion;
    private double price;

    public OperatingSystem(Laptop laptopOfComponents, String operatingSystemVersion, double price) {
        super(laptopOfComponents);
        this.operatingSystemVersion = operatingSystemVersion;
        this.price = price;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
