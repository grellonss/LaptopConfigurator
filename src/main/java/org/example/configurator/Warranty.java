package org.example.configurator;

import org.example.configurator.Laptop;

public class Warranty {

    private Laptop laptopOfWarranty;

    private int warrantyPeriod; // Durata della garanzia in anni

    public Warranty(Laptop laptopOfWarranty, int warrantyPeriod) {
        this.laptopOfWarranty = laptopOfWarranty;
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Laptop getLaptopOfWarranty() {
        return laptopOfWarranty;
    }

    public void setLaptopOfWarranty(Laptop laptopOfWarranty) {
        this.laptopOfWarranty = laptopOfWarranty;
    }

}

