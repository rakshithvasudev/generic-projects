import java.awt.*;

/**
 * By Rakshith on 4th Tuesday 2017 for CSC 527- Software
 * construction threads assignment- HW5
 * This class constructs and manipulates the circle.
 */
public class Circle{

    private DrawingPanel drawingPanel;
    private Graphics graphics;
    private int radius;

    /**
     * Constucts a circle on the drawing panel and initializes it.
     * @param x x co-ordinate of the location
     * @param y y co-ordinate of the location
     * @param radius radius of the circle
     */
    public Circle(int x, int y, int radius){
        this.radius=radius;

        // initialize the drawing panel with the dimensions.
        drawingPanel = new DrawingPanel(600,400);
        drawingPanel.setBackground(Color.WHITE);

        // get the graphics object for further painting on the panel.
        graphics = drawingPanel.getGraphics();

        // paint a circle with specified x, y and radius.
        graphics.fillOval(x,y,radius,radius);

    }

    /**
     * Clears the original drawing panel
     */
    public void clearCircle(){
        drawingPanel.clear();
    }

    /**
     * Move the circle to another co-ordinate maintaining the
     * same radius.
     * @param x new x co-ordinate of the location
     * @param y new y co-ordinate of the location
     */
    public void moveCircle(int x, int y){
        clearCircle();
        graphics.fillOval(x,y,radius,radius);
    }


}
