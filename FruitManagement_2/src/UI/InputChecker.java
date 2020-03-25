package UI;

import java.util.Scanner;

public class InputChecker
{
    private static final Scanner in = new Scanner(System.in);

    //check user input number limit

    /**
     * Check input's user in range(min,max)
     * it will re-prompt to user if their inout do not meet up the condition
     *
     * @param min
     * @param max
     * @return
     */
    public static int checkInputIntLimit(int min, int max)
    {
        //loop until user input correct
        while (true)
        {
            try
            {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max)
                    throw new NumberFormatException();
                return result;
            } catch (NumberFormatException e)
            {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Return the user input type <code>String</code> can trim the spaces in between it
     * if the value is not given it will re-prompt to the user and ask for the other value
     *
     * @return a non-empty String
     */
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
                return result;
        }
    }

    /**
     * Return the user input type <code>Int</code> can trim the spaces in between it
     * if the value is not given it will re-prompt to the user and ask for the other value
     *
     * @return a non-empty String
     */
    //check user input int
    public static int checkInputInt()
    {
        //loop until user input correct
        while (true)
        {
            try
            {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e)
            {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }


    /**
     * Return the user input type <code>Double</code> can trim the spaces in between it
     * if the value is not given it will re-prompt to the user and ask for the other value
     *
     * @return a non-empty String
     */
    //check user input double
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
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    /**
     * Return a <code>bool</code> value
     * Check user input either Y/y or N/n
     * if the user do not stroke any types of values mentions above. It will re-prompt and ask his/her for their other value
     *
     * @return true if user input like "Y", "y", "N,"n" otherwise return false
     */
    //check user input yes/ no
    public static boolean isYNInput()
    {
        System.out.print("Do you want to continue (Y/N)? ");
        //loop until user input correct
        while (true)
        {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y"))
                return true;
            //return false if user input n/N
            if (result.equalsIgnoreCase("N"))
                return false;
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
