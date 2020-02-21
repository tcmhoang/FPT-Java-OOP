import javax.swing.*;


public class Maze {
    Maze ()
    {
        __init__();
    }
    private void  __init__()
    {
        JFrame canvas = new JFrame("Simple Swing Calculator");
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setResizable(false);
        canvas.setLayout(null);
//        canvas.setSize(WIDTH, HEIGHT);
        canvas.setIconImage(new ImageIcon("data/favicon-32x32.png").getImage());
    }
}
