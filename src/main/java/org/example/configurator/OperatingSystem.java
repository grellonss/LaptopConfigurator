package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class OperatingSystem extends Component {
    private String operatingSystemVersion;

    public OperatingSystem(Laptop laptopOfComponents, String operatingSystemVersion) {
        super(laptopOfComponents);
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

}
