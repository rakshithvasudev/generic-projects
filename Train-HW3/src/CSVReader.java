
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        for (String[] e : readFile("train1.csv"))
            System.out.println(Arrays.toString(e));
    }

    public static List<String[]> readFile(String fileName){
        String line;
        List<String[]> lines = new ArrayList<>();
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator and split
                 lines.add(line.split(cvsSplitBy));
            }

        } catch (IOException e) {
            System.out.println("System experienced an IO Error, the program is going to shut down.");
            System.exit(0);
        }

        return lines;
    }

}