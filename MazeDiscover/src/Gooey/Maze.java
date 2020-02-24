package Gooey;

import Gooey.Model.Figure;
import Utils.FileHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Maze implements KeyListener {
    private final int WIDTH = 1449, HEIGHT = 748;
    private final String PART_OF_PATH = "O",
            TRIED = ".",
            OBSTACLE = "+",
            DEAD_END = "-",
            PLAYER = "S",
            COIN = "C",
            MACE = "M";
    private String MAZEFILE;
    private JLabel Player;
    private Figure figure;
    private int ROWS, COLUMNS, str_row, str_col, coin_col, totCoins;
    private List<List<JLabel>> tiles = new ArrayList<>();
    private JFrame canvas;
    private List<Integer> idxCoins;

    private ImageIcon coin, mace;

    public Maze(String mazeFileName) {
        __init__(mazeFileName);
    }

    private void __init__(String file) {
        readMaze(file);
        getMazeInfo();
        canvas = new JFrame("Maze Discovery");
        canvas.setResizable(false);
        config_canvas(canvas);
        addTiles(canvas);
        canvas.setVisible(true);
        showMaze(true);
        drawPlayer();
        canvas.addKeyListener(this);

    }

    public int getStr_row() {
        return str_row;
    }

    public int getStr_col() {
        return str_col;
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
        totCoins = 0;
        coin_col = 0;
        idxCoins = new ArrayList<>();
        FileHandler files = new FileHandler(path);
        MAZEFILE = path;
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
        try {
            coin = new ImageIcon(ImageIO.read(new File("assets/Coin.png")));
            mace = new ImageIcon(ImageIO.read(new File("assets/Mace.png")));
        } catch (IOException e) {
            e.printStackTrace();
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
        for (int i = 0; i < tiles.size(); i++) {
            List<JLabel> row = tiles.get(i);
            for (int j = 0; j < row.size(); j++) {
                JLabel tile = row.get(j);
                tile.setOpaque(true);
                if (tile.getText().equals(COIN)) {
                    totCoins++;
                }
                if (showWalls) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(70);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if (tile.getText().equals(OBSTACLE)) {
                        fillColor(tile, Color.GRAY);
                    } else {
                        fillColor(tile, Color.white);
                    }
                    if (tile.getText().equals(COIN)) {
                        tile.setIcon(coin);
                        idxCoins.add(i);
                        idxCoins.add(j);
                    }
                    if (tile.getText().equals(MACE)) {
                        tile.setIcon(mace);
                    }
                } else {
                    fillColor(tile, Color.WHITE);
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

    private boolean isEligibleLoc(int row, int col) {
        return !(row > ROWS - 1 || row < 0 || col > COLUMNS - 1 || col < 0);
    }

    private boolean isWall() {
        return tiles.get(str_row).get(str_col).getText().equals(OBSTACLE);
    }

    private boolean isMace() {
        return tiles.get(str_row).get(str_col).getText().equals(MACE);
    }

    private boolean isCoin() {
        return tiles.get(str_row).get(str_col).getText().equals(COIN);
    }

    private void dropBreadcrumb(Color color) {
        tiles.get(str_row).get(str_col).setBorder(BorderFactory.createLineBorder(color));
    }

    private void updatePos(int row, int col, String val) {
        if (isEligibleLoc(row, col)) {
            tiles.get(row).get(col).setText(!val.equals("") ? val : tiles.get(row).get(col).getText());
            //Animate
            String dir = checkChangedCoordinate(str_row, str_col, row, col);
            int temp_col = str_col, temp_row = str_row;
            str_col = col;
            str_row = row;
            tiles.get(temp_row).get(temp_col).setIcon(null);
            updatePlayer();
            figure.animate(Player, dir);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Color color;
        switch (val) {
            case PART_OF_PATH:
                color = Color.green;
                break;
            case OBSTACLE:
                color = Color.RED;
                break;
            case MACE:
                color = Color.MAGENTA;
                break;
            case COIN:
                color = Color.yellow;
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


    private boolean search(int startRow, int startCol) {
        if (isEligibleLoc(startRow, startCol)) {
            try {
                TimeUnit.MILLISECONDS.sleep(240);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updatePos(startRow, startCol, "");
            String standIn = tiles.get(startRow).get(startCol).getText();
            if (standIn.equals(OBSTACLE)) return false;
            if (standIn.equals(TRIED) || standIn.equals(DEAD_END)) return false;
        }
        if (isExit()) {
            updatePos(startRow, startCol, PART_OF_PATH);
            return true;
        }
        updatePos(startRow, startCol, TRIED);
        boolean found = search(startRow - 1, startCol) ||
                search(startRow + 1, startCol) ||
                search(startRow, startCol - 1) ||
                search(startRow, startCol + 1);

        if (found) {
            updatePos(startRow, startCol, PART_OF_PATH);
        } else {
            updatePos(startRow, startCol, DEAD_END);
        }
        return found;
    }

    public void recursiveSearch(int startRow, int startCol) {
        search(startRow, startCol);
        restoreCoins();
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
        boolean isHittedMace = false;
        int key = e.getKeyCode(), col = str_col, row = str_row,
                temp_col = str_col, temp_row = str_row;

        if (key == KeyEvent.VK_LEFT) {
            col--;
        } else if (key == KeyEvent.VK_RIGHT) {
            col++;
        } else if (key == KeyEvent.VK_UP) {
            row--;
        } else if (key == KeyEvent.VK_DOWN) {
            row++;
        }
        updatePos(row, col, "");
        dropBreadcrumb(Color.BLACK);
        if (isWall()) {
            dropBreadcrumb(Color.RED);
            updatePos(temp_row, temp_col, "");
            dropBreadcrumb(Color.BLACK);
        }
        if (isMace()) {
            dropBreadcrumb(Color.MAGENTA);
            tiles.get(str_row).get(str_col).setIcon(mace);
            updatePos(temp_row, temp_col, "");
            dropBreadcrumb(Color.BLACK);
            isHittedMace = true;
        }
        if (isCoin()) {
            updatePos(str_row, str_col, TRIED);
            dropBreadcrumb(Color.yellow);
            coin_col++;
        }
        if (isExit() && coin_col == totCoins) {
            JOptionPane.showMessageDialog(canvas, "You Win!!!");
            canvas.dispose();
        }
        if (isHittedMace) {
            Object[] options = {"Yes, please",
                    "No, thanks. I would rather die! :("};

            int n = JOptionPane.showOptionDialog(canvas,
                    "You Died. Would you like to play again ?",
                    "A Silly Question",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            canvas.dispose();
            if (n == 0) {
                tiles = new ArrayList<>();
                canvas = null;
                __init__(MAZEFILE);
            }
        }
    }

    private String checkChangedCoordinate(int old_row, int old_col, int str_r, int str_c) {
        if (Math.abs(old_col - str_c) == 1) {
            return str_c < old_col ? "RIGHT" : "LEFT";
        } else if (Math.abs(old_row - str_r) == 1) {
            return str_r > old_row ? "DOWN" : "UP";
        }
        return "";
    }

    private void restoreCoins() {
        for (int i = 0; i < idxCoins.size(); i += 2) {
            JLabel coinTile = tiles.get(idxCoins.get(i)).get(idxCoins.get(i + 1));
            coinTile.setText(COIN);
            coinTile.setIcon(coin);
            coinTile.setBorder(BorderFactory.createLineBorder(Color.yellow));
        }
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
