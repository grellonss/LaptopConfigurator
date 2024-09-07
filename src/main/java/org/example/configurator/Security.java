package org.example.configurator;

import org.example.configurator.Laptop;

public class Security {
    private Laptop laptopOfSecurity;

    public Security(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }
    public Security clone(Laptop laptop) {
        return new Security(laptopOfSecurity);
    }
    public Laptop getLaptopOfSecurity() {
        return laptopOfSecurity;
    }

    public void setLaptopOfSecurity(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }

}
