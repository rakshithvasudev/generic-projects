/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This car is a concrete class that gets created based on the type.
 */
public class CargoCar extends Car {

    /**
     * Creates a CargoCar from the car blueprint.
     *
     * @param name name of the car.
     * @param length length of car.
     * @param height height of car.
     * @param weight weight of car.
     * @param options options in the car
     */

    public CargoCar(String name, float length, float height, float weight, String[] options) {
        super(name, length, height, weight, options);
    }

    /**
     * This method ensures that all the inherited classes stick to the required representation
     * as indicated by the requirement specs.
     *
     * The only reason why tostring is overriden in this class alone is because
     * this class name by default has "Car" keyword in it.
     *
     * example: CarType Name L*H : l x h  Wt: wt
     * @return expected text representation of the car as indicated in the example.
     */
    @Override
    public String toString() {
        String carType = "CargoCar";
        return carType + " " + getName() + " L*H : "+
                getLength()+ " x " + getHeight() + " " +" Wt: " + getWeight();
    }
}
