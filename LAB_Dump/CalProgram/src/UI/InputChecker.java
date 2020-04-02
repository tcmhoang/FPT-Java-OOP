package UI;

import Entity.Matrix;

import java.util.Scanner;

public class InputChecker
{
    private static final Scanner in = new Scanner(System.in);

    static int checkIntLimit(int min, int max)
    {
        while (true)
        {
            try
            {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max)
                {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex)
            {
                System.err.println("Re-input");
            }
        }
    }

    private static int checkInputInt()
    {
        while (true)
        {
            try
            {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex)
            {
                System.err.println("Re-input");
            }
        }

    }

    static Matrix inputMatrix()
    {
        System.out.print("Enter Row Matrix: ");
        int row = InputChecker.checkInputInt();
        System.out.print("Enter Colum Matrix: ");
        int col = InputChecker.checkInputInt();
        Matrix res = new Matrix(row,col);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.print("Enter Matrix value " + "[" + i + "]" + "[" + j + "]:");
                res.setIn(i,j,checkInputInt());
            }
        }
        return res;
    }

}
