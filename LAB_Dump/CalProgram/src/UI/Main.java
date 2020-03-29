package UI;


import Business.MatricesCalc;
import Entity.Matrix;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Matrix 1: ");
        Matrix matrix1 = InputChecker.inputMatrix();

        System.out.println("Matrix 2: ");
        Matrix matrix2 = InputChecker.inputMatrix();

        while (true)
        {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = InputChecker.checkIntLimit(1, 4);
            switch (choice)
            {
                case 1:
                    System.out.println(MatricesCalc.displayOperation(matrix1, matrix2, "+"));
                    System.out.println(Arrays.deepToString(MatricesCalc.add(matrix1, matrix2).getContent()));
                    break;
                case 2:
                    System.out.println((MatricesCalc.displayOperation(matrix1, matrix2, "-")));
                    System.out.println(Arrays.deepToString(MatricesCalc.sub(matrix1, matrix2).getContent()));
                    break;
                case 3:
                    System.out.println(MatricesCalc.displayOperation(matrix1, matrix2, "*"));
                    System.out.println(Arrays.deepToString(MatricesCalc.mul(matrix1, matrix2).getContent()));
                    break;
                case 4:
                    return;
            }
        }
    }
}
