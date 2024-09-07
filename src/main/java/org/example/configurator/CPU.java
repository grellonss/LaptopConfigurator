package org.example.configurator;

public class CPU extends Component {

    private String CPUName;
    private String cpuSpeed;

    public CPU(Laptop laptop, String CPUName, String cpuSpeed) {
        super(laptop);
        this.CPUName = CPUName;
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Override
    public CPU clone() {
        // Crea una nuova istanza di RAM clonando le proprietà e associando il nuovo laptop
        return new CPU(getLaptopOfComponents(), this.CPUName,this.cpuSpeed);
    }

    public String getCPUName() {
        return CPUName;
    }

    public void setCPUName(String CPUName) {
        this.CPUName = CPUName;
    }
}

