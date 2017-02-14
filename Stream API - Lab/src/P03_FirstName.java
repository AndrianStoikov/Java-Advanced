import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(Console.readLine().split(" "))
                .collect(Collectors.toList());

        HashSet<String> letters = new HashSet<>();
        Collections.addAll(letters, Arrays.stream(Console.readLine().split(" "))
                .map(String::toLowerCase)
                .toArray(String[]::new));

        Optional<String> name = names.stream()
                .sorted()
                .filter(n -> letters.contains(("" + n.charAt(0)).toLowerCase()))
                .limit(1)
                .findFirst();

        if (name.isPresent())
            System.out.println(name.get());
        else
            System.out.println("No match");
    }
}
