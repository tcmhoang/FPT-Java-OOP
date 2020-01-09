import java.util.Arrays;
import java.util.HashSet;

public class Normalization {
    private StringBuilder output;

    public Normalization(String text) {
        output = new StringBuilder(text);
    }

    //    Only one space between words
    private void delimSpace() {
        String[] detached = output.toString().split("\\s+");
        output.delete(0, output.length());
        for (String word : detached) {
            output.append(word).append(" ");
        }
    }

    //    Only one space between comma, dot and colon. First character after dot is uppercase
//    No space between quotes
    private String[] noMoreWord() {
        return output.toString().split("\\w*");
    }

    private void beatMe() {
        HashSet<String> chars = new HashSet<>(Arrays.asList(noMoreWord()));
        chars.remove("");
        chars.remove(" ");
        for (String character : chars) {
            int idx = output.indexOf(character);
            if (character.equals("\"")) {
                takeQuotes(idx);
            } else if (character.equals(".")) {
                if (idx < output.length() - 1) {
                    takeMarks(idx, 0, '.');
                }
            } else {
                if (idx < output.length() - 1) {
                    takeMarks(idx, 1, output.charAt(idx));
                }
            }
        }

    }


    private void takeQuotes(int idx) {
        int count = 0;
        while (idx != -1) {
            count += 1;
            if (count % 2 == 1) {
                int idxSearching = idx + 1;
                output.deleteCharAt(idxSearching);

            } else {
                int idxSearching = idx - 1;
                output.deleteCharAt(idxSearching);
            }
            idx = output.indexOf("\"", idx + 1);
        }
    }

    private void spaceBetween(int idx) {
        if (output.charAt(idx + 1) != ' ') {
            output.insert(idx + 1, " ");
        }

    }

    private void takeMarks(int idx, int indicator, char mark) {
        while (idx != -1 && idx < output.length() - 1) {
            char newChar;
            spaceBetween(idx);
            if (Character.isLowerCase(output.charAt(idx + 1))) {
                if (indicator == 0) {
                    newChar = Character.toUpperCase(output.charAt(idx + 1));
                } else {
                    newChar = Character.toLowerCase(output.charAt(idx + 1));
                }
                output.replace(idx + 1, idx + 2, String.valueOf(newChar));
            } else {
                if (indicator == 0) {
                    newChar = Character.toUpperCase(output.charAt(idx + 2));
                } else {
                    newChar = Character.toLowerCase(output.charAt(idx + 2));
                }
                output.replace(idx + 2, idx + 3, String.valueOf(newChar));
            }
            idx = output.indexOf(String.valueOf(mark), idx + 1);
        }
    }


    public String toString() {
        delimSpace();
        capitalizeLine();
        endLine();
        pullDotCom();
        beatMe();
        return output.toString();
    }

    //    First Character in first line is upper case
    private void capitalizeLine() {
        char newchar = Character.toUpperCase(output.charAt(0));
        output.replace(0, 1, String.valueOf(newchar));
    }

    //    No blank line between line
    // Auto fixed :))
//    No space between comma|dot and word
    private void pullDotCom() {
        for (String mark : new String[]{".", ","}) {
            int idx = output.indexOf(mark);
            while (idx != -1) {
                if (output.charAt(idx - 1) == ' ') {
                    output.deleteCharAt(idx - 1);
                    idx = output.indexOf(mark, idx);
                }
                idx = output.indexOf(mark, idx + 1);
            }
        }
    }

    //    Have dot at the end of line
    private void endLine() {
        output.deleteCharAt(output.length() - 1);
        if (output.charAt(output.length() - 1) != '.') {
            output.append(".");
        }
    }
}
