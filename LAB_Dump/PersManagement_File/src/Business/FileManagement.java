package Business;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileManagement
{
    //get new content
    public static String getUpdates(String pathFileInput) throws FileNotFoundException
    {
        Set<String> newContent = new HashSet<>();

        File file = new File(pathFileInput);

        Scanner input = new Scanner(file);
        int count = 0;
        while (input.hasNext())
        {
            String word = input.next();
            newContent.add(word + " ");
        }

        return String.join("", newContent);
    }


    //write new content to file
    public static void writeNewContent(String pathFileOutput, String content) throws WriteAbortedException
    {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);

        try
        {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

            bufferWriter.write(content);
            bufferWriter.close();

        } catch (IOException ex)
        {
            throw new WriteAbortedException("Can’t write file" ,ex);
        } finally
        {
            try
            {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
