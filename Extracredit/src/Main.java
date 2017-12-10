import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int ORGANISM_SIZE_PX = 4;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();
    private static Map<Coordinates2D<Integer>,Boolean> firstGenOccupiedStatus = new HashMap<>();
    private static Map<Coordinates2D<Integer>,Boolean> nextGenOccupiedStatus = new HashMap<>();

    public static void main(String[] args) {
            generateFirstOrganisms(200);
            System.out.println("Generated First Generation organisms");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generateNextGenOrganisms(200);
        System.out.println(nextGenOccupiedStatus);
    }

    private static void generateNextGenOrganisms(int numberOfOrganisms) {
        int acceptedOrganismsCount = 0;
        while(true){
            if(acceptedOrganismsCount >= numberOfOrganisms){
                break;
            }
            int randX = randomNumberGenerator(0, WIDTH);
            int randY = randomNumberGenerator(0, HEIGHT);
            if(checkIfFillable(randX,randY,ORGANISM_SIZE_PX)){
                nextGenOccupiedStatus.put(new Coordinates2D<>(randX,randY),true);
                acceptedOrganismsCount++;
            }
        }
    }

    public static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void generateFirstOrganisms(int numberOfOrganisms) {
        for (int i = 0; i < numberOfOrganisms; i++) {
            int randX = randomNumberGenerator(0, WIDTH);
            int randY = randomNumberGenerator(0, HEIGHT);
            graphics.fillRect(randX, randY, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
            firstGenOccupiedStatus.put(new Coordinates2D<>(randX,randY),true);
        }

        System.out.println(firstGenOccupiedStatus);
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
    public static boolean checkIfFillable(int x, int y, int pixelSize){
        int occupancyCounter = 0;


        // Iterate through all the points and look out for the neighbours
        for ( Coordinates2D e: firstGenOccupiedStatus.keySet()) {

            //Diagonal left neighbour (x-p,y+p)
            if(new Coordinates2D<>(x-pixelSize,y+pixelSize).equals(e)){
                occupancyCounter++;
            }
            //top neighbour (x,y+p)
            else if(new Coordinates2D<>(x,y+pixelSize).equals(e)){
                occupancyCounter++;
            }
            //top right neighbour (x+p,y+p)
            else if(new Coordinates2D<>(x+pixelSize,y+pixelSize).equals(e)){
                occupancyCounter++;
            }
            //right neighbour (x+p,y)
            else if(new Coordinates2D<>(x+pixelSize,y).equals(e)){
                occupancyCounter++;
            }
            //bottom right neighbour (x+p,y)
            else if(new Coordinates2D<>(x+pixelSize,y-pixelSize).equals(e)){
                occupancyCounter++;
            }
            //bottom neighbour (x,y-p)
            else if(new Coordinates2D<>(x,y-pixelSize).equals(e)){
                occupancyCounter++;
            }
            //bottom left neighbour (x-p,y-p)
            else if(new Coordinates2D<>(x-pixelSize,y-pixelSize).equals(e)){
                occupancyCounter++;
            }
            //left neighbour (x-p,y)
            else if(new Coordinates2D<>(x-pixelSize,y).equals(e)){
                occupancyCounter++;
            }

        }

        return (occupancyCounter == 3)||(occupancyCounter ==2);
    }


}
