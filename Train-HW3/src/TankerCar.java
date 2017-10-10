/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This car is a concrete class that gets created based on the type.
 */
public class TankerCar extends Car {
    /**
     * Creates a TankerCar from the car blueprint.
     *
     * @param name name of the car.
     * @param length length of car.
     * @param height height of car.
     * @param weight weight of car.
     * @param options options in the car
     */
    public TankerCar(String name, int length, int height, int weight, String[] options) {
        super(name, length, height, weight, options);
    }
}
