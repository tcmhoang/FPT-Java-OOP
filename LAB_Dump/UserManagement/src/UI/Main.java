package UI;

import Business.UsrDataManagement;
import Entity.Account;

import java.io.IOException;

public class Main
{

    public static void main(String[] args)
    {
        UsrDataManagement data = new UsrDataManagement();
        //loop until user want to exit
        while (true)
        {
            int choice = Hub.menu();
            switch (choice)
            {
                case 1:
                    //check file data exist or not
                    data.createIfNotExisted();
                    Account acc = Hub.createNewAccount();
                    while (!data.checkUsernameExist(acc.getUsername()))
                    {
                        System.err.println("Username exist.");
                        acc.setUsername(InputChecker.checkInputUsername());
                    }
                    data.addAccountData(acc);
                    break;
                case 2:
                    data.createIfNotExisted();
                    Account temp = Hub.createNewAccount();
                    //check username exist or not
                    if (!data.checkUsernameExist(temp.getUsername()))
                    {
                        try
                        {
                            if (!temp.getPassword().equalsIgnoreCase(data.getPasswordByUsername(temp.getPassword())))
                            {
                                System.err.println("Password incorrect.");
                            }
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        System.err.println("Login success.");
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}