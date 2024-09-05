package org.example.configurator;

public class Display extends Component {
    private String displayResolution;

    public Display(Laptop laptopOfComponents, String displayResolution) {
        super(laptopOfComponents);
        this.displayResolution = displayResolution;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

}
