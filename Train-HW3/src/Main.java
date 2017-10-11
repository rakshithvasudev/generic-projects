import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        generateTrainFromFile("train1.csv");
        generateTrainFromFile("train2.csv");
        generateTrainFromFile("train3.csv");

    }

    public static void generateTrainFromFile(String fileName){

//        for (String[] e :CSVReader.readFileHeader(fileName)) {
//            System.out.println(Arrays.toString(e));
//        }

        System.out.println(Arrays.toString(CSVReader.readFileHeader(fileName)));

    }




}
