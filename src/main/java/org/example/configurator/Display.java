package org.example.configurator;

public class Display extends Component {
    private String displayResolution;
    private double price;

    public Display(Laptop laptopOfComponents, String displayResolution, double price) {
        super(laptopOfComponents);
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
