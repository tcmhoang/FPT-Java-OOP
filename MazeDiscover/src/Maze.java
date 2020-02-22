import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Maze {
    private final int WIDTH = 700, HEIGHT = 350;
    private final String PART_OF_PATH = "O",
    TRIED = ".",
    OBSTACLE = "+",
    DEAD_END = "-",
    PLAYER = "S";

    private int ROWS, COLUMNS, str_row, str_col;
    private List<List<JLabel>> tiles = new ArrayList<>();

    Maze(String mazeFileName) {
        __init__(mazeFileName);
    }

    private void __init__(String file) {
        readMaze(file);
        getMazeInfo();
        JFrame canvas = new JFrame("Maze Discovery");
        config_canvas(canvas);
        addTiles(canvas);
        canvas.setVisible(true);
        showMaze(true);
        drawPlayer();

    }


    private void getMazeInfo()
    {
        ROWS = tiles.size();
        COLUMNS = tiles.get(0).size();
    }

    private void config_canvas(JFrame canvas)
    {
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setSize(WIDTH, HEIGHT);
        canvas.setLayout(new GridLayout(ROWS,COLUMNS));
        canvas.setIconImage(new ImageIcon("assets/android-icon-192x192.png").getImage());
    }

    private void readMaze(String path)
    {
        FileHandler files = new FileHandler("assets/Maze");
        int row_count = 0;
        for(String line : files.lines())
        {
            String[] rowText  = line.split("");
            List<JLabel> row = new ArrayList<>();
            int col_count = 0;
            for(String elements : rowText)
            {
                if(elements.equals(PLAYER))
                {
                    str_col = col_count;
                    str_row = row_count;
                }
                col_count ++;
                row.add(new JLabel(elements));
            }
            row_count ++;
            tiles.add(row);
        }
    }
    private void addTiles(JFrame canvas)
    {
        for(List<JLabel> row : tiles)
        {
            for(JLabel tile : row)
            {
                canvas.add((tile));
            }
        }
    }
    private void fillColor(JComponent component, Color color)
    {
        component.setBackground(color);
        component.setForeground(color);
    }

    private void showMaze(boolean showWalls)
    {
        for(List<JLabel> row : tiles)
        {
            for(JLabel tile : row)
            {
                if(showWalls)
                {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(70);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    tile.setOpaque(true);
                    if(tile.getText().equals(OBSTACLE))
                    {
                        fillColor(tile,Color.GRAY);
                    }
                    else {
                        fillColor(tile,Color.white);
                    }
                } else
                {
                    fillColor(tile,Color.lightGray);
                }

            }
        }
    }

    private void drawPlayer()
    {
        JLabel Player =  tiles.get(str_row).get(str_col);
        Figure figure = new Figure("assets/player.png",70);
        for(int i = 0 ; i < 10; i ++)
        {
            figure.animate(Player);
        }
    }

}
