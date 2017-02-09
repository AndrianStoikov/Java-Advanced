import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P04_FindEvensOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Integer[] range = Arrays.stream(Console.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        String type = Console.readLine();


        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isOdd = num -> num % 2 != 0;

        if(type.equals("odd")) printer(isOdd, range);
        else printer(isEven, range);
    }


    public static void printer (Predicate<Integer> type, Integer[] ranger) {
        for (int i = ranger[0]; i <= ranger[1]; i++) {
            if(type.test(i)) System.out.print(i + " ");
        }
    }
}
