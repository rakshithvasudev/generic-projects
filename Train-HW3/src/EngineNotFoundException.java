/**
 * Created by Rakshith on oct 10 2017, for CSC527 - HW3.
 * This class is a custom exception that gets thrown when there's
 * no engineCar in a given train class.
 */
public class EngineNotFoundException extends Exception {

    /**
     * @param message that needs to be thrown upon calling.
     */
    public  EngineNotFoundException(String message){
        super(message);
    }

}
