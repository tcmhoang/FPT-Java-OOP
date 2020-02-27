import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeScreen extends JFrame {
    private JPanel Welcome;
    private JPanel l_panel;
    private JButton backButton;
    private JButton nextButton;
    private JPanel sub_panel;
    private JLabel title1;
    private JLabel title2;
    private JLabel title3;

    private short currentSeg = 0;

    public WelcomeScreen() {
        setTitle("Welcome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(490,193);
        setResizable(false);
        this.add(Welcome);
        sub_panel.setLayout(new CardLayout());
        sub_panel.add(0+"",new Profile());
        sub_panel.add(1+"",new Edu());
        sub_panel.add(2+"",new Prof());
        title1.setOpaque(true);
        title2.setOpaque(true);
        title3.setOpaque(true);
        displayQuestion("0");

        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentSeg ++;
                getRoundIdx();
                displayQuestion(currentSeg+"");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentSeg--;
                getRoundIdx();
                displayQuestion(currentSeg+"");
            }
        });


    }
    private void getRoundIdx()
    {
        if(currentSeg >2)
        {
            currentSeg = 0;
        }
        if(currentSeg < 0)
        {
            currentSeg = 3;
        }
    }
    public void displayQuestion(String idx) {
        CardLayout layout = (CardLayout) sub_panel.getLayout();
        layout.show(sub_panel, idx);
        switch (idx)
        {
            case "0":
                title1.setForeground(Color.LIGHT_GRAY);
                title2.setForeground(null);
                title3.setForeground(null);
                break;
            case "1":
                title1.setForeground(Color.darkGray);
                title2.setForeground(Color.lightGray);
                title3.setForeground(null);
                break;
            case "2":
                title1.setForeground(Color.darkGray);
                title2.setForeground(Color.darkGray);
                title3.setForeground(Color.lightGray);
                break;
        }
    }
}
