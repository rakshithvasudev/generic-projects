import java.util.ArrayList;
import java.util.List;

public class Main {
  // this list contains all the Car objects generated.
  // This Car uses abstraction to add any type of
  // car inside the array list. Ex: EngineCar, TankerCar, etc
  // can be elements inside this carsTrain list.
  private static List<Car> carsTrain = new ArrayList<>();

    /**
     * Main function where assembly of cars happen.
     * @param args
     * @throws EngineNotFoundException if there are no Engine Cars from the given file.
     */
    public static void main(String[] args)  {

       // Name of the file from which the cars must be generated.
        String fileName = "train1.csv";

        // When a file doesn't contain an EngineCar, generateCars()
        // method throws EngineNotFound Exception.
        try {
            generateCarsFromFile(fileName);
        } catch (EngineNotFoundException e) {
            e.printStackTrace();
        }

        // Just to check if cars are added properly printAddedCars() is used.
        // printAddedCars();

        // create a Train from all cars and print the entire
        // train object.
        createTrainFromCars();
    }

    /**
     * Passes on the assembly of cars to create a Train class
     * and prints the the entire Train.
     */
    private static void createTrainFromCars() {
        // create a new Train.
        Train train = new Train(carsTrain);

        // print the train object.
        System.out.println(train);
    }

    /**
     * Prints all the added cars from the list
     */
    private static void printAddedCars() {
        for (Car e: carsTrain){
            System.out.println(e);
        }
    }

    /**
     *
     * Generates an entire train from the given file.
     */
    public static void generateCarsFromFile(String fileName) throws EngineNotFoundException {

        // skip the header and get other line entries.
        List<String[]> linesFromFileWithoutHeader = CSVReader.readFileWithoutHeader(fileName);

        // this keeps a track of number of times the lines were read.
        // This is used specifically to throw Engine not found exception,
        // when an engine car was not found even after the last line.
        int counter = 0;

        // this flag is used to throw Engine not Found Exceptions.
        boolean isEngineFound = false;

        // the following are features for the car.
        String type;
        String name;
        String option1 = "NONE";
        String option2 = "NONE";
        String option3 = "NONE";
        String[] options;
        float length;
        float height;
        float weight;

        // iterate through all the lines from the file
        for (String[] e:linesFromFileWithoutHeader){

                // [TYPE, NAME, LENGTH, HEIGHT, WEIGHT, OPTION1, OPTION2, OPTION3] -
                // array indices align respectively. ex: [0]-TYPE, [1]-NAME,
                // [2] - LENGTH , etc. other elements likewise.
                type = e[0];

                // update engine availability
                if(type.equalsIgnoreCase("Engine"))
                   isEngineFound =true;

                name = e[1];
                length = Float.valueOf(e[2]);
                height = Float.valueOf(e[3]);
                weight = Float.valueOf(e[4]);

            // there are chances that options1, 2 and 3 could be blank.
            // this could essentially throw IndexOutOfBounds Exception.
            try{
                // anticipating exceptions
                 option1 = e[5];
                 option2 = e[6];
                 option3 = e[7];
            }catch (Exception ex){// do nothing and keep building the Car.}

            // check if this is the last line and engine is still not found
            if((counter == linesFromFileWithoutHeader.size()-1) &&(!isEngineFound)){
                throw new  EngineNotFoundException("Sorry! No engine found! Can't run this train.");
            }

            // update options based on new values
            options = new String[]{option1, option2, option3};

            // add a new car to the list of cars for the train
            // invoke the GenerateCar method from Car Factory to return an
            // appropriate car based on the type passed.
            carsTrain.add(CarFactory.GenerateCar(type,name,length,height,weight,options));

            //increment the counter
            counter++;

            }

        }

    }

}
