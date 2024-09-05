package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class RAM extends Component {
    private String ramSize;
    private double price;

    public RAM(Laptop laptop, String ramSize, double price) {
        super(laptop);
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
