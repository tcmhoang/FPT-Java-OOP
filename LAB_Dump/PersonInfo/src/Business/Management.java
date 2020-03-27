package Business;

import Entity.Person;
import Entity.Wrapper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Management
{
    Person[] persons;
    Wrapper[] wrappers;

    public Management(Person[] persons)
    {
        this.persons = persons;
        wrappers = Arrays.stream(persons).map(n -> new Wrapper(n)).collect(Collectors.toList()).toArray(Wrapper[]::new);
    }

    public Wrapper[] getWrappers()
    {
        return wrappers;
    }

    private void swap(Wrapper person1, Wrapper person2)
    {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    //    public void sortBySalary()
//    {
//        int n = persons.length;
//
//        for (int i = 0; i < persons.length; i++)
//        {
//            wrappers[i] = new Wrapper(persons[i]);
//        }
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = i + 1; j < n; j++)
//            {
//                if (wrappers[i].p.salary > wrappers[j].p.salary)
//                {
//                    swap(wrappers[i], wrappers[j]);
//                }
//            }
//        }
//    }
    public void sortBySalary()
    {
        Arrays.sort(wrappers);
    }
}
