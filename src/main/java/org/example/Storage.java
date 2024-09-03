package org.example;

public class Storage extends Component {

    private String storageCapacity;
    private double price;

    public Storage(String storageCapacity, double price) {
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
