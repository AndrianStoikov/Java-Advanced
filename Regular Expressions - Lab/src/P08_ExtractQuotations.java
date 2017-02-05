import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P08_ExtractQuotations {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(\"|')(.*?)\\1";
        Pattern p = Pattern.compile(regex);

        try {

            String text = Console.readLine();
            Matcher m = p.matcher(text);
            while(m.find()) {
                System.out.println(m.group(2));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
