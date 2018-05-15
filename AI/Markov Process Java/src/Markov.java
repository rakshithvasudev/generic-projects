import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Markov {

    /**
     *     V C W P
     * V
     * C
     * W
     * P
     *
     * Transition count matrix
     */
    public int[][] firstTransitionMatrix = new int[4][4];
    public int[][] secondTransitionMatrix = new int[4][4];

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

    // adds content based on the given text to the matrix
    // first order matrix
    public void populateFirstMatrix(String groupedSequence){

        // iterate through every character and populate
        // to the matrix
        for (int i=0; i<groupedSequence.length()-1;i++){

            char currentChar = groupedSequence.charAt(i);
            char nextChar = groupedSequence.charAt(i+1);


            if (currentChar == 'V' && nextChar=='V') {
                firstTransitionMatrix[0][0] += 1;
            } else if(currentChar == 'V' && nextChar=='C') {
                firstTransitionMatrix[0][1] += 1;
            } else if (currentChar == 'V' && nextChar=='W') {
                firstTransitionMatrix[0][2] += 1;
            } else if (currentChar == 'V' && nextChar=='P') {
                firstTransitionMatrix[0][3] += 1;
            } else if (currentChar == 'C' && nextChar=='V') {
                firstTransitionMatrix[1][0] += 1;
            } else if (currentChar == 'C' && nextChar=='C') {
                firstTransitionMatrix[1][1] += 1;
            } else if (currentChar == 'C' && nextChar=='W') {
                firstTransitionMatrix[1][2] += 1;
            } else if (currentChar == 'C' && nextChar=='P') {
                firstTransitionMatrix[1][3] += 1;
            } else if (currentChar == 'W' && nextChar=='V') {
                firstTransitionMatrix[2][0] += 1;
            } else if (currentChar == 'W' && nextChar=='C') {
                firstTransitionMatrix[2][1] += 1;
            } else if (currentChar == 'W' && nextChar=='W') {
                firstTransitionMatrix[2][2] += 1;
            } else if (currentChar == 'W' && nextChar=='P') {
                firstTransitionMatrix[2][3] += 1;
            } else if (currentChar == 'P' && nextChar=='V') {
                firstTransitionMatrix[3][0] += 1;
            } else if (currentChar == 'P' && nextChar=='C') {
                firstTransitionMatrix[3][1] += 1;
            } else if (currentChar == 'P' && nextChar=='W') {
                firstTransitionMatrix[3][2] += 1;
            } else if (currentChar == 'P' && nextChar=='P') {
                firstTransitionMatrix[3][3] += 1;
            }
        }
    }


    // adds content based on the given text to the matrix
    // second order matrix
    public void populateSecondMatrix(String groupedSequence){

        // iterate through every character and populate
        // to the matrix
        for (int i=1; i<groupedSequence.length()-2;i++){

            // .substring() bounds are (inclusive, exclusive)
            String currentChar = groupedSequence.substring(i-1,i+1);
            String nextChar = groupedSequence.substring(i+1,i+2);

            if (currentChar.equals("VV") && nextChar.equals("V")) {
                secondTransitionMatrix[0][0] += 1;
            } else if(currentChar.equals("VC") && nextChar.equals("C")) {
                secondTransitionMatrix[0][1] += 1;
            } else if (currentChar.equals("VW") && nextChar.equals("W")) {
                secondTransitionMatrix[0][2] += 1;
            } else if (currentChar.equals("VP") && nextChar.equals("P")) {
                secondTransitionMatrix[0][3] += 1;
            } else if (currentChar.equals("CV") && nextChar.equals("V")) {
                secondTransitionMatrix[1][0] += 1;
            } else if (currentChar.equals("CC") && nextChar.equals("C")) {
                secondTransitionMatrix[1][1] += 1;
            } else if (currentChar.equals("CW") && nextChar.equals("W")) {
                secondTransitionMatrix[1][2] += 1;
            } else if (currentChar.equals("CP") && nextChar.equals("P")) {
                secondTransitionMatrix[1][3] += 1;
            } else if (currentChar.equals("WV") && nextChar.equals("V")) {
                secondTransitionMatrix[2][0] += 1;
            } else if (currentChar.equals("WC") && nextChar.equals("C")) {
                secondTransitionMatrix[2][1] += 1;
            } else if (currentChar.equals("WW") && nextChar.equals("W")) {
                secondTransitionMatrix[2][2] += 1;
            } else if (currentChar.equals("WP") && nextChar.equals("P")) {
                secondTransitionMatrix[2][3] += 1;
            } else if (currentChar.equals("PV") && nextChar.equals("V")) {
                secondTransitionMatrix[3][0] += 1;
            } else if (currentChar.equals("PC") && nextChar.equals("C")) {
                secondTransitionMatrix[3][1] += 1;
            } else if (currentChar.equals("PW") && nextChar.equals("W")) {
                secondTransitionMatrix[3][2] += 1;
            } else if (currentChar.equals("PP") && nextChar.equals("P")) {
                secondTransitionMatrix[3][3] += 1;
            }
        }
    }

    // given a 2D Matrix, returns the sum of rows
    public int[] calcRowSum(int[][] countMatrix){
        // find the sum of rows
        int[] horizontalRowSum = new int[countMatrix.length] ;
        for (int i=0;i<countMatrix.length;i++){
            for (int j=0;j<countMatrix[i].length;j++) {
                horizontalRowSum[i] += countMatrix[i][j];
            }
        }
        return horizontalRowSum;
    }

    // given a 2D countMatrix, returns a probability transition matrix
    public float [][] calculateProbabilites(int[][] countMatrix){
        float[][] pMatrix = new float [countMatrix.length][countMatrix[0].length];
        int[] hrowSum = calcRowSum(countMatrix);

        // divide every element with the row sum
        for (int i=0;i<countMatrix.length;i++){
            for (int j=0;j<countMatrix[i].length;j++) {
                if (hrowSum[i]==0)
                    continue;
                pMatrix[i][j] = (float)countMatrix[i][j]/hrowSum[i];
            }
        }
        return pMatrix;
    }

}
