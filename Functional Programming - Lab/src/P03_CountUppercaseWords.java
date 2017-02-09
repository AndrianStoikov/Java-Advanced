import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class P03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String[] words = Console.readLine().split(" ");

        Predicate<String> isUpperCase = (word) -> {
            String firstLetter = word.charAt(0) + "";

            return firstLetter.equals(firstLetter.toUpperCase());
        };

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String word : words) {
            if(isUpperCase.test(word)) {
                sb.append(word).append("\n");
                counter++;
            }
        }

        sb.insert(0, counter + "\n");
        System.out.println(sb);
    }
}
