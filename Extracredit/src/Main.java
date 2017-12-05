import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Graphics g;
        DrawingPanel dp = new DrawingPanel(500,500);
        dp.setVisible(true);
        g = dp.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,4, 4);
        g.fillRect(4,4,4,4);
        g.fillRect(4,0,4,4);
        g.fillRect(0,4,4,4);


//        int x = 0;
//
//        for (x=0;x<)

    }
}
