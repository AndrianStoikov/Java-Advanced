import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P08_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String startKeyRegex = "^([a-zA-Z_]+(?=\\d))";
        String endKeyRegex = "((?<=\\d)[a-zA-Z_]+)$";

        String keyString = Console.readLine();
        String text = Console.readLine();

        Pattern startKeyPatter = Pattern.compile(startKeyRegex);
        Pattern endKeyPatter = Pattern.compile(endKeyRegex);

        Matcher startKeyMatcher = startKeyPatter.matcher(keyString);
        Matcher endKeyMatcher = endKeyPatter.matcher(keyString);

        if (startKeyMatcher.find() && endKeyMatcher.find()) {

            String startKey = startKeyMatcher.group();
            String endKey = endKeyMatcher.group();
            Pattern targetPattern = Pattern.compile(startKey + "([\\d.]+?)" + endKey);
            Matcher targetMatcher = targetPattern.matcher(text);

            double sum = 0.0;
            while (targetMatcher.find()) {
                try {
                    double num = Double.parseDouble(targetMatcher.group(1));
                    sum += num;
                } catch (Exception e) {
                }
            }

            String value = sum > 0 ? new DecimalFormat("#.##").format(sum) : "nothing";

            System.out.printf("<p>The total value is: <em>%s</em></p>", value);
        } else
            System.out.println("<p>A key is missing</p>");
    }
}

