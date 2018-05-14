import java.util.ArrayList;

public class Trial {


    public static void main(String[] args) {
        EightQueensGA queensGA = new EightQueensGA();
        queensGA.generateStartingPopulation(100);
        int generationCount = 1;

        System.out.println("Starting Population: "+queensGA.startingPopulation);
        queensGA.sortOnFitness(queensGA.startingPopulation);
        System.out.println("Sorted Population: "+queensGA.startingPopulation);
        queensGA.performCrossOver(queensGA.startingPopulation);
        System.out.println("Crossed Population: "+queensGA.crossedPopulation);
        queensGA.performMutation(queensGA.crossedPopulation);
        System.out.println("Mutated Population: "+queensGA.mutatedPopulation);

        // quit if solution found at the start only
        if ((queensGA.calcFitnessScore(queensGA.startingPopulation.get(0)))==28){
            System.out.print("solution: "+queensGA.startingPopulation.get(0));
            System.out.println(" at generation count: "+generationCount);
            return;
        }

        // if solution not found then keep searching
        while (true){

            System.out.println("-----");
            System.out.println("Starting Population: "+queensGA.startingPopulation);
            queensGA.sortOnFitness(queensGA.startingPopulation);
            System.out.println("Sorted Population: "+queensGA.startingPopulation);
            queensGA.performCrossOver(queensGA.startingPopulation);
            System.out.println("Crossed Population: "+queensGA.crossedPopulation);
            queensGA.performMutation(queensGA.crossedPopulation);
            System.out.println("Mutated Population: "+queensGA.mutatedPopulation);


            if ((queensGA.calcFitnessScore(queensGA.startingPopulation.get(0)))==28){
                System.out.print("solution: "+queensGA.startingPopulation.get(0));
                System.out.println(" at generation count: "+generationCount);
                break;
            }

            generationCount++;

            System.out.println("Generation count: "+ generationCount);
        }
    }
}