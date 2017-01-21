import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerroristsWin {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = Console.readLine();

            Pattern matchBombs = Pattern.compile("\\|(.*?)\\|");
            Matcher m = matchBombs.matcher(input);
            char[] inputAsCharArray = input.toCharArray();
            while (m.find()) {
                String bomb = m.group(1);
                int bombPower = calculateBombPower(bomb);
                int firstIndex = Math.max(0, input.indexOf(bomb) - bombPower - 1);
                int lastIndex = Math.min(input.length(), input.indexOf(bomb) + bombPower + bomb.length() + 1);
                for (int i = firstIndex; i < lastIndex; i++) {
                    inputAsCharArray[i] = '.';
                }
                input = strJoin(inputAsCharArray, "");
            }

            input = strJoin(inputAsCharArray, "");
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateBombPower(String bomb) {
        int sum = 0;
        for (int i = 0; i < bomb.length(); i++) {
            sum += bomb.charAt(i);
        }

        String result = "" + sum;
        String lastDigit = result.substring(result.length() - 1);
        return Integer.parseInt(lastDigit);
    }

    public static String strJoin(char[] aArr, String sSep) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0, il = aArr.length; i < il; i++) {
            if (i > 0)
                sbStr.append(sSep);
            sbStr.append(aArr[i]);
        }
        return sbStr.toString();
    }
}
