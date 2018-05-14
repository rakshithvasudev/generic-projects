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
    public void generateStartingPopulation(int populationSize) {

        // generate random populations of size - populationSize
        for (int i = 0; i < populationSize; i++) {

            // generate a solution such that no 2 numbers repeat
            StringBuilder randomPopulation = new StringBuilder();

            while (true) {
                // generate a random number
                int randomColumn = ThreadLocalRandom.current().nextInt(1, 8 + 1);

                // if the generated random number not there
                // in randomPopulation, then append it
                if (randomPopulation.indexOf(String.valueOf(randomColumn)) == -1)
                    randomPopulation.append(randomColumn);

                // end generating random numbers when it reaches 8 digits
                if (randomPopulation.length() >= 8)
                    break;
            }

            // add it to the main population set
            startingPopulation.add(randomPopulation.toString());
        }
    }

    // counts the unique number of characters for a given
    // character sequence.
    public int countUniqueCharacters(String actualString) {
        Set<Character> stringSet = new HashSet<>();

        for (char c : actualString.toCharArray()) {
            stringSet.add(c);
        }
        return stringSet.size();
    }

    //The ideal case can yield upto 28 arrangements
    // of non attacking pairs in an 8 x 8 chessboard
    // Therefore max fitness = 28.
    public int calcFitnessScore(String solution) {

        // to calculate row and column clashes
        // subtract the total length of the sample
        // from the length of unique number of elements
        // of the sample.
        int uniqueElements = countUniqueCharacters(solution);
        int rcClashes = Math.abs(solution.length() - uniqueElements);
        int diagonalClashes = 0;

        // count the number of diagonal clashes
        for (int i = 0; i < solution.length(); i++) {
            for (int j = 0; j < solution.length(); j++) {
                if (i != j) {

                    int dx = Math.abs(i - j);
                    int dy = Math.abs((int) solution.charAt(i) - (int) solution.charAt(j));

                    if (dx == dy) {
                        diagonalClashes += 1;
                    }
                }
            }
        }
        return 28 - rcClashes - diagonalClashes;
    }

    // sorts a list on fitness score - descending order
    public void sortOnFitness(List<String> population){
        Collections.sort(population, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                 return calcFitnessScore(o2)-calcFitnessScore(o1);
            }
        });
    }


    // randomly cross 2 chromosomes and return
    public String crossOver(String chromosome1, String chromosome2){
        float crossOverProbability = (float) (ThreadLocalRandom.current().
                nextInt(1, 8 + 1)*0.1);

        int length1 = (int) Math.ceil(crossOverProbability*chromosome1.length());

        StringBuilder result = new StringBuilder();
        for (int i=0;i<length1;i++)
            result.append(chromosome1.charAt(i));

        for (int j = length1;j<8;j++)
            result.append(chromosome2.charAt(j));

        return result.toString().substring(0,8);
    }


    // list to be crossed over is given - sorted population
    public void performCrossOver(List<String> population){
        int evenLength = population.size();
        if (evenLength%2!=0)
            evenLength =-1;

        for (int i = 0; i<evenLength-1;i++){
            String chromosome1 = population.get(i);
            String chromosome2 = population.get(i+1);
            String result = crossOver(chromosome1,chromosome2);
            crossedPopulation.clear();
            crossedPopulation.add(result);
        }
    }


    // list to be crossed over is given - crossed population
    public void performMutation(List<String> population){
        for (String solution : population) {
                int randomValue = ThreadLocalRandom.current().nextInt(1, 7);
                solution = solution.replace(solution.charAt(randomValue),
                        Character.forDigit(randomValue,10));
                mutatedPopulation.clear();
                mutatedPopulation.add(solution);
            }
        }
    }


