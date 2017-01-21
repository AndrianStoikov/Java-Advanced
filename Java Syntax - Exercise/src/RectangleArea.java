import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String[] input = Console.readLine().split("\\s+");
            Double h = Double.parseDouble(input[0]);
            Double b = Double.parseDouble(input[1]);

            System.out.printf("%.2f", (h * b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
