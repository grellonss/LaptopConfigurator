package org.example.configurator;

/**
 * Represents a graphics card component in a laptop, including the graphics card's name and memory size.
 */
public class GraphicsCard extends Component {
    private String graphicCardName;
    private String graphicsMemory;

    /**
     * Constructor to create a graphics card associated with a specific laptop.
     *
     * @param laptopOfComponents The laptop to which the graphics card is associated.
     * @param graphicCardName    The name of the graphics card.
     * @param graphicsMemory     The size of the graphics memory.
     */
    public GraphicsCard(Laptop laptopOfComponents, String graphicCardName, String graphicsMemory) {
        super(laptopOfComponents);
        this.graphicCardName = graphicCardName;
        this.graphicsMemory = graphicsMemory;
    }

    /**
     * Gets the size of the graphics memory.
     *
     * @return The size of the graphics memory.
     */
    public String getGraphicsMemory() {
        return graphicsMemory;
    }

    /**
     * Sets the size of the graphics memory.
     *
     * @param graphicsMemory The size of the graphics memory.
     */
    public void setGraphicsMemory(String graphicsMemory) {
        this.graphicsMemory = graphicsMemory;
    }

    /**
     * Clones the GraphicsCard object, preserving the associated laptop.
     *
     * @return A cloned GraphicsCard object.
     */
    @Override
    public GraphicsCard clone() {
        // Clones the GraphicsCard object without attaching it to a laptop.
        return new GraphicsCard(this.getLaptopOfComponents(), this.graphicCardName, this.graphicsMemory);
    }

    /**
     * Gets the name of the graphics card.
     *
     * @return The name of the graphics card.
     */
    public String getGraphicCardName() {
        return graphicCardName;
    }

    /**
     * Sets the name of the graphics card.
     *
     * @param graphicCardName The name of the graphics card.
     */
    public void setGraphicCardName(String graphicCardName) {
        this.graphicCardName = graphicCardName;
    }

    /**
     * Returns a string representation of the graphics card, including its name and memory size.
     *
     * @return A string representation of the graphics card.
     */
    @Override
    public String toString() {
        return graphicCardName + " (" + graphicsMemory + ")";
    }
}
