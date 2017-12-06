import java.awt.*;

public class Organism {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int ORGANISM_SIZE_PX = 4;
    private static DrawingPanel drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
    private static Graphics graphics = drawingPanel.getGraphics();


    public Organism(int x, int y){
        graphics.fillRect(x, y, ORGANISM_SIZE_PX, ORGANISM_SIZE_PX);
    }

}
