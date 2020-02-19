import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static JComponent[] items = {
            new JLabel("First"),//1
            new JLabel("Second"),//2
            new JTextField("integer 1"),//3
            new JTextField("integer 2"),//4
            new JButton("+"),//5
            new JButton("-"),//6
            new JButton("×"),//7
            new JButton("÷"),//8
            new JTextField("Result: ")//9
    };
    private static JButton add = (JButton) items[4],
            minus = (JButton) items[5],
            mul = (JButton) items[6],
            div = (JButton) items[7];
    private static JTextField p1 = (JTextField) items[2],
            p2 = (JTextField) items[3],
            p3 = (JTextField) items[8];

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        JFrame canvas = new JFrame("My First Swing");
        canvas.setLayout(null);
        canvas.setSize(450, 270);
        for (JComponent item : items) {
            canvas.add(item);
            if (item instanceof JLabel) {
                item.setSize(50, 30);
            } else if (item instanceof JTextField) {
                item.setSize(90, 30);
            } else {
                item.setSize(80, 80);
            }
        }
        items[0].setLocation(10, 10);
        items[1].setLocation(10, 40);
        items[2].setLocation(80, 10);
        items[3].setLocation(80, 40);
        items[4].setLocation(10, 100);
        items[5].setLocation(120, 100);
        items[6].setLocation(240, 100);
        items[7].setLocation(360, 100);
        items[8].setLocation(10, 200);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cal("+");
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cal("-");
            }
        });

        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cal("×");
            }
        });

        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cal("÷");
            }
        });

        canvas.setVisible(true);
    }

    static void cal(String operator) {
        int num1, num2;
        int tot = 0;
        num1 = Integer.parseInt(p1.getText());
        num2 = Integer.parseInt(p2.getText());
        switch (operator) {
            case "+":
                tot = num1 + num2;
                break;
            case "-":
                tot = num1 - num2;
                break;
            case "×":
                tot = num1 * num2;
                break;
            case "÷":
                tot = num1 / num2;
                break;
        }
        p3.setText(String.valueOf(tot));
    }
}
