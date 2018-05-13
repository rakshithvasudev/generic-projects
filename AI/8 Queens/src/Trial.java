/**
 * Created by Rakshith on 5/12/2018.
 */
public class Trial {


    public static void main(String[] args) {
        EightQueensGA queensGA = new EightQueensGA();
        queensGA.generateStartingPopulation(10);

        System.out.println(queensGA.startingPopulation);
    }
}
