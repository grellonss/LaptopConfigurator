package org.example.configurator;

public class GraphicsCard extends Component {
    private String graphicCardName;
    private String graphicsMemory;

    public GraphicsCard(Laptop laptopOfComponents,String graphicCardName, String graphicsMemory) {
        super(laptopOfComponents);
        this.graphicCardName = graphicCardName;
        this.graphicsMemory = graphicsMemory;
    }

    public String getGraphicsMemory() {
        return graphicsMemory;
    }

    public void setGraphicsMemory(String graphicsMemory) {
        this.graphicsMemory = graphicsMemory;
    }

    @Override
    public GraphicsCard clone() {
        // Clona l'oggetto RAM senza legarlo al laptop
        return new GraphicsCard(this.getLaptopOfComponents(),this.graphicCardName, this.graphicsMemory);
    }

    public String getGraphicCardName() {
        return graphicCardName;
    }

    public void setGraphicCardName(String graphicCardName) {
        this.graphicCardName = graphicCardName;
    }

    @Override
    public String toString() {
        return graphicCardName + " (" + graphicsMemory + ")";
    }
}
