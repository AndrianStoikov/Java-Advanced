import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialWords {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] specialWords = Console.readLine().split(" ");
            String[] text = Console.readLine().split(" ");

            HashMap<String, Integer> words = new HashMap<>();

            for (String word : specialWords) {
                for (int i = 0; i < text.length; i++) {
                    String wordInText = text[i];
                    if(word.equals(wordInText)) {
                        if(!words.containsKey(word))
                            words.put(word, 0);
                        words.put(word, words.get(word) + 1);
                    }
                }
            }


            words.entrySet().forEach(word -> {
                System.out.printf("%s - %d\n", word.getKey(), word.getValue());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
