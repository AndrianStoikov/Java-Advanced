import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Consumer<String> sirPrinter = a -> System.out.println("Sir " + a);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = console.readLine();
            String[] words = input.split("\\s+");

            Arrays.stream(words).forEach(sirPrinter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
