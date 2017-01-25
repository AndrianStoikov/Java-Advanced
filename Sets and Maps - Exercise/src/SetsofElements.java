import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class SetsofElements {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> nNumbers = new LinkedHashSet<>();
        LinkedHashSet<String> mNumbers = new LinkedHashSet<>();
        try {
            Integer[] nm = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            for (int i = 0; i < nm[0]; i++) {
                String number = Console.readLine();
                nNumbers.add(number);
            }

            for (int i = 0; i < nm[1]; i++) {
                String number = Console.readLine();
                mNumbers.add(number);
            }

            nNumbers.retainAll(mNumbers);
            for (String number : nNumbers) {
                System.out.print(number + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
