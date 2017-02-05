import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P04_ExtractIntegers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "\\d+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        try {
            String text = Console.readLine();
            Matcher m = p.matcher(text);

            ArrayDeque<String> integers = new ArrayDeque<String>();

            while (m.find())
                integers.addLast(m.group());

            integers.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
