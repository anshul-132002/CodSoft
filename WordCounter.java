import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        try {
            String inputText = getInputText(args);
            String[] words = splitIntoWords(inputText);
            int totalCount = countWords(words);

            System.out.println("Total number of words: " + totalCount);
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
        }
    }

    private static String getInputText(String[] args) throws IOException {
        if (args.length > 0) {
            return readTextFromFile(args[0]);
        } else {
            System.out.println("Please enter the text:");
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            return reader.readLine();
        }
    }

    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(" ");
            }
        }
        return sb.toString();
    }

    private static String[] splitIntoWords(String inputText) {
        return inputText.split("[\\p{Punct}\\s]+");
    }

    private static int countWords(String[] words) {
        return words.length;
    }
}