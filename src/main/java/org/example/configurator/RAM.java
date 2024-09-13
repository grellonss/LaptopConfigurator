package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

/**
 * Represents a RAM component in a laptop.
 */
public class RAM extends Component {
    private String ramName;
    private String ramSize;

    /**
     * Constructs a RAM object with the specified laptop, RAM name, and RAM size.
     *
     * @param laptop the laptop associated with this RAM
     * @param ramName the name of the RAM
     * @param ramSize the size of the RAM
     */
    public RAM(Laptop laptop, String ramName, String ramSize) {
        super(laptop);
        this.ramName = ramName;
        this.ramSize = ramSize;
    }

    /**
     * Returns the size of the RAM.
     *
     * @return the size of the RAM
     */
    public String getRamSize() {
        return ramSize;
    }

    /**
     * Sets the size of the RAM.
     *
     * @param ramSize the new size of the RAM
     */
    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    /**
     * Returns the name of the RAM.
     *
     * @return the name of the RAM
     */
    public String getRamName() {
        return ramName;
    }

    /**
     * Sets the name of the RAM.
     *
     * @param ramName the new name of the RAM
     */
    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    /**
     * Creates a clone of this RAM object with the same attributes, without linking it to the laptop.
     *
     * @return a new RAM object with the same attributes as this one
     */
    @Override
    public RAM clone() {
        // Clones the RAM object without linking it to the laptop
        return new RAM(this.getLaptopOfComponents(), this.ramName, this.ramSize);
    }

    /**
     * Returns a string representation of the RAM.
     *
     * @return a string representing the RAM name and size
     */
    @Override
    public String toString() {
        return ramName + " (" + ramSize + ")";
    }
}
