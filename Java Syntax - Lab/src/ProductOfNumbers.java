import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.util.Arrays;
        import java.util.Scanner;
        import java.util.stream.LongStream;

public class ProductOfNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String[] input = Console.readLine().split("\\s+");
            Integer n = Integer.parseInt(input[0]);
            Integer m = Integer.parseInt(input[1]);
            BigInteger result = new BigInteger("1");
            for (int i = n; i <= m; i++) {
                result = result.multiply(new BigInteger("" + i));
            }

            System.out.printf("product[%d..%d] = %s", n, m, result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
