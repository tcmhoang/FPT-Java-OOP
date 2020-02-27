import javax.swing.*;

public class Profile extends JPanel{
    private JPanel root;
    private JTextField textField1;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField textField2;
    private ButtonGroup buttonGroup = new ButtonGroup();
    public Profile()
    {
        this.add(root);
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);
    }
}
