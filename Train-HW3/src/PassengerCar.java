/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This car is a concrete class that gets created based on the type.
 */
public class PassengerCar extends Car {
    /**
     * Creates a PassengerCar from the car blueprint.
     *
     * @param name name of the car.
     * @param length length of car.
     * @param height height of car.
     * @param weight weight of car.
     * @param options options in the car
     */
    public PassengerCar(String name, float length, float height, float weight, String[] options) {
        super(name, length, height, weight, options);
    }
}
