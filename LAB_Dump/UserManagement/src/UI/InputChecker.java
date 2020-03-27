package UI;

import java.util.Scanner;

public class InputChecker
{
    private final static Scanner in = new Scanner(System.in);
    private final static String VALID_USERNAME = "^\\S{5}\\S*$";
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$";

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

    //check user input yes/ no
    public static boolean checkInputYN()
    {
        //loop until user input correct
        while (true)
        {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y"))
            {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N"))
            {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //allow user input username
    public static String checkInputUsername()
    {
        System.out.print("Enter username: ");
        //loop until user input correct
        while (true)
        {
            String result = checkInputString();
            if (result.matches(VALID_USERNAME))
            {
                return result;
            }
            System.err.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }


    //allow user input password
    public static String checkInputPassword()
    {
        System.out.print("Enter password: ");
        //loop until user input correct
        while (true)
        {
            String result = checkInputString();
            if (result.matches(VALID_PASSWORD))
            {
                return result;
            }
            System.err.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter again: ");
        }
    }
}
