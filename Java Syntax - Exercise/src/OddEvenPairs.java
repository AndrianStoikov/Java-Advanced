import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class OddEvenPairs {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            int[] numbers = Arrays.stream(Console.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(numbers.length % 2 != 0) {
                System.out.println("invalid length");
                return;
            }

            for (int i = 0; i < numbers.length; i += 2) {
                int a = numbers[i];
                int b = numbers[i + 1];

                if(a % 2 == 0 && b % 2 == 0) {
                    System.out.printf("%d, %d -> both are even\n", a, b);
                } else if(a % 2 != 0 && b % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd\n", a, b);
                } else System.out.printf("%d, %d -> different\n", a, b);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
