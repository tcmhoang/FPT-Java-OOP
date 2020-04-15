package Business;

import Entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileManagement
{
    String source;
    List<Person> data;

    public PersonFileManagement(String source) throws IOException
    {
        this.source = source;
        initRead();
    }

    private void initRead() throws IOException
    {
        //get list person by path file
        data = new ArrayList<>();
        File file = new File(source);
        //check file exist or not and path must be file
        if (!file.exists() || !file.isFile())
        {
            throw new FileNotFoundException("Path doesn't exist");
        }

        FileReader fileReader = new FileReader(file);

        BufferedReader bufferReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferReader.readLine()) != null)
        {
            String[] infoPerson = line.split(";");
            data.add(new Person(infoPerson[0], infoPerson[1],
                    convertToSal(infoPerson[2])));

        }
    }

    //get salary
    private double convertToSal(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        } finally {
            return salaryResult;
        }
    }


    //allow user find person info
    public List<Person> getData()
    {
        return data;
    }
}
