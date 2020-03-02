import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camer
 */
public class TextEditor_NB_Edition extends javax.swing.JFrame {

    /**
     * Creates new form TextEditor_NB_Edition
     */
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private final JFileChooser fc = new JFileChooser();
    
    public TextEditor_NB_Edition() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setSize(300,400);
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
                int returnVal = fc.showOpenDialog(TextEditor_NB_Edition.this);
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
                int returnVal = fc.showSaveDialog(TextEditor_NB_Edition.this);
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
                JOptionPane.showMessageDialog(TextEditor_NB_Edition.this,
                        "Artlist-creator",
                        "Developer",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        menu.add(menuItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setColumns(20);
        content.setRows(5);
        jScrollPane1.setViewportView(content);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor_NB_Edition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor_NB_Edition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor_NB_Edition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor_NB_Edition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor_NB_Edition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea content;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
