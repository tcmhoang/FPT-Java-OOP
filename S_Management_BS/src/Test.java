import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Test/ProductData");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null)
        {
            System.out.println(Arrays.toString(line.split("\\s+[|]\\s+")));
            Arrays.stream(line.split("\\s+[|]\\s+")).forEach(s -> System.out.println(s.length()));
        }
    }
}
