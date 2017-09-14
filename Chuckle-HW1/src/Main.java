import java.util.Scanner;

/**
 * Created by Rakshith on 9/7/2017 for CSC527 - Software Construction
 * Assignment. This is the Main class where the game is run. This contains the text GUI where the game is
 * setup to run at the end user level.
 */
public class Main {

    public static void main(String[] args) {
        // Start a new game instance.
        Game game = new Game();

        //used to seek for user inputs.
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to playing Chuckles. Here are your options:");


        // Keeps looping forever either until the user quits the game or user finishes the game.
        while (true) {
            System.out.println("1. Roll Dice\n2. View scoreboard\n3. Exit Game: \n");
            int option = reader.nextInt();
            int lock, diceSelection;
            if (option == 1) {
                // get the random values from both the die.
                int[] diceRollsValues = game.rollDice();

                // If the game is just starting then don't ask for locking the die values.
                if (game.findTotalRolls() == 0) {
                    game.updateScoreBoard(diceRollsValues[0] + diceRollsValues[1]);
                } else {
                    System.out.println("Do you want to lock the dice? Yes-1, No-0: \n");
                    lock = reader.nextInt();
                    // if the user doesn't request for the lock then update the map with both the values of the dice.
                    if (lock == 0) {
                        game.updateScoreBoard(diceRollsValues[0] + diceRollsValues[1]);
                    } else if (lock == 1) {
                        System.out.println("Which die face value you want?'" + (diceRollsValues[0]) +
                                "' -1 or '" + (diceRollsValues[1]) + "' -2? \n");
                        diceSelection = reader.nextInt();
                        // make sure the user entered the right value for the input.
                        if (diceSelection == 1 || diceSelection == 2)
                            // update the map with the request value from the dice.
                            game.updateScoreBoard(diceRollsValues[diceSelection - 1]);
                        else {
                            System.out.println("You have to enter either 1 or 2. No other values. \n");
                            return;
                        }
                    }
                }

                // Display scoreboard method display's the value of the scores.
            } else if (option == 2) game.displayScoreBoard();

                // exits the game. Returns the control to OS.
            else if (option == 3) System.exit(0);
        }
    }
}
