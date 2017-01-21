import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String[] input = Console.readLine().split("\\s+");
            Double h = Double.parseDouble(input[0]);
            Double b = Double.parseDouble(input[1]);

            System.out.printf("Area = %.2f", (h * b) / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
