import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        generateTrainFromFile("train1.csv");
    }

    public static void generateTrainFromFile(String fileName){

//        for (String[] e :CSVReader.readFileWithJustHeader(fileName)) {
//            System.out.println(Arrays.toString(e));
//        }

        System.out.println(Arrays.toString(CSVReader.readFileWithJustHeader(fileName)));

    }




}
