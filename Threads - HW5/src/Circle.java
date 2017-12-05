import javax.swing.*;
import java.awt.*;


public class Circle{

    DrawingPanel drawingPanel;
    Graphics graphics;


    public Circle(){
        drawingPanel = new DrawingPanel(600,400);
        drawingPanel.setBackground(Color.WHITE);
        graphics = drawingPanel.getGraphics();
    }

    public void generateCircle(int x, int y, int radius){
        graphics.fillOval(x,y,radius,radius);
    }






}
