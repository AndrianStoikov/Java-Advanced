import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTags {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String text = Console.readLine();

            String regex = "<upcase>(.+?)<\\/upcase>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);

            StringBuilder sb = new StringBuilder();
            int last = 0;
            while (m.find()) {
                sb.append(text.substring(last, m.start()));
                sb.append(m.group(1).toUpperCase());
                last = m.end();
            }
            sb.append(text.substring(last));

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
