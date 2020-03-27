package Entity;

import java.util.Comparator;

public class Wrapper implements Comparable<Wrapper>
{

    public Person p;

    public Wrapper(Person p)
    {
        this.p = p;
    }

    public double getSalary()
    {
        return p.salary;
    }
    @Override
    public int compareTo(Wrapper o)
    {
        return Comparator.comparingDouble(Wrapper::getSalary).compare(this,o);
    }

}
