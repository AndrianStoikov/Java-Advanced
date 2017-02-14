import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class P04_AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        @SuppressWarnings("Convert2MethodRef")
        OptionalDouble average = Arrays.stream(Console.readLine().split(" "))
                .filter(a -> !a.isEmpty())
                .filter(a -> isNumber(a))
                .mapToDouble(Double::valueOf)
                .average();

        if (average.isPresent())
            System.out.printf("%.2f", average.getAsDouble());
        else
            System.out.println("No match");
    }

    private static boolean isNumber(String a) {
        try {
            double num = Double.parseDouble(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
