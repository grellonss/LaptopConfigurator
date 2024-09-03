package org.example;

public abstract class Component {
    private Laptop laptopOfComponents;
    public abstract double getPrice();


    public Laptop getLaptopOfComponents() {
        return laptopOfComponents;
    }

    public void setLaptopOfComponents(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }

}