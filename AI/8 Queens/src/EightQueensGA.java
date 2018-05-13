import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Smit on 5/11/2018.
 */
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



    public void generateStartingPopulation(int populationSize){

        // generate random populations of size - populationSize
        for (int i=0;i<populationSize;i++){

            // generate a solution such that no 2 numbers repeat
            StringBuilder randomPopulation = new StringBuilder();

                // generate 8 digit unique numbers
                for (int j=0;j<BOARDCOLS;j++) {
                    int randomColumn = ThreadLocalRandom.current().nextInt(1, 8 + 1);

                    // if the generated random number not there then append it.
                    if (randomPopulation.indexOf(String.valueOf(randomColumn))==-1)
                            randomPopulation.append(randomColumn);

                    // if the generated random number is already there
                    // then generate until a unique number is found.
                    else
                        while (true){
                        
                        break;
                        }
                }

            startingPopulation.add(randomPopulation.toString());
        }
    }

    // There are  28 clashes possible in an 8 x 8 chessboard.
    // Thus there are 28 pairs of different queens,
    // smaller column first, all together,
    // so solutions have fitness 28.
//    public int calcFitnessFunction(String solution){
//
//
//    }
}


