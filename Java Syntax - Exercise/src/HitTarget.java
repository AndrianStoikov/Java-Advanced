import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class HitTarget {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            Integer n = Integer.parseInt(Console.readLine());
            for (int i = 1; i <= 20; i++) {
                int b =  n - i;
                if(b <= 20 && b >= -20) {
                    if (b > 0) System.out.printf("%d + %d = %d\n", i, b, n);
                    if (b < 0) System.out.printf("%d - %d = %d\n", i, Math.abs(b), n);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
