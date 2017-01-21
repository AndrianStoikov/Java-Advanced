import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

/**
 * Created by Andrian on 21.1.2017 г..
 */
public class HotPotato {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] kids = Console.readLine().split("\\s+");
            Integer n = Integer.parseInt(Console.readLine());
            ArrayDeque<String> queue = new ArrayDeque<>();
            Collections.addAll(queue, kids);

            while(queue.size() > 1) {
                for (int i = 0; i < n - 1; i++) {
                    String first = queue.removeFirst();
                    queue.add(first);
                }
                System.out.println("Removed " + queue.removeFirst());
            }

            System.out.println("Last is " + queue.getFirst());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
