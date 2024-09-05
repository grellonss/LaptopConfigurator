package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class Storage extends Component {

    private String storageCapacity;

    public Storage(Laptop laptopOfComponents, String storageCapacity) {
        super(laptopOfComponents);
        this.storageCapacity = storageCapacity;
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

}
