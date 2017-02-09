import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Integer[] nums = Arrays.stream(Console.readLine().split(", "))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int sum = Arrays.stream(nums).reduce((a, b) -> a + b).get();
        System.out.println("Count = " + nums.length);
        System.out.println("Sum = " + sum);

    }
}
