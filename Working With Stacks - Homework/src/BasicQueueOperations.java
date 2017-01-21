import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;


public class BasicQueueOperations {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer[] n = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Integer elementsToAdd = n[0];
            Integer elementsToRemove = n[1];
            Integer isPresented = n[2];
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

            Collections.addAll(queue, Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new));

            for (int i = 0; i < elementsToRemove; i++) {
                queue.pop();
            }

            if(queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            if(queue.contains(isPresented)) System.out.println(true);
            else {
                System.out.println(queue.stream().reduce(Math::min).get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
