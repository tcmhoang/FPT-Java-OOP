package UI;

import Entity.CarData;
import Entity.ExceptionCar;

import java.util.Arrays;
import java.util.Scanner;

public class InputChecker
{
    private static final Scanner in = new Scanner(System.in);

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

    public static int checkPrice()
    {
        while (true)
        {
            try
            {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0)
                    System.err.println("Price greater than zero");
                return result;
            } catch (NumberFormatException ex)
            {
                System.err.println("Price is digit");
            }

        }
    }

    static boolean wannaContinue()
    {
        while (true)
        {
            String result = checkInputString();
            if (result.length() == 1)
            {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y')
                {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N')
                {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }

    public static boolean checkCar(CarData carData, String colorName, int price,
                                   String today) throws ExceptionCar
    {
        boolean check;
        String[] listColor = carData.getColor();
        int[] listPrice = carData.getPrice();
        String[] availDays = carData.getAvailableDay();

        Main.Color color = Main.Color.getColor(colorName);
        Main.Day day = Main.Day.getDay(today);


        if (color != Main.Color.NO_COLOR)
            check = Arrays.stream(listColor).anyMatch(c -> Main.Color.getColor(c) == color);
        else
            check = true;

        if (check == false)
        {
            System.err.println("Color Car does not exist");
            return false;
        }

        check = false;

        if (Arrays.stream(listPrice).anyMatch(p -> price == p - 100))
            check = true;

        if (check == false)
        {
            System.err.println("Price Car does not exist");
            return false;
        }


        check = false;

        if (Arrays.stream(availDays).anyMatch(d -> day == Main.Day.getDay(d)))
            check = true;

        if (check == false)
        {
            System.err.println("Car can't sell today");
            return false;
        }
        return true;
    }

}
