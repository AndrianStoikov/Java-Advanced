import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UnicodeChars {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = Console.readLine();

            for (int i = 0; i < text.length(); i++) {
                System.out.print( "\\u" + Integer.toHexString(text.charAt(i) | 0x10000).substring(1) );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
