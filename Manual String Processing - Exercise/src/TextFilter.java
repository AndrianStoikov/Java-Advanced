import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class TextFilter {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] words = Console.readLine().split(", ");
            String text = Console.readLine();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                Pattern p = Pattern.compile(word);
                Matcher m = p.matcher(text);

                while (m.find()) {
                    String censoredWord = Stream.generate(() -> "*").limit(m.group().length()).collect(joining());
                    text = m.replaceAll(censoredWord);
                }
            }

            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
