import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String myPath;
    private String mySource;

    /**
     * Create a <code>FileResource</code> object that opens a file whose name is passed as a
     * parameter.
     * <p>
     * The named file should be on the current class path to be found.
     *
     * @param filename the name of the file to be opened
     * @throws exception if the filename cannot be accessed
     */
    public FileHandler(String filename) {
        initRead(filename);
    }

    /**
     * Allow access to this opened file one word at a time, where words are separated by
     * white-space. This means any form of spaces, like tabs or newlines, can delimit words.
     *
     * @return an <code>Iterable</code> that will allow access to contents of opened file one word
     * at a time.
     */

    // Create from the name of a File
    private void initRead(String fname) {
        try {
            myPath = fname;
            FileReader is = new FileReader(fname);
            mySource = initFromStream(is);
        } catch (Exception e) {
            throw new RuntimeException("FileHandler: cannot access " + fname);
        }
    }

    private String initFromStream(FileReader stream) {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(stream);
            StringBuilder contents = new StringBuilder();
            String line = null;
            while ((line = buff.readLine()) != null) {
                contents.append(line).append("\n");
            }
            return contents.toString();
        } catch (Exception e) {
            throw new RuntimeException("FileResource: error encountered reading " + myPath, e);
        } finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            } catch (Exception e) {
                // should never happen
            }
        }
    }


    public Iterable<String> lines() {
        return new TextIterable(mySource, "\\n+");
    }

    public static void write(String content,String Path){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(Path);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            //should never happend unless with sudo dir
        }
    }

}