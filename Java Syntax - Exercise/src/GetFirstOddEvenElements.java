import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GetFirstOddEvenElements {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            List<Integer> numbers = new ArrayList<Integer>(Arrays.stream(Console.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
            .boxed().collect(Collectors.toList()));

            String[] commands = Console.readLine().split("\\s+");
            int n = Integer.parseInt(commands[1]);
            String type = commands[2];
            Predicate<Integer> validator = type.equals("even") ? a -> a % 2 == 0 : a -> a % 2 != 0;
            numbers = numbers.stream().filter(validator).collect(Collectors.toList());
            n = Math.min(n, numbers.size());
            numbers = numbers.subList(0, n);
            System.out.println(numbers.stream().map(Object::toString).collect(Collectors.joining(" ")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
