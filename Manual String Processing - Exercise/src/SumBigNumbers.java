import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumBigNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String number1 = Console.readLine();
            String number2 = Console.readLine();

            BigDecimal result = new BigDecimal(new BigDecimal(number1).add(new BigDecimal(number2)).toString());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
