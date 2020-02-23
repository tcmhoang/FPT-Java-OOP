import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Maze implements KeyListener {
    private final int WIDTH = 1449, HEIGHT = 748;
    private final String PART_OF_PATH = "O",
            TRIED = ".",
            OBSTACLE = "+",
            DEAD_END = "-",
            PLAYER = "S";
    private JLabel Player;
    private Figure figure;
    private int ROWS, COLUMNS, str_row, str_col;
    private List<List<JLabel>> tiles = new ArrayList<>();

    Maze(String mazeFileName) {
        __init__(mazeFileName);
    }

    private void __init__(String file) {
        readMaze(file);
        getMazeInfo();
        JFrame canvas = new JFrame("Maze Discovery");
        canvas.setResizable(false);
        config_canvas(canvas);
        addTiles(canvas);
        canvas.setVisible(true);
        showMaze(true);
        drawPlayer();
        canvas.addKeyListener(this);

    }


    private void getMazeInfo() {
        ROWS = tiles.size();
        COLUMNS = tiles.get(0).size();
    }

    private void config_canvas(JFrame canvas) {
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setSize(WIDTH, HEIGHT);
        canvas.setLayout(new GridLayout(ROWS, COLUMNS, 0, 0));
        canvas.setIconImage(new ImageIcon("assets/android-icon-192x192.png").getImage());
    }

    private void readMaze(String path) {
        FileHandler files = new FileHandler("assets/Maze");
        int row_count = 0;
        for (String line : files.lines()) {
            String[] rowText = line.split("");
            List<JLabel> row = new ArrayList<>();
            int col_count = 0;
            for (String elements : rowText) {
                if (elements.equals(PLAYER)) {
                    str_col = col_count;
                    str_row = row_count;
                }
                col_count++;
                row.add(new JLabel(elements));
            }
            row_count++;
            tiles.add(row);
        }
    }

    private void addTiles(JFrame canvas) {
        for (List<JLabel> row : tiles) {
            for (JLabel tile : row) {
                canvas.add((tile));
            }
        }
    }

    private void fillColor(JComponent component, Color color) {
        component.setBackground(color);
        component.setForeground(color);
    }

    private void showMaze(boolean showWalls) {
        for (List<JLabel> row : tiles) {
            for (JLabel tile : row) {
                if (showWalls) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(70);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    tile.setOpaque(true);
                    if (tile.getText().equals(OBSTACLE)) {
                        fillColor(tile, Color.GRAY);
                    } else {
                        fillColor(tile, Color.white);
                    }
                } else {
                    fillColor(tile, Color.lightGray);
                }

            }
        }
    }

    private void updatePlayer() {
        Player = tiles.get(str_row).get(str_col);
    }

    private void drawPlayer() {
        updatePlayer();
        figure = new Figure("assets/player.png", 70);
        for (int i = 0; i < 20; i++) {
            figure.animate(Player, "DOWN");
            try {
                TimeUnit.MILLISECONDS.sleep(240);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move(int old_row, int old_col) {
        if (str_row > ROWS - 1 || str_row < 0 || str_col > COLUMNS - 1 || str_col < 0) {
            str_row = old_row;
            str_col = old_col;
        }
    }

    private void move(int old_row, int old_col, String val) {
        if (str_row > ROWS - 1 || str_row < 0 || str_col > COLUMNS - 1 || str_col < 0) {
            str_row = old_row;
            str_col = old_col;
        }
        tiles.get(str_row).get(str_col).setText(val);
    }

    private boolean isWall() {
        return tiles.get(str_row).get(str_col).getText().equals(OBSTACLE);
    }

    private void dropBreadcrumb(Color color) {
        tiles.get(str_row).get(str_col).setBorder(BorderFactory.createLineBorder(color));
    }

    private void updatePos(int row, int col, String val) {
        move(row, col, val);
        Color color;
        switch (val) {
            case PART_OF_PATH:
                color = Color.green;
                break;
            case OBSTACLE:
                color = Color.RED;
                break;
            case TRIED:
                color = Color.BLACK;
                break;
            case DEAD_END:
                color = Color.red;
                break;
            default:
                color = null;
                break;
        }
        if (color != null) {
            dropBreadcrumb(color);
        }
    }

    private boolean isExit() {
        return str_row == 0 || str_row == ROWS - 1 || str_col == 0 || str_col == COLUMNS - 1;
    }

    public  boolean search()
    {
        String standIn = tiles.get(str_row).get(str_col).getText();
        if(standIn.equals(OBSTACLE)) return false;
        if(standIn.equals(TRIED) || standIn.equals(DEAD_END)) return false;
        if(isExit()) return true;
        
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            System.out.println("LEFT TYPED");
        }

        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT TYPED");
        }

        if (key == KeyEvent.VK_UP) {
            System.out.println("UP TYPED");
        }

        if (key == KeyEvent.VK_DOWN) {
            System.out.println("DOWN TYPED");
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode(), old_col = str_col, old_row = str_row;

        if (key == KeyEvent.VK_LEFT) {
            str_col--;
        } else if (key == KeyEvent.VK_RIGHT) {
            str_col++;
        } else if (key == KeyEvent.VK_UP) {
            str_row--;
        } else if (key == KeyEvent.VK_DOWN) {
            str_row++;
        }
        String dir = checkChangedCoordinate(old_row, old_col);
        move(old_row, old_col);
        tiles.get(old_row).get(old_col).setIcon(null);
        updatePlayer();
        figure.animate(Player, dir);
        updatePos(str_row, str_col, tiles.get(str_row).get(str_col).getText());
        if(isWall())
        {
            tiles.get(str_row).get(str_col).setIcon(null);
            str_col = old_col;
            str_row = old_row;
            updatePlayer();
            figure.animate(Player,dir);
        }
    }

    private String checkChangedCoordinate(int old_row, int old_col) {
        if (Math.abs(old_col - str_col) == 1) {
            return str_col < old_col ? "RIGHT" : "LEFT";
        } else if (Math.abs(old_row - str_row) == 1) {
            return str_row > old_row ? "DOWN" : "UP";
        }
        return null;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("LEFT RELEASED");
        }

        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT RELEASED");
        }

        if (key == KeyEvent.VK_UP) {
            System.out.println("UP RELEASED");
        }

        if (key == KeyEvent.VK_DOWN) {
            System.out.println("DOWN RELEASED");
        }
    }

}
