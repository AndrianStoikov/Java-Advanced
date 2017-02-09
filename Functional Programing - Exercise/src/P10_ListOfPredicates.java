import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Created by Andrian on 7.2.2017 г..
 */
public class P10_ListOfPredicates {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Integer range = Integer.parseInt(console.readLine());
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            values.add(i);
        }


        String input = console.readLine();
        ArrayList<Integer> divisors = Arrays.stream(input.split("\\s+"))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        BiPredicate<Integer, ArrayList<Integer>> isDivisor = (number, arrayOfDivisors) -> {
            boolean areDivisors = true;
            for (Integer divisor :
                    arrayOfDivisors) {
                if (number % divisor != 0) areDivisors = false;
            }

            return areDivisors;
        };

        values = values.stream().filter(a -> isDivisor.test(a, divisors))
                .collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i) + " ");
        }

    }
}
