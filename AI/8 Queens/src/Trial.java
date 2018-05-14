
public class Trial {


    public static void main(String[] args) {
        EightQueensGA queensGA = new EightQueensGA();
//        queensGA.generateStartingPopulation(10000);
//
//        System.out.println(queensGA.startingPopulation);
//        queensGA.sortOnFitness(queensGA.startingPopulation);
//        System.out.println(queensGA.startingPopulation);


        System.out.println(queensGA.crossOver("123456789","34561239"));
    }
}
