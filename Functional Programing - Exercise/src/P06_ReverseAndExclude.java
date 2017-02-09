import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(Console.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors
                        .toCollection(ArrayList::new));

        Integer n = Integer.parseInt(Console.readLine());

        BiPredicate<Integer, Integer> isDivisableByN = (a, number) -> a % number == 0;
        Consumer<ArrayList<Integer>> printer = (array) -> array.forEach(a -> System.out.print(a + " "));

        numbers = numbers.stream().filter(a -> !isDivisableByN.test(a, n))
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.reverse(numbers);
        printer.accept(numbers);
    }
}
