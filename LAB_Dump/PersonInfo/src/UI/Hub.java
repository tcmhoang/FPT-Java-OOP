package UI;

import Entity.Person;

import static UI.InputChecker.checkInputSalary;
import static UI.InputChecker.checkInputString;

public class Hub
{
    public static Person createPerson() {
        System.out.println("Input Information of Entity.Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Person(name, address, salary);
    }
}
