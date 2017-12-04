import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Graphics g;
        DrawingPanel dp = new DrawingPanel(500,500);
        dp.setVisible(true);
        g = dp.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(17, 45, 139, 241);
        g.drawOval(234, 77, 100, 100);
    }
}
