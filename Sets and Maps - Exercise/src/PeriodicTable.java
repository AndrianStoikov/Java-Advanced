import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PeriodicTable {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> table = new HashSet<>();
        try {
            Integer n = Integer.parseInt(Console.readLine());
            for (int i = 0; i < n; i++) {
                String[] elements = Arrays.stream(Console.readLine().split(" "))
                        .map(String::trim)
                        .toArray(String[]::new);
                Collections.addAll(table, elements);
            }

            TreeSet<String> finalSet = new TreeSet<>();
            finalSet.addAll(table);
            StringBuilder sb = new StringBuilder();
            for (String s : finalSet) {
                sb.append(s).append(" ");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
