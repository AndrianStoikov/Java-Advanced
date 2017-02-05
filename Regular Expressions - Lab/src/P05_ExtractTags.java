import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P05_ExtractTags {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "<.+?>";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        ArrayDeque<String> tags = new ArrayDeque<>();

        try {

            while (true) {
                String text = Console.readLine();
                if("END".equals(text)) break;
                Matcher m = p.matcher(text);

                while (m.find())
                    tags.addLast(m.group());
            }

            tags.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
