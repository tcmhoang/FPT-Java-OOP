import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private double res = 0;
    private String intermittent = "0", operator = null;

    private JButton[] buttons = new JButton[16];
    private JLabel display = new JLabel(intermittent);
    private final int WIDTH = 350, HEIGHT = 450, BUTTON_WIDTH = (int) (WIDTH * 0.25), BOTTOM = HEIGHT - (int) (BUTTON_WIDTH * 1.35);

    public Calculator() {
        __init__();
    }

    private void __init__() {
        //Set Canvas Properties
        JFrame canvas = new JFrame("Simple Swing Calculator");
        canvas.setLayout(null);
        canvas.setSize(WIDTH, HEIGHT);
        canvas.setIconImage(new ImageIcon("data/favicon-32x32.png").getImage());
        canvas.setBackground(Color.black);

        //Populate numeric buttons array (0->9) and set them colors
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setBackground(new Color(216, 217, 219));
        }

        //Populate remain buttons with operator
        buttons[10] = new JButton(".");
        buttons[11] = new JButton("=");
        buttons[12] = new JButton("+");
        buttons[13] = new JButton("-");
        buttons[14] = new JButton("×");
        buttons[15] = new JButton("÷");

        //Set them colors
        for (int i = 10; i < 16; i++) {
            if (i == 10 || i == 11) {
                buttons[i].setBackground(new Color(216, 217, 219));
                continue;
            }
            buttons[i].setBackground(new Color(223, 151, 76));
        }

        //Set all button with larger font's size, button's size and add them to canvas
        Font buttonFont = new Font(buttons[0].getFont().getName(), buttons[0].getFont().getStyle(), 20);
        for (JButton button : buttons) {
            canvas.add(button);
            button.setSize(BUTTON_WIDTH, BUTTON_WIDTH);
            button.setFont(buttonFont);
        }

        setLocationBButtons();

        //Add display(JLabel) to canvas, set size, location , font
        canvas.add(display);
        display.setSize(WIDTH, (int) (0.165 * HEIGHT));
        display.setLocation(0, 0);
//        display.setBorder(BorderFactory.createLineBorder(Color.black));
        display.setFont(new Font(display.getFont().getName(), display.getFont().getStyle(), 30));


        //Align text in display to the right
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //Add buttons to events listener
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
        canvas.setVisible(true);

    }

    /**
     * The function handle events while clicking buttons
     *
     * @param value Value inside the buttons
     */
    private void __proc__(String value) {
        if (Character.isDigit(value.charAt(0))) {
            handleNumbers(value);
        } else {
            handleSymbol(value);
        }
        setDisplay();
    }


    /**
     * Display buffer number in JLabel-Display in calculator
     */
    private void setDisplay() {
        reformatBuffer();
        display.setText(intermittent);
    }

    /**
     * called by setDisplay func
     * Formatted buffer when it has zeros decimal behind it
     */
    private void reformatBuffer() {
        int idx = intermittent.indexOf(".");
        if (idx == -1 || intermittent.length() - idx == 1) return;
        int lastIdxOfZero = -1;
        char[] bufferArray = intermittent.toCharArray();
        for (int i = intermittent.length() - 1; i > idx; i--) {
            if (bufferArray[i] == '0') {
                lastIdxOfZero = i;
            }
        }
        intermittent = lastIdxOfZero != -1 ? intermittent.substring(0, lastIdxOfZero - 1) : intermittent;
    }

    /**
     * called by __proc__
     * Concat numbers and display to screen
     *
     * @param number value come from numeric buttons
     */
    private void handleNumbers(String number) {
        if (!intermittent.equals("0")) {
            intermittent += number;
        } else {
            if (!number.equals("0")) {
                intermittent = number;
            }
        }
    }

    /**
     * called by __proc__
     * Do math to the numbers which typed in
     *
     * @param symbol value come from operator buttons
     */
    private void handleSymbol(String symbol) {
        switch (symbol) {
            case ".":
                if (!hasDot(intermittent)) {
                    intermittent += ".";
                }
                break;
            case "=":
                if (operator != null) {
                    intermittent = intermittent.equals("") ? "0" : intermittent;
                    //Max 4 decimals
                    intermittent = String.format("%.4f", mathUp());
                    operator = null;
                    res = 0;
                }
                break;
            default:
                //Operator is null => res = 0
                if (!intermittent.equals("")) {
                    res = operator == null ? Double.parseDouble(intermittent) : mathUp();
                    intermittent = "";
                    operator = symbol;
                }
        }
    }

    /**
     * Called by handleSymbol func
     * Do math to buffer and saved result
     *
     * @return result from operation
     */
    private Double mathUp() {
        if (operator.equals("+")) {
            return Double.parseDouble(intermittent) + res;
        } else if (operator.equals("-")) {
            return Double.parseDouble(intermittent) - res;
        } else if (operator.equals("×")) {
            return Double.parseDouble(intermittent) * res;
        } else {
            return Double.parseDouble(intermittent) / res;
        }
    }

    /**
     * Called by handleSymbol func
     * Check if buffer has more than 1 dot
     *
     * @param buffer which is displayed on the display-JLabel
     * @return true if has <= 1 dot false otherwise.
     */
    private boolean hasDot(String buffer) {
        for (char c : buffer.toCharArray()) {
            if (c == '.') {
                return true;
            }
        }
        return false;
    }

    private void setLocationBButtons() {
        //Set location for buttons
        buttons[0].setLocation(0, BOTTOM);
        buttons[3].setLocation(0, BOTTOM - BUTTON_WIDTH);
        buttons[6].setLocation(0, BOTTOM - BUTTON_WIDTH * 2);
        buttons[9].setLocation(0, BOTTOM - BUTTON_WIDTH * 3);

        buttons[10].setLocation(BUTTON_WIDTH, BOTTOM);
        buttons[2].setLocation(BUTTON_WIDTH, BOTTOM - BUTTON_WIDTH);
        buttons[5].setLocation(BUTTON_WIDTH, BOTTOM - BUTTON_WIDTH * 2);
        buttons[8].setLocation(BUTTON_WIDTH, BOTTOM - BUTTON_WIDTH * 3);

        buttons[11].setLocation(BUTTON_WIDTH * 2, BOTTOM);
        buttons[1].setLocation(BUTTON_WIDTH * 2, BOTTOM - BUTTON_WIDTH);
        buttons[4].setLocation(BUTTON_WIDTH * 2, BOTTOM - BUTTON_WIDTH * 2);
        buttons[7].setLocation(BUTTON_WIDTH * 2, BOTTOM - BUTTON_WIDTH * 3);

        buttons[12].setLocation(BUTTON_WIDTH * 3, BOTTOM);
        buttons[13].setLocation(BUTTON_WIDTH * 3, BOTTOM - BUTTON_WIDTH);
        buttons[14].setLocation(BUTTON_WIDTH * 3, BOTTOM - BUTTON_WIDTH * 2);
        buttons[15].setLocation(BUTTON_WIDTH * 3, BOTTOM - BUTTON_WIDTH * 3);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JComponent event = (JComponent) actionEvent.getSource();
        if (event instanceof JButton) {
            //Sent event's text context to __proc__ func
            __proc__(((JButton) event).getText());
        }
    }
}
