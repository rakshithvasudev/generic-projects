import java.util.Arrays;
import java.util.List;

public class Action {

    public static void main(String[] args) {
        Markov mvp1 = new Markov();
        String sample = mvp1.readText("bible.txt");
        List<Character> lists = mvp1.convertToGroups(sample);
        String groupedString = lists.toString().replace(", ","");
        mvp1.populateFirstMatrix(groupedString);
        mvp1.populateSecondMatrix(groupedString);
        System.out.println("P(Xi|Xi-1):");
        System.out.println(Arrays.deepToString(mvp1.calculateProbabilites(mvp1.firstTransitionMatrix)));
        System.out.println("P(Xi|Xi-1,Xi-2):");
        System.out.println(Arrays.deepToString(mvp1.calculateProbabilites(mvp1.secondTransitionMatrix)));
        System.out.println("Not a 1st order ");

        System.out.println("-------------------------------------------------------------------------");

        Markov mvp2 = new Markov();
        String sample2 = mvp2.readText("alger.txt");
        List<Character> lists2 = mvp2.convertToGroups(sample2);
        String groupedString2 = lists2.toString().replace(", ","");
        mvp2.populateFirstMatrix(groupedString2);
        mvp2.populateSecondMatrix(groupedString2);
        System.out.println("P(Xi|Xi-1):");
        System.out.println(Arrays.deepToString(mvp2.calculateProbabilites(mvp2.firstTransitionMatrix)));
        System.out.println("P(Xi|Xi-1,Xi-2):");
        System.out.println(Arrays.deepToString(mvp2.calculateProbabilites(mvp2.secondTransitionMatrix)));
        System.out.println("Not a 1st order ");
    }

}
