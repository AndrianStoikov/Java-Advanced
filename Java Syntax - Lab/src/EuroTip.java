import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class EuroTip {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            Double kg = Double.parseDouble(Console.readLine());
            BigDecimal bgn = new BigDecimal(kg * 1.20);
            BigDecimal DM = new BigDecimal(4210500000000.0);
            BigDecimal result = DM.multiply(bgn).setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.printf("%.2f marks", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
