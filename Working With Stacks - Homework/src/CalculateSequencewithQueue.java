import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class CalculateSequencewithQueue {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long n = Long.parseLong(Console.readLine());

            ArrayDeque<Long> stack = new ArrayDeque<>();
            stack.push(n);

            System.out.print(stack.peek() + " ");
            for (int i = 1; i < 65; i += 4) {
                long s2 = stack.getFirst() + 1;
                System.out.print(s2 + " ");
                long s3 = stack.getFirst() * 2 + 1;
                System.out.print(s3 + " ");
                long s4 = stack.getFirst() + 2;
                System.out.print(s4 + " ");
                stack.addLast(s2);
                stack.addLast(s3);
                stack.addLast(s4);
                stack.removeFirst();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
