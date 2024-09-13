package org.example.configurator;

/**
 * Abstract class representing a generic component of a laptop.
 * All specific components (like CPU, RAM, etc.) should extend this class.
 */
public abstract class Component {

    private Laptop laptopOfComponents;

    /**
     * Constructor to associate a component with a specific laptop.
     *
     * @param laptopOfComponents The laptop this component belongs to.
     */
    public Component(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }

    /**
     * Default constructor for creating a component without associating it with a laptop.
     */
    public Component() {}

    /**
     * Gets the laptop that this component belongs to.
     *
     * @return The laptop associated with this component.
     */
    public Laptop getLaptopOfComponents() {
        return laptopOfComponents;
    }

    /**
     * Sets the laptop that this component belongs to.
     *
     * @param laptopOfComponents The laptop to associate with this component.
     */
    public void setLaptopOfComponents(Laptop laptopOfComponents) {
        this.laptopOfComponents = laptopOfComponents;
    }

    /**
     * Abstract method for cloning the component.
     * All subclasses must implement their own version of this method.
     *
     * @return A new instance of the component.
     */
    @Override
    public abstract Component clone();
}
