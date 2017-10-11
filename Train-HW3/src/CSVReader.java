import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This class is used to read CSV files.
 */

public class CSVReader {

    /**
     * Reads a CSV file and returns the all the lines as an List of string[].
     * reference taken from https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
     *
     * @param fileName name of the file to be read.
     * @return list of lines read, that is an array of strings.
     */
    public static List<String[]> readFile(String fileName){
        String line;

        List<String[]> lines = new ArrayList<>();

        // defining delimiting character
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

    /**
     * Retruns lines without the header.
     * @param fileName name of the file to be read.
     * @return list of lines read, that is an array of strings without first line.
     */
    public static List<String[]> readFileWithoutHeader(String fileName){
        List<String[]> allLinesWithoutFirstLine;
        // get all lines from CSV reader
        allLinesWithoutFirstLine = readFile(fileName);
        // Remove the header line aka first line.
        allLinesWithoutFirstLine.remove(0);

        return allLinesWithoutFirstLine;
    }


}