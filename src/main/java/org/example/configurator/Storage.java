package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class Storage extends Component {

    private String storageCapacity;
    private double price;

    public Storage(Laptop laptopOfComponents, String storageCapacity, double price) {
        super(laptopOfComponents);
        this.storageCapacity = storageCapacity;
        this.price = price;
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
