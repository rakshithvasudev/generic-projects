// SudokuBuilder Creed Jones CSC512 CBU December 27, 2017
//  this class uses a GA to create a fully valid sudoku board

import java.util.Random;

public class SudokuBuilder {
    private static final int NUMGENERATIONS = 100000000;
    private static final int PERFECTSCORE = 243;
    private static double mutateProb = 0.0001;
    private int popsize;
    private GAPopulation pop;
    private Random rand = new Random();
    private final Boolean doCrossover = false;

    public SudokuBuilder() {
        pop = new GAPopulation();
        pop.initialize();
    }

    public SudokuBuilder(int size) {
        pop = new GAPopulation(size);
        pop.initialize();
    }

    public int newGeneration() {
        if (doCrossover) {
            // breeding
            pop = pop.breed();
        }
        else {
            pop = pop.crossover();
        }
        // mutate
        pop.mutate(mutateProb);

        // sort and assign breeding probabilities
        return pop.sort();
    }

    private String getFitnessString() {
        return pop.getFitnessString();
    }

    private String getResultString() {
        return pop.toString();
    }

    public static void main(String[] args){
        SudokuBuilder builder = new SudokuBuilder();
        int maxfitness = 0,lastfitness = 0;
        Stopwatch swatch = new Stopwatch();
        swatch.start();
        try {
            // PrintWriter writer = new PrintWriter("learnHistory.csv", "UTF-8");
            for (int generation = 0; generation < NUMGENERATIONS; generation++) {
                lastfitness = maxfitness;
                maxfitness = builder.newGeneration();
                if (lastfitness != maxfitness) {
                    System.out.println("Generation: " + generation + ", Fitness = " + maxfitness + "; mutateProb = " + mutateProb);
                }
                // writer.println(builder.getFitnessString());
                if (maxfitness == PERFECTSCORE) {
                    break;
                }
                if ((mutateProb < 0.01) && (generation % 1000) == 0) {
                    mutateProb *= 1.01;
                }
            }
            // writer.close();
        }
        catch (Exception e) {

        }
        swatch.stop();
        System.out.print(builder.getResultString());
        System.out.println("Process finished in " + swatch.getElapsedTimeSecs() + " seconds.");
    }
}