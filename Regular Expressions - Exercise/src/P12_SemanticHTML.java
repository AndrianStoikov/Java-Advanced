import org.w3c.dom.Attr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12_SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        //WTF MAAAAN :| :| :|
        String tagRegex = "(<)(div)(.+?(?:(id)|(class)))(\\s*=\\s*\"([^\"]+)\")([^>]*>)(.*)(<\\/\\2>)\\s*(<!--\\s*\\7\\s*-->)";

        StringBuilder text = new StringBuilder();
        while (true) {
            String input = Console.readLine();
            if ("END".equals(input)) break;

            text.append(input).append("\n");
        }

        Pattern tagP = Pattern.compile(tagRegex, Pattern.DOTALL);
        Matcher tagM = tagP.matcher(text);

        while (tagM.find()) {
            String replacement = replaceTag(tagM);
            text = text.replace(tagM.start(), tagM.end(), replacement);
            tagM = tagP.matcher(text);
        }

        System.out.println(text);
    }

    private static String replaceTag(Matcher m) {
        String oppeningTag = m.group(2);
        String tagAtributes = m.group(3)
                + m.group(6)
                + m.group(8);

        String closingTag = m.group(10);

        StringBuilder result = new StringBuilder();

        String attrRegex = "(id|class)(\\s*=\\s*)(\")([^\"]+)(\\3)";
        Pattern AttrP = Pattern.compile(attrRegex);
        Matcher AttrM = AttrP.matcher(tagAtributes);
        while (AttrM.find()) {
            String newOpeningTag = AttrM.group(4);

            String tag = "";
            if(m.group(5) == null)
                tag = m.group(4) + m.group(6);
            else
                tag = m.group(5) + m.group(6);

            tagAtributes = tagAtributes.replaceAll(tag, "");
            tagAtributes = tagAtributes.replaceAll("( )+", " ");
            tagAtributes = cleanSpaces(tagAtributes);

            String newClosingTag = String.format("</%s>", AttrM.group(4));
            newClosingTag = cleanSpaces(newClosingTag);

            result.append("<").append(newOpeningTag).append(tagAtributes)
                    .append(m.group(9))
                    .append(newClosingTag);

            AttrM = AttrP.matcher(tagAtributes);
        }

        return result.toString();
    }

    private static String cleanSpaces(String s) {
        String clean = s.replaceAll("\\s+(?!.*<)", " ");
        clean = clean.replaceAll("\\s+(?=>)", "");

        return clean;
    }
}
