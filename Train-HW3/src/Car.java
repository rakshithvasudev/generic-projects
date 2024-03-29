/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This car is a blueprint that other cars inherit from.
 */
public class Car {
    protected String name;
    protected float length;
    protected float height;
    protected float weight;
    protected String[] options;

    /**
     * Creates a car with specified parameters.
     * @param name name of the car.
     * @param length length of the car.
     * @param height height of the car.
     * @param weight weight of the car.
     * @param options options of the car.
     */
    public Car(String name, float length, float height, float weight, String[] options) {
        setName(name);
        setLength(length);
        setHeight(height);
        setWeight(weight);
        setOptions(options);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    /**
     * This method ensures that all the inherited classes stick to the required representation
     * as indicated by the requirement specs.
     * example: CarType Name L*H : l x h  Wt: wt
     * @return expected text representation of the car as indicated in the example.
     */
    @Override
    public String toString() {

        String carType =  getClass().toString().replace("class ","" ).
                replace("Car","");

        return carType + " " + getName() + " L*H : "+ getLength()+
                " x " +getHeight() + " " +" Wt: " +getWeight();
    }


}
