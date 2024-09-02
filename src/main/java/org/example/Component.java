package org.example;

public abstract class Component {
    private Laptop laptopOfComponents;

    public Laptop getLaptopOfComponents() {
        return laptopOfComponents;
    }

    public void setLaptopOfComponents(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }
}
