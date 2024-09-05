package org.example.configurator;

public class GraphicsCard extends Component {
    private String graphicsMemory;

    public GraphicsCard(Laptop laptopOfComponents, String graphicsMemory) {
        super(laptopOfComponents);
        this.graphicsMemory = graphicsMemory;
    }

    public String getGraphicsMemory() {
        return graphicsMemory;
    }

    public void setGraphicsMemory(String graphicsMemory) {
        this.graphicsMemory = graphicsMemory;
    }

}
