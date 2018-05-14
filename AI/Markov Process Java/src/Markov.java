import java.util.ArrayList;
import java.util.List;

public class Markov {

    // given a sequence of text, this returns an list of categorized responses
    public List<Character> convertToGroups(String textSequence){
        textSequence = textSequence.toLowerCase();
        List<Character> groupList = new ArrayList<>();
        for (Character c: textSequence.toCharArray()) {
            groupList.add(group(Character.toString(c)));
        }
        return groupList;
    }


    // the actual function to convert from character to a category
    public Character group(String C){

        if (C.matches("[aeiou]")){
            return 'V';
        }
        else if(C.matches("[bcdfghjklmnpqrstvwxyz]")){
            return 'C';
        }
        else if (C.matches("[\\s]")){
            return 'W';
        }
        return 'P';
    }


    public String readText(String fileName){
        

    }


}
