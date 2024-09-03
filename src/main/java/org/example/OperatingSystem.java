package org.example;

public class OperatingSystem extends Component {
    private String operatingSystemVersion;
    private double price;

    public OperatingSystem(String operatingSystemVersion, double price) {
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
