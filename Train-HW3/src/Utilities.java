import java.util.*;

/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This class is used to store general helper functions that needs to be used often.
 */
public class Utilities {

    public static void main(String[] args) {
//        findUniqueCarTypes();
        String[] lights =  {"12,123"};
        System.out.println(new CargoCar("name",122,12,12344,lights));
//        System.out.println();
//        System.out.println(new Utilities());
    }

     /**
     * Helps to find unique car types from all csv files.
     */
    public static void findUniqueCarTypes(){
        // choose input files here
        String[] filenames = {"train1.csv","train2.csv","train3.csv","train4.csv"};

       // choose unwanted strings to be removed here.
        String[] toRemove = {"TYPE"};
        List<String> allCarTypes = new ArrayList<>();
        Set<String> uniqueCars;

        // go through all the filenames and getTypesFromFile
        // merge all those values into the list.
        for (String e:filenames) {
            List<String> currentType  = getTypesFromFile(e);

            //merge the currentType into allCarType
            allCarTypes.addAll(currentType);
        }

        // get non repeated elements from Hashset
        // using the merged values.
        uniqueCars = new HashSet<>(allCarTypes);

        // remove unwanted elements in hashset defined above.
        // Add elements "toRemove" to remove elements here.
        for (String e : toRemove){
            uniqueCars.remove(e);
        }

        // print unique cars after removing unwanted elements.
        System.out.print("Here are your unique car types: ");
        System.out.println(uniqueCars);
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


    @Override
    public String toString() {
        return getClass().toString().replace("class ","");
    }
}
