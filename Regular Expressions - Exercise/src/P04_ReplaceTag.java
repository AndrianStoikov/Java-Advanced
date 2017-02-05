import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_ReplaceTag {

    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "<a(\\s+href=[^>]+)>([^<]+)<\\/a>";
        try {
            StringBuilder text = new StringBuilder();

            while(true) {
                String input = Console.readLine();
                if("END".equals(input)) break;

                text.append(input);
                text.append("\n");
            }

            Pattern p = Pattern.compile(regex, Pattern.DOTALL);
            Matcher m = p.matcher(text);

            // String result = "";
            // while (m.find()) {
            //     StringBuilder sb = new StringBuilder();
            //     sb.append("[URL ").append(m.group(1));
            //     sb.append("]");
            //     sb.append(m.group(2)).append("[/URL]");
            //     result = m.replaceFirst(sb.toString());
            // }

            StringBuffer sb = new StringBuffer();
            while (m.find())
            {
                StringBuffer tag = new StringBuffer();
                tag.append("[URL").append(m.group(1));
                tag.append("]");
                tag.append(m.group(2)).append("[/URL]");
                text.replace(m.start(), m.end(), tag.toString());
                m = p.matcher(text);
            }

            System.out.println(text.toString());
            //System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
