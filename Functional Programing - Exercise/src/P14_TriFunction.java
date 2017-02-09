import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P14_TriFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<String, Integer, Boolean> checkWordSum = (word, val) -> {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                int ch = (int) word.charAt(i);
                sum += ch;
            }

            return sum >= val;
        };

        TriFunction<Integer,
                BiFunction<String, Integer, Boolean>,
                ArrayList<String>, String>
                triFunction = (sum, checker, words) -> {

            for (String word : words) {
                if (checker.apply(word, sum)) {
                    System.out.println(word);
                    return word;
                }
            }

            return null;
        };

        int sum = Integer.parseInt(Console.readLine());
        ArrayList<String> words = Arrays.stream(Console.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayList::new));

        triFunction.apply(sum, checkWordSum, words);
    }

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {

        R apply(A a, B b, C c);

        default <V> TriFunction<A, B, C, V> andThen(
                Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (A a, B b, C c) -> after.apply(apply(a, b, c));
        }
    }
}
