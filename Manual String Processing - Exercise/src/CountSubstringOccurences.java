import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CountSubstringOccurences {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = Console.readLine();
            String substring = Console.readLine();

            Pattern p = Pattern.compile(substring, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(text);

            int matches = 0;
            while (m.find())
                matches++;

            System.out.println(matches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
