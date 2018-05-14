
public class Trial {


    public static void main(String[] args) {
        EightQueensGA queensGA = new EightQueensGA();
        queensGA.generateStartingPopulation(100);
        System.out.println(queensGA.startingPopulation);
        queensGA.sortOnFitness(queensGA.startingPopulation);
        System.out.println(queensGA.startingPopulation);
        queensGA.performCrossOver(queensGA.startingPopulation);
        System.out.println(queensGA.crossedPopulation);
        queensGA.performMutation(queensGA.crossedPopulation);
        System.out.println(queensGA.mutatedPopulation);
    }
}
