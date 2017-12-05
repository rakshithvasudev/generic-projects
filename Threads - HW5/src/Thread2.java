import java.applet.Applet;
import java.awt.*;

public class Thread2 extends Applet implements Runnable
{
    int y,flag;
    Thread t;
    public void init()
    {
        y=0;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        while(true)
        {
            if(y==0) flag=0;
            if(y==350) flag=1;

            if(flag==0) y+=5;
            if(flag==1) y-=5;
            repaint();
            try
            {
                Thread.sleep(20);
            }
            catch(InterruptedException er)
            {
                System.out.println("Unable to run sleep function");
            }
        }
    }
    public void paint(Graphics g)
    {
        g.drawOval(300,y,50,50);
        g.drawLine(200,400,500,400);
    }
}