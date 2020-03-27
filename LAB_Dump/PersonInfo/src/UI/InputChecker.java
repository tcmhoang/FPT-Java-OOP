package UI;

import java.util.Scanner;

public class InputChecker
{
    private static final Scanner in = new Scanner(System.in);

    public static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be digit.");
            }
        }
    }

    public static double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.err.println("Salary is greater than zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("You must input digidt.");
                System.out.print("Please input salary: ");
            }
        }
    }


}
