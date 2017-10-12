import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        generateTrainFromFile("train2.csv");

    }

    /**
     * [TYPE, NAME, LENGTH, HEIGHT, WEIGHT, OPTION1, OPTION2, OPTION3]
     *
     */
    public static void generateTrainFromFile(String fileName){
        String type;
        String name;
        String option1;
        String option2;
        String option3;
        float length;
        float height;
        float weight;

        for (String[] e: CSVReader.readFileWithoutHeader(fileName)){
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
//                System.out.println(Arrays.toString(e));
            }


        }

    }




}
