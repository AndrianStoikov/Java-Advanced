import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_SeriesOfLetters {

    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String text = Console.readLine();

            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                String regex = character + "+";
                text = text.replaceAll(regex, "" + character);
            }

            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
