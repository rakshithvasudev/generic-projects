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
    // example :{2=0,3=1,4=2......12=4}, Here 2: is rolled 0 times, while 12 was rolled 4 times.}
    private Map<Integer, Integer> chosenValues;
    private Die die1, die2;
    private boolean gameFinished;

    public Game() {
        die1 = new Die();
        die2 = new Die();
        chosenValues = new HashMap<>();
        gameFinished = false;
        initializeGame();
    }

    /**
     * Starts the game by initializing the scoreboard - chosenvalues.
     * All the keys of the map are the face values of the dice, while the values of the
     * map are the number of times it was rolled. To begin the game, the keys are initialized to 0's.
     */
    private void initializeGame() {
        for (int i = 2; i <= 12; i++)
            chosenValues.put(i, 0);
    }

    /**
     * Gets Dice rolls values.
     *
     * @returns the random values of dice rolls.
     */
    public int[] rollDice() {
        int die1Value = die1.roll(), die2Value = die2.roll();
        int[] diceValues = {die1Value, die2Value};
        int sumOfDice = die1Value + die2Value;
        System.out.println("The rolled dice values are : (" + die1Value + ", " + die2Value + ") => " + sumOfDice);
        return diceValues;
    }

    /**
     * Updates the scoreboard map. Adds 1 to the value of the map of the key "sumOfRolledDice".
     * Before updating the value to the scoreboard, the function checks if already the scoreboard is full
     * atleast once. If it's full, the game stops otherwise it adds to the scoreboard.
     *
     * @param sumOfRolledDice key to update the scoreboard.
     */
    public void updateScoreBoard(int sumOfRolledDice) {
        if (!checkForFullScore()) {
            try {
                chosenValues.put(sumOfRolledDice, chosenValues.get(sumOfRolledDice) + 1);
            } catch (NullPointerException e) {
                System.out.println("The previous score was not recorded for some issue. Continue playing.\n");
            }
        } else {
            System.out.println("Congrats, you've finished the game with :" + findTotalRolls() + " rolls.\n \n");
            System.out.println("Here is your final scoreboard :\n ");
            displayScoreBoard();
            System.exit(0);
        }
    }

    /**
     * Finds the total number of rolls in the values of the map.
     * Experimenting with java 8 lambdas seem to be more efficient
     * than regular for-each loop as discussed here :
     * https://stackoverflow.com/a/35558955
     *
     * @return the sum of values in the chosenvalues map.
     */
    public int findTotalRolls() {
        final int[] rollsSum = {0};
        chosenValues.forEach((k, v) -> rollsSum[0] += v);
        return rollsSum[0];
    }

    /**
     * Checks if the scoreboard is already full atleast once. Iterates through the values and even if one
     * value is '0' then the method returns false. This also indicates if the game is finished.
     *
     * @return True if full, False otherwise.
     */
    private boolean checkForFullScore() {
        for (Object o : chosenValues.values()) {
            if (((int) o == 0)) {
                return false;
            }
        }
        gameFinished = true;
        return true;
    }

    /**
     * Displays the scoreboard.
     */
    public void displayScoreBoard() {
        if (gameFinished)
            System.out.println("Finished Scoreboard is as follows: " + chosenValues + "\n \n");
        else
            System.out.println("Current Scoreboard is as follows: " + chosenValues + "\n \n");
    }

}
