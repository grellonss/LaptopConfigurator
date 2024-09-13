package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class Storage extends Component {

    private String storageName;

    private String storageCapacity;

    public Storage(Laptop laptopOfComponents, String storageName, String storageCapacity) {
        super(laptopOfComponents);
        this.storageName = storageName;
        this.storageCapacity = storageCapacity;
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public Storage clone() {
        // Clona l'oggetto RAM senza legarlo al laptop
        return new Storage(this.getLaptopOfComponents(),this.storageName,this.storageCapacity);
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    @Override
    public String toString() {
        return storageName + " (" + storageCapacity + ")";
    }
}
