import java.util.Arrays;
import java.util.List;

public class Action {

    public static void main(String[] args) {
//          String sample = "John's tire was not 12 inches across anymore!";
        Markov mvp = new Markov();
        String sample = mvp.readText("bible.txt");
        List<Character> lists = mvp.convertToGroups(sample);
        String groupedString = lists.toString().replace(", ","");
        mvp.populateFirstMatrix(groupedString);
        mvp.populateSecondMatrix(groupedString);
//        System.out.println(Arrays.deepToString(mvp.firstTransitionMatrix));
//        System.out.println(groupedString.length());
//        System.out.println(lists.size());


        System.out.println(Arrays.deepToString(mvp.calculateProbabilites(mvp.firstTransitionMatrix)));
        System.out.println(Arrays.deepToString(mvp.calculateProbabilites(mvp.secondTransitionMatrix)));
    }

}
