import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_TakeTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(Console.readLine().split(" "))
                .distinct()
                .map(Integer::parseInt)
                .filter(n -> n >= 10 && n <= 20)
                .limit(2)
                .forEach(a -> System.out.print(a + " "));
    }
}
