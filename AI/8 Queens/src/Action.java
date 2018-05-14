import java.util.ArrayList;

public class Action {

    public static void main(String[] args) {
        EightQueensGA queensGA = new EightQueensGA();
        queensGA.generateStartingPopulation(100);
        int generationCount = 1;

        queensGA.sortOnFitness(queensGA.startingPopulation);
        System.out.println("Starting Population Max Fitness Score: "+
                (queensGA.calcFitnessScore(queensGA.startingPopulation.get(0))));

        queensGA.performCrossOver(queensGA.startingPopulation);
        queensGA.sortOnFitness(queensGA.crossedPopulation);
        System.out.println("Crossed Population Max Fitness Score: "+
                (queensGA.calcFitnessScore(queensGA.crossedPopulation.get(0))));


        queensGA.performMutation(queensGA.crossedPopulation);
        queensGA.sortOnFitness(queensGA.mutatedPopulation);
        System.out.println("Mutated Population: Max Fitness Score: "+
                (queensGA.calcFitnessScore(queensGA.mutatedPopulation.get(0))));

        // quit if solution found at the start only
        if ((queensGA.calcFitnessScore(queensGA.startingPopulation.get(0)))==28){
            System.out.print("solution: "+queensGA.startingPopulation.get(0));
            System.out.println(" at generation count: "+generationCount);
            return;
        }

        // if solution not found then keep searching
        while (true){

            System.out.println("-----");

            queensGA.sortOnFitness(queensGA.startingPopulation);
            System.out.println("Starting Population Max Fitness Score: "+
                    (queensGA.calcFitnessScore(queensGA.startingPopulation.get(0))));

            queensGA.performCrossOver(queensGA.startingPopulation);
            queensGA.sortOnFitness(queensGA.crossedPopulation);
            System.out.println("Crossed Population Max Fitness Score: "+
                    (queensGA.calcFitnessScore(queensGA.crossedPopulation.get(0))));


            queensGA.performMutation(queensGA.crossedPopulation);
            queensGA.sortOnFitness(queensGA.mutatedPopulation);
            System.out.println("Mutated Population: Max Fitness Score: "+
                    (queensGA.calcFitnessScore(queensGA.mutatedPopulation.get(0))));

            if ((queensGA.calcFitnessScore(queensGA.startingPopulation.get(0)))==28){
                System.out.print("solution: "+queensGA.startingPopulation.get(0));
                System.out.println(" at generation count: "+generationCount);
                break;
            }

            if ((queensGA.calcFitnessScore(queensGA.crossedPopulation.get(0)))==28){
                System.out.print("solution: "+queensGA.crossedPopulation.get(0));
                System.out.println(" at generation count: "+generationCount);
                break;
            }

            if ((queensGA.calcFitnessScore(queensGA.mutatedPopulation.get(0)))==28){
                System.out.print("solution: "+queensGA.mutatedPopulation.get(0));
                System.out.println(" at generation count: "+generationCount);
                break;
            }

            generationCount++;
            System.out.println("Generation count: "+ generationCount);
        }
    }
}