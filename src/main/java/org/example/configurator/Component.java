package org.example.configurator;

public abstract class Component {
    private Laptop laptopOfComponents;
    public abstract double getPrice();

    public Component(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }
    public Laptop getLaptopOfComponents() {
        return laptopOfComponents;
    }

    public void setLaptopOfComponents(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }

}
