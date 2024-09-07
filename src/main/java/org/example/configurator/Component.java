package org.example.configurator;

public abstract class Component {
    private Laptop laptopOfComponents;
    public Component(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }
    public Component(){}
    public Laptop getLaptopOfComponents() {
        return laptopOfComponents;
    }

    public void setLaptopOfComponents(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }

    // Metodo clone astratto per forzare le sottoclassi a implementarlo
    @Override
    public abstract Component clone();  // Metodo astratto clone
}
