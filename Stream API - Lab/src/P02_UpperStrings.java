import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(Console.readLine().split(" "))
                .forEach(s -> System.out.print(s.toUpperCase() + " "));
    }
}