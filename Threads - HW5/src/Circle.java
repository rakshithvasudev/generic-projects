import java.awt.*;

/**
 * By Rakshith on 4th Dec 2017 for CSC 527- Software
 * construction - threads assignment- HW5
 * This class constructs and manipulates the circle.
 */
public class Circle{

    private DrawingPanel drawingPanel;
    private Graphics graphics;
    private int x, y,radius;

    /**
     * Constucts a circle on the drawing panel and initializes it.
     * @param x x co-ordinate of the location
     * @param y y co-ordinate of the location
     * @param radius radius of the circle
     */
    public Circle(int x, int y, int radius){
        // setup the circle properties
        this.x = x;
        this.y = y;
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
    public void moveCircleTo(int x, int y){
        // clean the panel.
        clearCircle();

        // copy the co-ordinates globally.
        this.x = x;
        this.y = y;

        // draw a new circle as specified.
        graphics.fillOval(x,y,radius,radius);
    }

    /**
     * Moves the circle by the specified pixels maintaining the
     * same radius.
     * @param x x pixels updating the co-ordinates
     * @param y y pixels updating the co-ordinates
     */
    public void moveCircleBy(int x, int y){
        // clean the panel.
        clearCircle();

        // update and copy the co-ordinates globally.
        this.x += x;
        this.y += y;

        // draw a new circle as specified.
        graphics.fillOval(this.x,this.y,radius,radius);

    }

}
