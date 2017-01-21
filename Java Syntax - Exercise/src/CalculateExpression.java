import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            double[] input = Arrays.stream(Console.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double a = input[0];
            double b = input[1];
            double c = input[2];

            //((a2 + b2) / (a2 – b2))(a + b + c) / √c

            Double f1 =Math.pow(
                    ((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2))),
                    (a + b + c) / Math.sqrt(c)
            );

            Double f2 =Math.pow(
                    (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3)),
                    a - b
            );

            Double Dif = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));

            System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, Dif);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
