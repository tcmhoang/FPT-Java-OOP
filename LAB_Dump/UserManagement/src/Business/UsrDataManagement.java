package Business;

import Entity.Account;

import java.io.*;

public class UsrDataManagement
{
    File file;

    public UsrDataManagement()
    {
        file = new File("Test/user.dat");
        createIfNotExisted();
    }

    //check file data exist or not
    public void createIfNotExisted()
    {
        File file = new File("Test/user.dat");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    //check username exist
    public boolean checkUsernameExist(String username)
    {
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0]))
                {
                    return false;
                }
            }
            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return true;
    }

    //write new account to data
    public void addAccountData(Account account)
    {
        String username = account.getUsername(), password = account.getPassword();
        createIfNotExisted();
        try
        {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    //get password by username
    public String getPasswordByUsername(String username) throws IOException

    {
        File file = new File("Test/user.dat");
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0]))
                {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } finally
        {
            return null;
        }
    }
}
