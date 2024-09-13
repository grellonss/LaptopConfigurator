package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

/**
 * Represents an operating system component for a laptop.
 */
public class OperatingSystem extends Component {

    private String osName;
    private String operatingSystemVersion;

    /**
     * Constructs an OperatingSystem with the specified laptop, OS name, and OS version.
     *
     * @param laptopOfComponents the laptop that this operating system belongs to
     * @param osName the name of the operating system
     * @param operatingSystemVersion the version of the operating system
     */
    public OperatingSystem(Laptop laptopOfComponents, String osName, String operatingSystemVersion) {
        super(laptopOfComponents);
        this.osName = osName;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    /**
     * Returns the version of the operating system.
     *
     * @return the version of the operating system
     */
    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    /**
     * Sets the version of the operating system.
     *
     * @param operatingSystemVersion the new version of the operating system
     */
    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    /**
     * Creates a clone of this OperatingSystem object.
     *
     * @return a new OperatingSystem object with the same attributes as this one
     */
    @Override
    public OperatingSystem clone() {
        // Clone the OperatingSystem object without linking it to the laptop
        return new OperatingSystem(this.getLaptopOfComponents(), this.osName, this.operatingSystemVersion);
    }

    /**
     * Returns the name of the operating system.
     *
     * @return the name of the operating system
     */
    public String getOsName() {
        return osName;
    }

    /**
     * Sets the name of the operating system.
     *
     * @param osName the new name of the operating system
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * Returns a string representation of the operating system.
     *
     * @return a string representing the operating system name and version
     */
    @Override
    public String toString() {
        return osName + " (Version: " + operatingSystemVersion + ")";
    }
}
