package org.example.configurator;

import org.example.configurator.Laptop;

public class Warranty {

    private Laptop laptopOfWarranty;
    private String warrantyName;

    private int warrantyPeriod; // Durata della garanzia in anni

    public Warranty(Laptop laptopOfWarranty, String warrantyName, int warrantyPeriod) {
        this.laptopOfWarranty = laptopOfWarranty;
        this.warrantyName = warrantyName;
        this.warrantyPeriod = warrantyPeriod;
    }
    public Warranty clone(Laptop laptop) {
        return new Warranty(laptopOfWarranty, this.warrantyName, this.warrantyPeriod);
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

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }
}

