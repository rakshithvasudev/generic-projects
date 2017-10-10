import java.util.*;

public class Utilities {
    /**
     * Helps to find unique car types from all csv files.
     */
    public static void findUniqueCarTypes(){
        // choose input files here
        String[] filenames = {"train1.csv","train2.csv","train3.csv","train4.csv"};

       // choose unwanted strings to be removed here.
        String[] toRemove = {"TYPE"};
        List<String> allCarTypes = new ArrayList<>();
        Set<String> uniqueCars = null;

        // go through all the filenames and getTypesFromFile
        // merge all those values into the list.
        for (String e:filenames) {
            List<String> currentType  = getTypesFromFile(e);
            allCarTypes.addAll(currentType);
        }

        // get non repeated elements from Hashset
        // using the merged values.
        uniqueCars = new HashSet<>(allCarTypes);

        // remove unwanted elements from the hashset defined above.
        for (String e : toRemove)
            uniqueCars.remove(e);

        // print unique cars after removing unwanted elements.
        System.out.println(uniqueCars);
    }

    public static void main(String[] args) {
        findUniqueCarTypes();
    }

    /**
     * prints all the CSV contents from a file.
     * @param fileName name of the file to print values from.
     */
    public static void printLinesFromFile(String fileName){
        for (String[] e : CSVReader.readFile(fileName)){
               System.out.println(Arrays.toString(e));
        }
    }

    /**
     * Returns the all the car types from a file.
     * @param fileName name of the file to read from.
     * @return car types from file.
     */
    public static List<String> getTypesFromFile(String fileName){
       List<String> carTypes = new ArrayList<>();
        for (String[] e : CSVReader.readFile(fileName)){
            carTypes.add(e[0]);
        }
        return carTypes;
    }
}
