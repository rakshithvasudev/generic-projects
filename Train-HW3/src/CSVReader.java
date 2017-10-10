/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This class is used to read CSV files.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        // specify the name of the file to be read.
        String filename = "train1.csv";

        // prints the csv of the file line by line.
        for (String[] e : readFile(filename))
            System.out.println(Arrays.toString(e));
    }

    /**
     * Reads a CSV file and returns the all the lines as an array of string[].
     * @param fileName name of the file to be read.
     * @return list of lines read, that is an array of strings.
     */
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