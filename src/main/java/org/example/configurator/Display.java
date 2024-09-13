package org.example.configurator;

public class Display extends Component {
    private String displayName;
    private String displayResolution;

    public Display(Laptop laptopOfComponents, String displayName, String displayResolution) {
        super(laptopOfComponents);
        this.displayName = displayName;
        this.displayResolution = displayResolution;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    @Override
    public Display clone() {
        // Clona l'oggetto RAM senza legarlo al laptop
        return new Display(this.getLaptopOfComponents(),this.displayName,this.displayResolution);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName + " (" + displayResolution + ")";
    }
}
