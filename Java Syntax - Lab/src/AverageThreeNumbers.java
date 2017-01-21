import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class AverageThreeNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Double numbers = Arrays.stream(Console.readLine().split("\\s+"))
                    .map(String::trim)
                    .mapToDouble(Double::parseDouble)
                    .reduce((a,b) -> a + b)
                    .getAsDouble();
            System.out.printf("%.2f", numbers / 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
