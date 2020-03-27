package GUI;

import java.util.Scanner;

public class InputChecker
{
    private final static Scanner in = new Scanner(System.in);

    //check user input number limit
    public static int checkInputIntLimit(int min, int max)
    {
        //loop until user input correct
        while (true)
        {
            try
            {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max)
                {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e)
            {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString()
    {
        //loop until user input correct
        while (true)
        {
            String result = in.nextLine().trim();
            if (result.isEmpty())
            {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            }
            else
            {
                return result;
            }
        }
    }

    //check user input double limit
    public static double checkInputDouble()
    {
        //loop until user input correct
        while (true)
        {
            try
            {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e)
            {
                System.err.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }

}
