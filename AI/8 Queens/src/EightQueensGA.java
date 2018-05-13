import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class EightQueensGA {

    // Rows and Columns
    public static int BOARDROWS = 8;
    public static int BOARDCOLS = 8;

    //stores randomly generated population to start
    public List<String> startingPopulation = new ArrayList<>();

    // crossed population after combining two starting population
    public List<String> crossedPopulation = new ArrayList<>();

    // modified population after cross
    public List<String> mutatedPopulation = new ArrayList<>();


    // produces required number of populations
    public void generateStartingPopulation(int populationSize){

        // generate random populations of size - populationSize
        for (int i=0;i<populationSize;i++){

            // generate a solution such that no 2 numbers repeat
            StringBuilder randomPopulation = new StringBuilder();

               while (true){
                   // generate a random number
                   int randomColumn = ThreadLocalRandom.current().nextInt(1, 8 + 1);

                   // if the generated random number not there
                   // in randomPopulation, then append it
                   if (randomPopulation.indexOf(String.valueOf(randomColumn))==-1)
                       randomPopulation.append(randomColumn);

                   // end generating random numbers when it reaches 8 digits
                   if (randomPopulation.length()==8)
                    break;
               }

            // add it to the main population set
            startingPopulation.add(randomPopulation.toString());
        }
    }

    public int countUniquecharacters(String actualString){
        Set<Character> stringSet = new HashSet<>();

        for (char c:actualString.toCharArray()){
            stringSet.add(c);
        }
        return stringSet.size();
    }

    //The ideal case can yield upto 28 arrangements
    // of non attacking pairs in an 8 x 8 chessboard
    // Therefore max fitness = 28.
    public int calcFitnessFunction(String solution){

        // to calculate row and column clashes
        // subtract the total length of the sample
        // from the length of unique number of elements
        // of the sample.
        int uniqueElements = countUniquecharacters(solution);
        int rcClashes = solution.length()- uniqueElements;
        return rcClashes;
    }
}


