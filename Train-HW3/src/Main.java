import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            generateTrainFromFile("train1.csv");
        } catch (EngineNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * [TYPE, NAME, LENGTH, HEIGHT, WEIGHT, OPTION1, OPTION2, OPTION3]
     * Generates an entire train from the given file.
     */
    public static void generateTrainFromFile(String fileName) throws EngineNotFoundException {
        List<Car> carsTrain = new ArrayList<>();

        // skip the header and get other line entries.
        List<String[]> linesFromFileWithoutHeader = CSVReader.readFileWithoutHeader(fileName);

        // this keeps a track of number of times the lines were read.
        // This is used specifically to throw Engine not found exception,
        // when an engine car was not found even after the last line.
        int counter = 0;

        // this flag is used to throw exceptions
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

        int currentMax = 0;

        // iterate through all the lines from the file
        for (String[] e:linesFromFileWithoutHeader){
            currentMax = e.length;

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
//                if(currentMax>4 && currentMax<6)
                    option1 = e[5];

//                if(currentMax>5 && currentMax<7)
                    option2 = e[6];

//                if(currentMax>6 && currentMax<8)
                    option3 = e[7];

            }catch (Exception ex){}

            // check if this is the last line and engine is still not found
            if((counter == linesFromFileWithoutHeader.size()-1) &&(!isEngineFound)){
                throw new  EngineNotFoundException("Sorry! No engine found! Can't run this train.");
            }

            options = new String[]{option1, option2, option3};
            carsTrain.add(CarFactory.GenerateCar(type,name,length,height,weight,options));
            counter++;
        }

    }




}
