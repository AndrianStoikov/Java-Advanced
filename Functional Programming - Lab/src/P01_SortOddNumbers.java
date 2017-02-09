import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_SortOddNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nums = Arrays.stream(Console.readLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        nums.removeIf(n -> n % 2 != 0);
        System.out.println(nums.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));

        nums.sort(Integer::compareTo);

        System.out.println(nums.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}
