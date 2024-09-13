package org.example.configurator;

public class Colour {

    private Laptop colourOfLaptop;
    private String colourName;

    public Colour(Laptop colourOfLaptop,String colourName) {
        this.colourOfLaptop = colourOfLaptop;
        this.colourName = colourName;
    }
    public Colour clone(Laptop laptop) {
        return new Colour(colourOfLaptop, this.colourName);
    }
    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public Laptop getColourOfLaptop() {
        return colourOfLaptop;
    }

    public void setColourOfLaptop(Laptop colourOfLaptop) {
        this.colourOfLaptop = colourOfLaptop;
    }

    @Override
    public String toString() {
        return colourName;
    }
}

