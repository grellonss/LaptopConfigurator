package org.example.configurator;

/**
 * Represents a colour option for a laptop.
 */
public class Colour {

    private Laptop colourOfLaptop;
    private String colourName;

    /**
     * Constructor to create a Colour object with a specified laptop and colour name.
     *
     * @param colourOfLaptop The laptop that the colour is associated with.
     * @param colourName     The name of the colour.
     */
    public Colour(Laptop colourOfLaptop, String colourName) {
        this.colourOfLaptop = colourOfLaptop;
        this.colourName = colourName;
    }

    /**
     * Clones the current Colour object and associates it with the specified laptop.
     *
     * @param laptop The laptop to associate with the cloned colour.
     * @return A new {@link Colour} object with the same colour name.
     */
    public Colour clone(Laptop laptop) {
        return new Colour(colourOfLaptop, this.colourName);
    }

    /**
     * Gets the name of the colour.
     *
     * @return The name of the colour.
     */
    public String getColourName() {
        return colourName;
    }

    /**
     * Sets the name of the colour.
     *
     * @param colourName The new name of the colour.
     */
    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    /**
     * Gets the laptop associated with the colour.
     *
     * @return The laptop associated with the colour.
     */
    public Laptop getColourOfLaptop() {
        return colourOfLaptop;
    }

    /**
     * Sets the laptop associated with the colour.
     *
     * @param colourOfLaptop The new laptop to associate with the colour.
     */
    public void setColourOfLaptop(Laptop colourOfLaptop) {
        this.colourOfLaptop = colourOfLaptop;
    }

    /**
     * Returns a string representation of the colour.
     *
     * @return A string describing the colour name.
     */
    @Override
    public String toString() {
        return colourName;
    }
}
