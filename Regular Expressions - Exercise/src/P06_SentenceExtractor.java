import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P06_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String pattern = Console.readLine();
        StringBuilder text = new StringBuilder(Console.readLine());

        Pattern p = Pattern.compile("[^!?.]*\\b" + pattern + "\\b[^!?.]*[!.?]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        while (m.find())
        {
            System.out.println(m.group().trim());
            text.replace(m.start(), m.end(), "");
            m = p.matcher(text);
        }
    }
}
