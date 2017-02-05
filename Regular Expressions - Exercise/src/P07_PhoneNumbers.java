import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "([A-Z][A-Za-z]*)([^A-Za-z\\d+]*)((\\+{0,1}\\d+[\\(\\)\\/\\.\\-\\+ ]*){2,})";

        StringBuilder text = new StringBuilder();
        while (true) {
            String input = Console.readLine();
            if ("END".equals(input)) break;
            text.append(input);
        }

        StringBuilder output = new StringBuilder();
        output.append("<ol>");

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while(m.find()) {
            String name = m.group(1);
            String number = m.group(3);
            String lastSymbolInNumber = "" + number.charAt(number.length() - 1);
            if(lastSymbolInNumber.matches("[\\(\\)\\/\\.\\-\\+ ]")) break;

            number = number.replaceAll("[\\(\\)/\\.\\- ]", "").trim();
            String tag = String.format("<li><b>%s:</b> %s</li>", name, number);
            output.append(tag);
        }

        if(output.length() != 4) {
            output.append("</ol>");
        } else {
            output.setLength(0);
            output.append("<p>No matches!</p>");
        }


        System.out.println(output);
    }
}
