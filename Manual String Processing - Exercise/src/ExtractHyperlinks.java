import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        //TODO THIS BULSHIT :@@@@@@@@@@@@@@@
        try {
            String tagRegex = "<a(?s).+?>"; //href="(.+?)"
            Pattern tagPattern = Pattern.compile(tagRegex);

            StringBuilder text = new StringBuilder();
            while(true) {
                String input = Console.readLine();
                if("END".equals(input)) {
                    break;
                }
                text.append(input);
            }

            Matcher tagMatch = tagPattern.matcher(text.toString());

            Pattern hrefPattern = Pattern.compile("href=\"(.+?)\"");
            while (tagMatch.find()) {
                String tag = tagMatch.group();
                int indexOfHref = tag.indexOf("href");
                int firstIndexOfEmptySpace = tag.indexOf(" ", indexOfHref);
                int closingTag = tag.indexOf(">", indexOfHref);

                int hrefSize;
                if(firstIndexOfEmptySpace != -1 && firstIndexOfEmptySpace < closingTag) {
                    hrefSize = firstIndexOfEmptySpace;
                } else if(closingTag != -1) {
                    hrefSize = closingTag;
                } else continue;

                String href = tag.substring(indexOfHref, hrefSize);
                System.out.println(href);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
