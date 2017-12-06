import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();
    private static List<Integer> randXPoints = new ArrayList<>();
    private static List<Integer> randYPoints = new ArrayList<>();

    public static void main(String[] args) {
            generatePoints(300);
            System.out.println("Generated organisms");
    }

    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void generatePoints(int numberOfPoints) {
        for (int i = 0; i < numberOfPoints; i++) {
            int randX = randomNumberGenerator(0, WIDTH);
            int randY = randomNumberGenerator(0, HEIGHT);
            graphics.fillRect(randX, randY, 4, 4);
            randXPoints.add(randX);
            randYPoints.add(randY);
        }

        // prints the zip (x,y) pairs using java 8 lamba functions

        System.out.println(IntStream
                .range(0,Math.min(randXPoints.size(),randYPoints.size()))
                .mapToObj((i -> "("+randXPoints.get(i) + ", " + randYPoints.get(i) +")"))
                .collect(Collectors.toList())
        );

    }

    /**
     * Checks if there is an opportunity for a new organism to be grown
     * based on the rules that :
     * There was an organism at the location in the last generation and two of the eight
       neighboring locations also contained organisms;
     * Three of the eight neighboring locations contained organisms in the last generation.
     * @param x
     * @param y
     * @return
     */
    public boolean checkIfFillable(int x, int y){
        int occupancyCounter = 0;






        return (occupancyCounter == 3)||(occupancyCounter ==2);
    }


}
