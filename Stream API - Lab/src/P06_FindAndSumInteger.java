import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class P06_FindAndSumInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        @SuppressWarnings("Convert2MethodRef")
        OptionalInt average = Arrays.stream(Console.readLine().split(" "))
                .filter(a -> !a.isEmpty())
                .filter(a -> isNumber(a))
                .mapToInt(Integer::parseInt)
                .reduce((a,b) -> a + b);

        if (average.isPresent())
            System.out.printf("%d", average.getAsInt());
        else
            System.out.println("No match");
    }

    private static boolean isNumber(String a) {
        try {
            Integer num = Integer.valueOf(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
