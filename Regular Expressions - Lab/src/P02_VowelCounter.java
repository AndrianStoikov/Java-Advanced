import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P02_VowelCounter {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "[aeiouy]";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        try {
            String text = Console.readLine();
            Matcher m = p.matcher(text);

            int count = 0;
            while (m.find())
                count++;

            System.out.println("Vowels: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
