// The DrawingPanel class provides a simple interface for drawing persistent
// images using a Graphics object.

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JFrame.*;
import static java.awt.BorderLayout.*;
import static java.awt.image.BufferedImage.*;
import static java.awt.RenderingHints.*;

public class DrawingPanel {
    public static final int DELAY = 250;  // ms delay between repaints

    private JFrame frame;         // overall window frame
    private JPanel panel;         // overall drawing surface
    private Graphics g;           // graphics context for painting
    private JLabel statusBar;     // status bar showing mouse position

    // constructs a drawing panel of given width and height enclosed in a window
    public DrawingPanel(int width, int height) {
        // set up the empty image onto which we will draw
        BufferedImage image = new BufferedImage(width, height, TYPE_INT_ARGB);
        this.g = image.getGraphics();
        this.g.setColor(Color.BLACK);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));

        this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.panel.setBackground(Color.WHITE);
        this.panel.setPreferredSize(new Dimension(width, height));
        this.panel.add(label);

        // the status bar that shows the mouse position
        this.statusBar = new JLabel(" ");
        this.statusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        StatusBarMouseAdapter mouse = new StatusBarMouseAdapter();
        this.panel.addMouseListener(mouse);
        this.panel.addMouseMotionListener(mouse);

        // set up the JFrame
        this.frame = new JFrame("Drawing Panel");
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.add(panel);
        this.frame.add(statusBar, SOUTH);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.toFront();

        // start a repaint timer so that the screen will update
        TimerListener listener = new TimerListener();
        Timer timer = new Timer(DELAY, listener);
        timer.start();
    }

    // obtain the Graphics object to draw on the panel
    public Graphics getGraphics() {
        return this.g;
    }

    // set the background color of the drawing panel
    public void setBackground(Color c) {
        this.panel.setBackground(c);
    }

    // show or hide the drawing panel on the screen
    public void setVisible(boolean visible) {
        this.frame.setVisible(visible);
    }

    // makes the program pause for the given amount of time, for animation
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    // makes drawing panel become the frontmost window on the screen
    public void toFront() {
        this.frame.toFront();
    }

    // used for an internal timer that repeatedly repaints the screen
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.repaint();
        }
    }

    // draws the status bar text when the mouse moves
    class StatusBarMouseAdapter extends MouseInputAdapter {
        public void mouseMoved(MouseEvent e) {
            statusBar.setText("(" + e.getX() + ", " + e.getY() + ")");
        }
    }
}