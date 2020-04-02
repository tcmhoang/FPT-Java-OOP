package Entity;


import java.util.Arrays;

public class Matrix
{
    private int[][] content;

    public Matrix(int[][] content)
    {
        this.content = content;
    }

    public int getLenRow()
    {
        return content.length;
    }

    public int getLenCol()
    {
        return content[0].length;
    }

    public int[][] getContent()
    {
        return content;
    }

    public boolean setIn(int idxRow, int idxCol, int val)
    {
        if (idxRow >= getLenRow() || idxCol >= getLenCol())
            return false;
        else
            content[idxRow][idxCol] = val;
        return true;
    }

    public boolean addIn(int idxRow, int idxCol, int val)
    {
        if (idxRow >= getLenRow() || idxCol >= getLenCol())
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
        if (idxRow >= getLenRow() || idxCol >= getLenCol())
            return null;
        else
            return content[idxRow][idxCol];
    }
}
