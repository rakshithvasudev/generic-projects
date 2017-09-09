import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rakshith on 9/7/2017 for CSC527 - Software Construction
 * Assignment. This class contains the entire chuckle game
 * elements including the dice rolls, chosen values aka the "scoreboard", that
 * tracks the number of times a roll event occurred.
 */
public class Game {
    //chosenValue tracks the values as follows:
    //{score:number of dice rolls},
    // example :{2:0,3:1,4:2......12:4}, Here 2: is rolled 0 times, while 12 was rolled 4 times.}
    private Map<Integer, Integer> chosenValues;
    private Die die1, die2;

    public Game() {
        die1 = new Die();
        die2 = new Die();
        chosenValues = new HashMap<>();
        initializeGame();
    }

    /**
     * Starts the game by initializing the scoreboard - chosenvalues.
     */
    private void initializeGame() {
        for (int i = 2; i < 12; i++)
            chosenValues.put(i, 0);
    }

    /**
     * Rolls both the dice and
     */
    private void rollDice() {
        int die1Value = die1.roll(), die2Value = die2.roll();
        System.out.println("The rolled dice values are : (" + die1Value + ", " + die2Value + ") => " + die1Value + die2Value);
        updateScoreBoard(die1Value + die2Value);
    }

    /**
     * Updates the scoreboard map. Adds 1 to the value of the map of the key "sumOfRolledDice".
     * Before updating the value to the scoreboard, the function checks if already the scoreboard is full
     * atleast once. If it's full, the game stops otherwise it adds to the scoreboard.
     * @param sumOfRolledDice key to update the scoreboard.
     */
    private void updateScoreBoard(int sumOfRolledDice) {
        checkForFullScore();
        try{
            chosenValues.put(sumOfRolledDice,chosenValues.get(sumOfRolledDice)+1);
        }catch (NullPointerException e){
            System.out.println("Error occurred please replay the game.");
        }
    }

    /**
     * Checks if the scoreboard is already full atleast once. Iterates through the values and even if one
     * value is '0', then the method returns false.
     * @return True if full, False otherwise.
     */
    private boolean checkForFullScore() {
        for (Object o : chosenValues.values()) {
            if (((int) o == 0)) {
                return false;
            }
        }
        return true;
    }


}
