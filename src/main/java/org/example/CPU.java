package org.example;

public class CPU extends Component {

    private String cpuSpeed;
    private double price;

    public CPU(String cpuSpeed, double price) {
        this.cpuSpeed = cpuSpeed;
        this.price = price;
    }

    public String getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

