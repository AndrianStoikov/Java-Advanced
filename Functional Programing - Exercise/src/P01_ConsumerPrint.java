import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P01_ConsumerPrint {
    public static void main(String[] args) {
        Consumer<String> printer = System.out::println;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = console.readLine();
            String[] words = input.split(" ");
            Arrays.stream(words).forEach(printer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
