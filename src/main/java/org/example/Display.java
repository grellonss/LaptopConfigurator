package org.example;

public class Display extends Component {
    private String displayResolution;
    private double price;

    public Display(String displayResolution, double price) {
        this.displayResolution = displayResolution;
        this.price = price;
    }
    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
