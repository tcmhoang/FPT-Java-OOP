import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TextEditor extends JFrame{
    private JPanel rootPanel;
    private JTextArea content;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    final JFileChooser fc = new JFileChooser();
    TextEditor()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setSize(300,400);
        add(rootPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        __init__menuBar();

    }

    private void __init__menuBar() {
        //Create the menu bar.
        menuBar = new JMenuBar();
        getFileMenu();
        getHelpMenu();
        setJMenuBar(menuBar);
    }

    private void getFileMenu()
    {
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
                "Menu control file states");
        menuBar.add(menu);
        //Open Menu-Item
        menuItem = new JMenuItem("Open",
                KeyEvent.VK_O);
        menuItem.setIcon(new ImageIcon("img/folder-open-solid_2.png"));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int returnVal = fc.showOpenDialog(TextEditor.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //This is where a real application would open the file.
                    System.out.println("Opening: " + file.getName() + ".\n");
                    try {
                        FileHandler fileHandler = new FileHandler(file.getCanonicalPath());
                        content.setText(fileHandler.getSource());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Open command cancelled by user.\n");
                }
            }
        });
        menu.add(menuItem);
        //Save Menu-Item
        menuItem = new JMenuItem("Save",
                KeyEvent.VK_S);
        menuItem.setIcon(new ImageIcon("img/save-solid_2.png"));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int returnVal = fc.showSaveDialog(TextEditor.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //This is where a real application would save the file.
                    System.out.println("Saving: " + file.getName() + ".\n");
                    try {
                        FileHandler.write(content.getText(),file.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Save command cancelled by user.\n");
                }
            }
        });
        menu.add(menuItem);
    }

    private void getHelpMenu()
    {
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menu.getAccessibleContext().setAccessibleDescription("Get informations");
        menuBar.add(menu);
        menuItem = new JMenuItem("About",KeyEvent.VK_A);
        menuItem.setIcon(new ImageIcon("img/question-circle-solid.png"));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.ALT_DOWN_MASK));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(TextEditor.this,
                        "Artlist-creator",
                        "Developer",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        menu.add(menuItem);
    }


}
