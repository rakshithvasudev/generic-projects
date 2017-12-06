import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static DrawingPanel drawingPanel = new DrawingPanel(600, 400);
    private static Graphics graphics = drawingPanel.getGraphics();


    public static void main(String[] args) {
        while(true){
            generatePoints();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawingPanel.clear();
        }

    }

    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void generatePoints() {

        List<Integer> randXPoints = new ArrayList<>();
        List<Integer> randYPoints = new ArrayList<>();


        for (int i = 0; i < 500; i++) {
            int randX = randomNumberGenerator(0, 600);
            int randY = randomNumberGenerator(0, 400);
            graphics.fillRect(randX, randY, 4, 4);
            randXPoints.add(randX);
            randYPoints.add(randY);
        }
    }
}
