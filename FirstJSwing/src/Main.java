import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String[] args) {
        init();
    }
    private static void init()
    {
        JFrame canvas = new JFrame("My First Swing");
        canvas.setLayout(null);
        canvas.setSize(450, 270);
        JComponent[] items = {
                new JLabel("First"),//1
                new JLabel("Second"),//2
                new JTextField("integer 1"),//3
                new JTextField("integer 2"),//4
                new JButton("➕➕➕➕➕+➕➕"),//5
                new JButton("-"),//6
                new JButton("×"),//7
                new JButton("÷"),//8
                new JTextField("Result: ")//9
        };
        for(JComponent item : items)
        {
            canvas.add(item);
            if(item instanceof JLabel)
            {
                item.setSize(50,30);
            }
            else if(item instanceof JTextField)
            {
                item.setSize(90,30);
            }
            else
            {
                item.setSize(80,80);
            }
        }
        items[0].setLocation(10,10);
        items[1].setLocation(10,40);
        items[2].setLocation(80,10);
        items[3].setLocation(80,40);
        items[4].setLocation(10,100);
        items[5].setLocation(120,100);
        items[6].setLocation(240,100);
        items[7].setLocation(360,100);
        items[8].setLocation(10,200);
        items[4].addComponentListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Ahihi");
            }
        });
        canvas.setVisible(true);
    }

    }
}
