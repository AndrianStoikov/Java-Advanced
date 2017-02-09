import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Function<int[], Integer> minNumber = numbers -> {
            int min = numbers[0];
            for (int numb : numbers) {
                if(numb < min) min = numb;
            };
            return min;
        };
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = console.readLine();
            int[] numbers = Arrays.stream(input.split(" "))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(minNumber.apply(numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
