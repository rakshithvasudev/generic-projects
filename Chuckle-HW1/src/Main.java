import java.util.Scanner;

/**
 * Main class where the game is run.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to playing Chuckles. Here are your options:");

        /**
         * Keeps looping forever either until the user quits the game or user finishes the game.
         */
        while (true){
            System.out.println("1. Roll Dice\n2. View scoreboard\n3. Exit Game: \n");
            int option = reader.nextInt();
            if(option==1) game.rollDice();
            else if (option ==2) game.displayScoreBoard();
            else if (option == 3) System.exit(0);
        }
    }
}
