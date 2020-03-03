package UI;

import java.util.Scanner;

public class InputChecker {

    private final static Scanner in = new Scanner(System.in);

    //check user input number limit

    /**
     * Return the user's input type <code>int</code> in range(min.max)
     * if the value is out of given range it will re-prompt and asks user for an other value
     * @param min the minimum value
     * @param max the maximum value
     * @return a valid value
     */
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Return the user input type <code>String</code> can trim the spaces in between it
     * if the value is not given it will re-prompt to the user and ask for the other value
     * @return a non-empty String
     */
    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Return a <code>bool</code> value
     * Check user input either Y/y or N/n
     * if the user do not stroke any types of values mentions above. It will re-prompt and ask his/her for their other value
     * @return true if user input like "Y", "y", "N,"n" otherwise return false
     */
    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }



    /**
     * Return a <code>bool</code> value
     * Check user input either Y/y or N/n
     * if the user do not stroke any types of values mentions above. It will re-prompt and ask his/her for their other value
     * @return true if user input like "Y", "y", "N,"n" otherwise return false
     */
    //check user input u / d
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }


    /**
     * Return a <code>String</code> value
     * Check user input if the course they enter is currently available
     * if the user do not type in an valid course. It will re-prompt and ask his/her for their other value
     * @return true if user input like "java", ".net", "c/c++" <b>Case in-sensitive</b> otherwise return false
     */
    //check user input course
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
}