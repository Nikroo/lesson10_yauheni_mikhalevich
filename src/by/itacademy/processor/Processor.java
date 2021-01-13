package by.itacademy.processor;

import java.util.Objects;

public class Processor{

    private String name;
    private int frequency;

    public Processor(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return frequency == processor.frequency &&
                Objects.equals(name, processor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, frequency);
    }

    public int compareTo(Processor o) {
        if(frequency > o.frequency){
            return  1;
        }
        if(frequency <o.frequency){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
