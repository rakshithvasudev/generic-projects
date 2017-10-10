/**
 * Created by Rakshith on oct 10 2017, for CSC527 - HW3.
 * This class is a factory pattern that creates a new Car
 * given a type and other parameters for the cars.
 */
public class CarFactory {

    /**
     * This method matches the name of the type of the car and generates a new car
     * based on the type matched.
     * @param type type of the car class to resolve to and construct.
     * @param name name of the car.
     * @param length length of the car.
     * @param height height of the car.
     * @param weight weight of the car.
     * @param options options of the car.
     * @return generic car if no types were matched.
     */
    public static Car GenerateCar(String type,String name, int length, int height, int weight, String[] options){

        // newCar is a dummy variable that never should get returned.
        Car newCar = new Car(name, length,  height,  weight, options);

        if(type.equalsIgnoreCase("Cargo")) {
            return new CargoCar(name, length, height, weight, options);
        }else if(type.equalsIgnoreCase("Engine")){
            return new EngineCar(name, length,  height,  weight, options);
        }
        else if (type.equalsIgnoreCase("Passenger")){
            return new PassengerCar(name, length,  height,  weight, options);
        }
        else if (type.equalsIgnoreCase("Tanker")){
            return new TankerCar(name, length,  height,  weight, options);
        }
        else if (type.equalsIgnoreCase("Refrigerated")) {
            return new RefrigeratedCar(name, length, height, weight, options);
        }
        return newCar;

    }
}
