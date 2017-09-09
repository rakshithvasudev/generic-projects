import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rakshith on 9/7/2017 for CSC527 - Software Construction
 * Assignment. This class contains the entire chuckle game
 * elements including the dice rolls, chosen values aka the scoreboard,
 *
 *
 */
public class Game {
    private static int rollsCounter;
    private Map<Integer,Integer> chosenValues;
    private Die die1,die2;

    public Game(){
        rollsCounter=0;
        die1 = new Die();
        die2 = new Die();
        chosenValues = new HashMap<>();
        initalizeGame();
    }

    private void initalizeGame() {
    for (int i=2;i<12;i++)
            chosenValues.put(i,0);
    }

    private void rollDice(){
     int die1Value = die1.roll(),die2Value = die2.roll();
     rollsCounter++;
    }




}
