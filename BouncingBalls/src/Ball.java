import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private double x;
    private double y;
    private int diameter;
    private double velx;
    private double vely;
    private Color color;
    private static int WIDTH, HEIGH;

    Ball(int x, int y, int diameter, double vel) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        velx = vely = vel;
        Random random = new Random();
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static void setSize(Dimension dimension) {
        WIDTH = dimension.width;
        HEIGH = dimension.height ;
    }


    private void draw(Graphics2D g) {
        g.setPaint(color);
        Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);
        g.fill(circle);
    }

    private void updatePos() {
        if (x < 0 || x > WIDTH - diameter)
        {
            velx = -velx;
        }
        if (y < 0 || y > HEIGH - diameter)
        {
            vely = -vely;
        }
        x += velx;
        y += vely;
    }

    public void move(Graphics2D g)
    {
        draw(g);
        updatePos();
    }

}
