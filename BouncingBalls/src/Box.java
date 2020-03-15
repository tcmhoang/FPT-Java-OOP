import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Box extends JPanel implements ActionListener {
    public static void main(String[] args) {
        JFrame canvas = new JFrame("Bouncing ball");
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setLayout(null);
        canvas.setSize(500,500);
        canvas.setResizable(false);
        canvas.setVisible(true);
        Dimension size = new Dimension(canvas.getWidth() - canvas.getInsets().left - canvas.getInsets().right,canvas.getHeight() - canvas.getInsets().top - canvas.getInsets().bottom);
        Box box = new Box(10,size);
        canvas.add(box);
    }

    private int WIDTH , HEIGHT;
    private Random gen;
    private Timer timer;
    private List<Ball> balls;
    Box(int quantity, Dimension dimension)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setLayout(null);
        setVisible(true);
        setSize(dimension);
        WIDTH = getWidth();
        HEIGHT = getHeight();
        Ball.setSize(getSize());
        balls = new ArrayList<>();
        gen = new Random();

        for(int i = 0 ; i < quantity ; i++)
        {
            int diameter = gen.nextInt(5) * 30;
            Ball b = new Ball(gen.nextInt(WIDTH - diameter), gen.nextInt(HEIGHT - diameter),diameter,1 + 4 * gen.nextDouble());
            balls.add(b);
        }

        timer = new Timer(7,this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        balls.forEach(b -> b.move(g2d));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
