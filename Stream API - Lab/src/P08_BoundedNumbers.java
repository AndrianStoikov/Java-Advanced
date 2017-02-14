import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P08_BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bound = Arrays
                .stream(Console.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        Arrays
                .stream(Console.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(a -> bound.get(0) <= a && a <= bound.get(1))
                .forEach(a -> System.out.printf("%d ", a));

    }
}
