/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This car is a blueprint that other cars inherit from.
 */
public class Car {
    private String name;
    private int length;
    private int height;
    private int weight;
    private String[] options;

    public Car(String name, int length, int height, int weight, String[] options) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.weight = weight;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        String carType =  getClass().toString().replace("class ","" ).replace("Car ","");
        String carDetails = carType + " " + this.name + " L*H : "+
                this.length+ " x " +this.height + " " +" Wt: " +this.weight;
        return carDetails;
    }
}
