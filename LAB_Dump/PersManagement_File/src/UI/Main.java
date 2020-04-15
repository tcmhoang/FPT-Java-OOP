package UI;

import Business.FileManagement;
import Business.PersonFileManagement;
import Entity.Person;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter data path: ");
        String source = InputChecker.checkInputString();
        PersonFileManagement management = new PersonFileManagement(source);
        //loop until user want to exit
        while (true)
        {
            int choice = Hub.menu();
            switch (choice)
            {
                case 1:
                    double money = InputChecker.checkInputMoney();

                    List<Person> data = management.getData();

                    System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");

                    for (Person person : data)
                    {
                        if (person.getMoney() >= money)
                            System.out.printf("%-20s%-20s%-20.1f\n", person.getName(),
                                    person.getAddress(), person.getMoney());
                    }
                    Collections.sort(data);

                    System.out.println("Max: " + data.get(0).getName());
                    System.out.println("Min: " + data.get(data.size() - 1).getName());

                    break;
                case 2:
                    String pathFileInput = InputChecker.checkInputString();
                    String pathFileOutput = InputChecker.checkInputString();
                    String content = FileManagement.getUpdates(pathFileInput);
                    System.out.println(content);
                    FileManagement.writeNewContent(pathFileOutput, content);
                    System.err.println("Write successful");
                    break;
                case 3:
                    return;
            }
        }
    }
}