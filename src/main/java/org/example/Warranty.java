package org.example;

public class Warranty {

    private Laptop laptopOfWarranty;

    private double price;

    private int warrantyPeriod; // Durata della garanzia in anni

    public Warranty(Laptop laptopOfWarranty, double price, int warrantyPeriod) {
        this.laptopOfWarranty = laptopOfWarranty;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

