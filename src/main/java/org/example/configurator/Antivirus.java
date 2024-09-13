package org.example.configurator;

/**
 * Represents an antivirus component for a laptop, inheriting from the {@link Security} class.
 */
public class Antivirus extends Security {

    private String antivirusName;
    private String antivirusVersion;

    /**
     * Constructor to create an Antivirus object with a specified laptop, name, and version.
     *
     * @param laptopOfSecurity  The laptop that the antivirus is associated with.
     * @param antivirusName     The name of the antivirus.
     * @param antivirusVersion  The version of the antivirus.
     */
    public Antivirus(Laptop laptopOfSecurity, String antivirusName, String antivirusVersion) {
        super(laptopOfSecurity);
        this.antivirusName = antivirusName;
        this.antivirusVersion = antivirusVersion;
    }

    /**
     * Gets the version of the antivirus.
     *
     * @return The version of the antivirus.
     */
    public String getAntivirusVersion() {
        return antivirusVersion;
    }

    /**
     * Sets the version of the antivirus.
     *
     * @param antivirusVersion The new version of the antivirus.
     */
    public void setAntivirusVersion(String antivirusVersion) {
        this.antivirusVersion = antivirusVersion;
    }

    /**
     * Gets the name of the antivirus.
     *
     * @return The name of the antivirus.
     */
    public String getAntivirusName() {
        return antivirusName;
    }

    /**
     * Sets the name of the antivirus.
     *
     * @param antivirusName The new name of the antivirus.
     */
    public void setAntivirusName(String antivirusName) {
        this.antivirusName = antivirusName;
    }

    /**
     * Clones the antivirus object for a specified laptop.
     *
     * @param laptop The laptop to associate with the cloned antivirus.
     * @return A new {@link Antivirus} object with the same name and version.
     */
    @Override
    public Antivirus clone(Laptop laptop) {
        return new Antivirus(getLaptopOfSecurity(), this.antivirusName, this.antivirusVersion);
    }

    /**
     * Returns a string representation of the antivirus, including its name and version.
     *
     * @return A string describing the antivirus.
     */
    @Override
    public String toString() {
        return antivirusName + " (Version: " + antivirusVersion + ")";
    }
}
