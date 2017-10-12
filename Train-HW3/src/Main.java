import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        generateTrainFromFile("train4.csv");

    }

    /**
     * [TYPE, NAME, LENGTH, HEIGHT, WEIGHT, OPTION1, OPTION2, OPTION3]
     * Generates an entire train from the given file.
     */
    public static void generateTrainFromFile(String fileName){
        // skip the header and get other line entries.
        List<String[]> linesFromFileWithoutHeader = CSVReader.readFileWithoutHeader(fileName);

        // this keeps a track of number of times the lines were read.
        // This is used specifically to throw Engine not found exception,
        // when an engine car was not found even after the last line.
        int counter = 0;

        // this flag is used to throw exceptions
        boolean engineFound = false;

        // the following are features for the car.
        String type;
        String name;
        String option1;
        String option2;
        String option3;
        float length;
        float height;
        float weight;

        // iterate through all the lines from the file
        for (String[] e:linesFromFileWithoutHeader){

            // there are chances that options1,2 and 3 could be blank.
            // this could essentially throw IndexOutOfBounds Exception.
            try{
                type = e[0];
                name = e[1];
                length = Float.valueOf(e[2]);
                height = Float.valueOf(e[3]);
                weight = Float.valueOf(e[4]);
                option1 = e[5];
                option2 = e[6];
                option3 = e[7];

            }catch (Exception ex){
                System.out.println(ex);
            }


        }

    }




}
