package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class OperatingSystem extends Component {

    private String OSName;
    private String operatingSystemVersion;

    public OperatingSystem(Laptop laptopOfComponents, String OSName, String operatingSystemVersion) {
        super(laptopOfComponents);
        this.OSName = OSName;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }
    @Override
    public OperatingSystem clone() {
        // Clona l'oggetto RAM senza legarlo al laptop
        return new OperatingSystem(this.getLaptopOfComponents(),this.OSName, this.operatingSystemVersion);
    }

    public String getOSName() {
        return OSName;
    }

    public void setOSName(String OSName) {
        this.OSName = OSName;
    }
}
