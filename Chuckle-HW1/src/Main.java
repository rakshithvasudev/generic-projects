import java.util.Scanner;

/**
 * Main class where the game is run. This contains the text GUI where the game is
 * setup to run at the end user level.
 */
public class Main {

    public static void main(String[] args) {
        // Start a new game.
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
                        System.out.println("Which die face value you want? 1 or 2? \n");
                        diceSelection = reader.nextInt();
                        game.updateScoreBoard(diceRollsValues[diceSelection - 1]);
                    }

                }
            } else if (option == 2) game.displayScoreBoard();
            else if (option == 3) System.exit(0);
        }
    }
}
