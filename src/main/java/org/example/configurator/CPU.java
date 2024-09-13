package org.example.configurator;

/**
 * Represents the CPU (Central Processing Unit) component of a laptop.
 * It includes the name and speed of the CPU.
 */
public class CPU extends Component {

    private String CPUName;
    private String cpuSpeed;

    /**
     * Constructor to create a CPU object associated with a specific laptop.
     *
     * @param laptop   The laptop to which the CPU belongs.
     * @param CPUName  The name of the CPU.
     * @param cpuSpeed The speed of the CPU.
     */
    public CPU(Laptop laptop, String CPUName, String cpuSpeed) {
        super(laptop);
        this.CPUName = CPUName;
        this.cpuSpeed = cpuSpeed;
    }

    /**
     * Gets the speed of the CPU.
     *
     * @return The speed of the CPU.
     */
    public String getCpuSpeed() {
        return cpuSpeed;
    }

    /**
     * Sets the speed of the CPU.
     *
     * @param cpuSpeed The speed of the CPU.
     */
    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    /**
     * Creates a copy of the current CPU object associated with the same laptop.
     *
     * @return A cloned CPU object.
     */
    @Override
    public CPU clone() {
        return new CPU(getLaptopOfComponents(), this.CPUName, this.cpuSpeed);
    }

    /**
     * Gets the name of the CPU.
     *
     * @return The name of the CPU.
     */
    public String getCPUName() {
        return CPUName;
    }

    /**
     * Sets the name of the CPU.
     *
     * @param CPUName The name of the CPU.
     */
    public void setCPUName(String CPUName) {
        this.CPUName = CPUName;
    }

    /**
     * Returns a string representation of the CPU, including its name and speed.
     *
     * @return A string representation of the CPU.
     */
    @Override
    public String toString() {
        return CPUName + " (" + cpuSpeed + ")";
    }
}
