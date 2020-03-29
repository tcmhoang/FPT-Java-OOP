package Business;


import Entity.Matrix;

import java.util.Arrays;

public class MatricesCalc
{

    public static String displayOperation(Matrix matrix1, Matrix matrix2, String operator)
    {
        return Arrays.deepToString(matrix1.getContent()) + "\n" + operator + "\n" + Arrays.deepToString(matrix2.getContent()) + "\n=";
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2)
    {
        if (matrix1.getLenRow() == matrix2.getLenRow() && matrix2.getLenCol() == matrix1.getLenCol())
        {
            int row = matrix1.getLenRow();
            int col = matrix1.getLenCol();
            Matrix res = new Matrix(new int[row][col]);
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    int val = matrix1.get(i, j) + matrix2.get(i, j);
                    res.setIn(i, j, val);
                }
            }
            return res;
        }
        return null;
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2)
    {
        if (matrix1.getLenRow() == matrix2.getLenRow() && matrix2.getLenCol() == matrix1.getLenCol())
        {
            int row = matrix1.getLenRow();
            int col = matrix1.getLenCol();
            Matrix res = new Matrix(new int[row][col]);
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    int val = matrix1.get(i, j) - matrix2.get(i, j);
                    res.setIn(i, j, val);
                }
            }
            return res;
        }
        return null;
    }

    public static Matrix mul(Matrix matrix1, Matrix matrix2)
    {
        int row1 = matrix1.getLenRow();
        int col1 = matrix1.getLenCol();
        int row2 = matrix2.getLenRow();
        int col2 = matrix2.getLenCol();
        if (col1 != row2)
        {
            return null;
        }
        Matrix res = new Matrix(new int[row1][col2]);

        res.zeros();

        for (int i = 0; i < row1; i++)
        {
            for (int j = 0; j < col2; j++)
            {
                for (int k = 0; k < col1; k++)
                {
                    int val = matrix1.get(i, k) * matrix2.get(k, j);
                    res.addIn(i, j, val);
                }
            }
        }
        return res;
    }
}
