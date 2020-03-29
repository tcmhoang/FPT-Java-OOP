package Entity;


import java.util.Arrays;

public class Matrix
{
    private int[][] content;
    private int row, col; //

    public Matrix(int[][] content)
    {
        this.content = content;
        col = content[0].length;
    }

    public int getLenRow()
    {
        return row;
    }

    public int getLenCol()
    {
        return col;
    }

    public int[][] getContent()
    {
        return content;
    }

    public boolean setIn(int idxRow, int idxCol, int val)
    {
        if (idxRow >= row || idxCol >= col)
            return false;
        else
            content[idxRow][idxCol] = val;
        return true;
    }

    public boolean addIn(int idxRow, int idxCol, int val)
    {
        if (idxRow >= row || idxCol >= col)
            return false;
        else
            content[idxRow][idxCol] += val;
        return true;
    }

    public void zeros()
    {
        Arrays.stream(content).forEach(row -> Arrays.fill(row, 0));
    }

    public Integer get(int idxRow, int idxCol)
    {
        if (idxRow >= row || idxCol >= col)
            return null;
        else
            return content[idxRow][idxCol];
    }
}
