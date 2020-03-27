package UI;

import Business.Management;
import Entity.Person;

import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        System.out.print("Enter number student: ");
        int n = InputChecker.checkInputInt();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++)
        {
            persons[i] = Hub.createPerson();
        }
        Management management = new Management(persons);
        management.sortBySalary();

        Arrays.stream(management.getWrappers()).forEach(k -> System.out.println(k.p));

    }
}