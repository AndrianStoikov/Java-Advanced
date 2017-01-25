import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;


public class SetsofElements {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> names = new LinkedHashSet<>();
        try {
            Integer n = Integer.parseInt(Console.readLine());
            Integer m = Integer.parseInt(Console.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
