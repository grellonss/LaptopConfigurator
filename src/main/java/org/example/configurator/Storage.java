package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

/**
 * Represents a storage component in a laptop.
 */
public class Storage extends Component {

    private String storageName;
    private String storageCapacity;

    /**
     * Constructs a Storage object with the specified laptop, storage name, and storage capacity.
     *
     * @param laptopOfComponents the laptop associated with this storage component
     * @param storageName the name of the storage
     * @param storageCapacity the capacity of the storage
     */
    public Storage(Laptop laptopOfComponents, String storageName, String storageCapacity) {
        super(laptopOfComponents);
        this.storageName = storageName;
        this.storageCapacity = storageCapacity;
    }

    /**
     * Returns the capacity of the storage.
     *
     * @return the capacity of the storage
     */
    public String getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * Sets the capacity of the storage.
     *
     * @param storageCapacity the new capacity of the storage
     */
    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * Creates a clone of this Storage object with the same attributes, without linking it to the laptop.
     *
     * @return a new Storage object with the same attributes as this one
     */
    @Override
    public Storage clone() {
        // Clones the Storage object without linking it to the laptop
        return new Storage(this.getLaptopOfComponents(), this.storageName, this.storageCapacity);
    }

    /**
     * Returns the name of the storage.
     *
     * @return the name of the storage
     */
    public String getStorageName() {
        return storageName;
    }

    /**
     * Sets the name of the storage.
     *
     * @param storageName the new name of the storage
     */
    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    /**
     * Returns a string representation of the storage.
     *
     * @return a string representing the storage name and capacity
     */
    @Override
    public String toString() {
        return storageName + " (" + storageCapacity + ")";
    }
}
