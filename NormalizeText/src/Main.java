import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        StringBuilder output = new StringBuilder();
        FileHandler File = new FileHandler("test/test");
        for (String word : File.lines()) {
            Normalization heh = new Normalization(word);
            output.append(heh.toString()).append("\n");
        }
        output.deleteCharAt(output.length()-1);
        FileHandler.write(output.toString());
    }
}
