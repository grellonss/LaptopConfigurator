package org.example;

public class RAM extends Component {
    private String ramSize;
    private double price;

    public RAM(String ramSize, double price) {
        this.ramSize = ramSize;
        this.price = price;
    }
    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
