package org.example.configurator;

import org.example.configurator.Component;
import org.example.configurator.Laptop;

public class RAM extends Component {
    private String ramName;
    private String ramSize;

    public RAM(Laptop laptop, String ramName, String ramSize) {
        super(laptop);
        this.ramName = ramName;
        this.ramSize = ramSize;
    }
    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    @Override
    public RAM clone() {
        // Clona l'oggetto RAM senza legarlo al laptop
        return new RAM(this.getLaptopOfComponents(),this.ramName,this.ramSize);
    }
    @Override
    public String toString() {
        return ramName + " (" + ramSize + ")";
    }
}
