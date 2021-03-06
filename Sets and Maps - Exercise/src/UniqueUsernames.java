import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueUsernames {

    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> names = new LinkedHashSet<>();
        try {
            Integer n = Integer.parseInt(Console.readLine());
            for (int i = 0; i < n; i++) {
                names.add(Console.readLine());
            }

            names.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
