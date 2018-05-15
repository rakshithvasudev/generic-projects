import java.util.Arrays;

public class Action {

    public static void main(String[] args) {
        //  String sample = "John's tire was not 12 inches across anymore!";
        Markov mvp = new Markov();
//        String sample = mvp.readText("bible.txt");
//        List<Character> lists = mvp.convertToGroups(sample);
//
//        System.out.println(lists.toString());
//        System.out.println(sample.length());
        System.out.println(Arrays.deepToString(mvp.firstTransitionMatrix));

    }

}
