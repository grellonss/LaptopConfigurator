package org.example.configurator;

public class CPU extends Component {

    private String cpuSpeed;

    public CPU(Laptop laptop, String cpuSpeed) {
        super(laptop);
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

}

