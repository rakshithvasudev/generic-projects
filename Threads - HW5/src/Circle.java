import javax.swing.*;
import java.awt.*;


public class Circle extends JPanel{

    private DrawingPanel drawingPanel;
    private Graphics graphics;
    private int x, y, radius, flag;

    public Circle(int x, int y, int radius){
        this.x=x;
        this.y=y;
        this.radius=radius;

        drawingPanel = new DrawingPanel(600,400);
        drawingPanel.setBackground(Color.WHITE);
        graphics = drawingPanel.getGraphics();
        graphics.fillOval(x,y,radius,radius);

    }

    public void moveCircle(int x, int y){
        System.out.println("Move circle called");
        this.x=x;
        this.y=y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        System.out.println("Paint component called");

    }
}
