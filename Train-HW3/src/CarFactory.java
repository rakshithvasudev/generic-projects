/**
 * Created by Rakshith on oct 10 2017, for CSC527 - HW3.
 * This class is a factory pattern that creates a new Car
 * given a type and other parameters for the cars.
 */
public class CarFactory {

    public static Car GenerateCar(String type,String name, int length, int height, int weight, String[] options){
        Car newCar = null;

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
