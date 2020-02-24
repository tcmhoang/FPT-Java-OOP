import Gooey.Maze;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze("assets/Maze");
        maze.recursiveSearch(maze.getStr_row(),maze.getStr_col());
    }
}
