package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputChecker
{
    private static final Scanner in = new Scanner(System.in);

    private static final String PLAN_VALID = "^\\d{1,2}\\.[05]$";


    static int checkIntLimit(int min, int max)
    {
        while (true)
        {
            try
            {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max)
                    throw new NumberFormatException();
                return n;
            } catch (NumberFormatException ex)
            {
                System.err.println("Re-input");
            }
        }
    }

    static Date checkInputDate()
    {
        while (true)
        {
            try
            {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(false);
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date)))
                    return date;
                else
                    System.err.println("Re-input");
            } catch (NumberFormatException ex)
            {
                System.err.println("Re-input");
            } catch (ParseException ex)
            {
                System.err.println("Re-input");
            }
        }
    }

    static String checkInputString()
    {
        while (true)
        {
            String result = in.nextLine().trim();
            if (result.length() == 0)
                System.err.println("Not empty.");
            else
                return result;
        }
    }

    static int checkInputInt()
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

    static String checkInputTaskTypeId()
    {
        while (true)
        {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n)
            {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    static String checkInputPlan()
    {
        while (true)
        {
            String result = checkInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5)
                return result;
            else
                System.err.println("Re-input.");
        }
    }
}
