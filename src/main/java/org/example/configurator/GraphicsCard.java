package org.example.configurator;

public class GraphicsCard extends Component {
    private String graphicsMemory;
    private double price;

    public GraphicsCard(Laptop laptopOfComponents, String graphicsMemory, double price) {
        super(laptopOfComponents);
        this.graphicsMemory = graphicsMemory;
        this.price = price;
    }

    public String getGraphicsMemory() {
        return graphicsMemory;
    }

    public void setGraphicsMemory(String graphicsMemory) {
        this.graphicsMemory = graphicsMemory;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
