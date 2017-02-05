import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11_ExtractHyperLinks {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder();
        while(true) {
            String input = Console.readLine();
            if("END".equals(input)) break;
            text.append(input).append("\n");
        }

        String matchTag = "<a[^>]+>";
        Pattern p = Pattern.compile(matchTag);
        Matcher m = p.matcher(text);

        String hrefRegex = "href\\s*=[\\n\\s]*(\"|'|.+?)(.*?[^'\"])(\\1|>)";
        while(m.find()) {
            String tag = m.group();
            Pattern hrefPattern = Pattern.compile(hrefRegex);
            Matcher hrefMatcher = hrefPattern.matcher(tag);
            while(hrefMatcher.find()) {
                StringBuilder href = new StringBuilder(hrefMatcher.group(2));
                if(hrefMatcher.group(1).matches("[^'\"]+"))
                    href.insert(0, hrefMatcher.group(1));

                System.out.println(href);
            }
        }
    }
}
