package UI;

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

    //check user input int
    public static int checkInputInt()
    {
        //loop until user input correct
        while (true)
        {
            try
            {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e)
            {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

}
