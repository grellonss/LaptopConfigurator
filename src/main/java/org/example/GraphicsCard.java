package org.example;

public class GraphicsCard extends Component{
    private String graphicsMemory;
    private double price;

    public GraphicsCard(String graphicsMemory, double price) {
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
