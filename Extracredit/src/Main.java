import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static DrawingPanel drawingPanel = new DrawingPanel(600, 400);
    private static Graphics graphics = drawingPanel.getGraphics();


    public static void main(String[] args) {

        for (int i = 0; i < 300; i++) {
            int randX = randomNumberGenerator(0, 600);
            int randY = randomNumberGenerator(0, 400);
            graphics.fillRect(randX, randY, 4, 4);
        }
    }

    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void generatePoints(int numberOfPoints) {

    }
}
