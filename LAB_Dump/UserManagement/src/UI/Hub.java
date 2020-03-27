package UI;

import Entity.Account;


public class Hub
{

    //display menu
    public static int menu()
    {
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = InputChecker.checkInputIntLimit(1, 3);
        return choice;
    }

    //create a new account
    public static Account createNewAccount()
    {
        String username = InputChecker.checkInputUsername();
        String password = InputChecker.checkInputPassword();
        //check username exist or not
        return new Account(username, password);
    }


}
