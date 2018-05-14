import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    // reads the text from the specified filename and
    // returns the read content
    public String readText(String fileName){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder content = new StringBuilder();
        while (scanner.hasNext()){
            content.append(scanner.next());
        }
        return content.toString();
    }

    



}
