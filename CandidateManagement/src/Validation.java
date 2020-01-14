import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;


public class Validation {

    private final static Scanner input = new Scanner(System.in);
    private static final String PHONE_VALID = "^\\d{10,}";
    private static final String EMAIL_VALID
            = "^[A-Za-z][A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine().trim());
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

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = input.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("EMPTY INPUT !!! ");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input y/Y or n/N
    public static boolean validateOption() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Accept value Y or N.");
            System.out.print("Enter again: ");
        }
    }

    //check phone is number with minimum 10 characters
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone has minimum 10 numbers");
                System.out.print("Enter again: ");
            }
        }
    }

    //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public static String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email in format <account name>@<domain> and start with a character");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input graduation rank
    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
            } else {
                System.err.println("ACCEPT VALUE: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //check id exist or not
    public static boolean checkIdExist(HashMap<Integer, ArrayList<Candidate>> candidateDict, String id) {
        for (ArrayList<Candidate> candidateList : candidateDict.values()) {
            for (Candidate candidate : candidateList) {
                if (candidate.getId().equalsIgnoreCase(id)) {
                    System.err.println("ID EXISTED.");
                    return false;
                }
            }
        }
        return true;
    }

    //check experience must be smaller then age
    public static int checkExperiences(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience years must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
}