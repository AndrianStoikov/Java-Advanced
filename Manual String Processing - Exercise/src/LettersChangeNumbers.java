import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String text = Console.readLine();
            String regex = "([A-z])([0-9]+)([A-z])";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);

            double totalSum = Double.parseDouble("0");
            while (m.find()) {
                Character firstLetter = m.group(1).toCharArray()[0];
                Integer firstLetterPosition = Character.isUpperCase(firstLetter) ?
                        (int) firstLetter - 64 : (int) firstLetter - 96;

                Double number = Double.parseDouble(m.group(2));
                if (Character.isUpperCase(firstLetter)) {
                    number = number / firstLetterPosition;
                } else {
                    number = number * firstLetterPosition;
                }

                Character lastLetter = m.group(3).toCharArray()[0];
                Integer lastLetterPosition = Character.isUpperCase(lastLetter) ?
                        (int) lastLetter - 64 : (int) lastLetter - 96;

                if (Character.isUpperCase(lastLetter)) {
                    number = number - lastLetterPosition;
                } else {
                    number = number + lastLetterPosition;
                }

                totalSum = totalSum + number;
            }

            System.out.printf("%.2f", totalSum);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
