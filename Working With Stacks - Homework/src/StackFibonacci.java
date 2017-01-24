import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Andrian on 22.1.2017 г..
 */
public class StackFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long n = Long.parseLong(Console.readLine());

            ArrayDeque<Long> stack = new ArrayDeque<>();
            stack.push((long)1);
            stack.push((long)1);

            for (int i = 1; i < n; i++) {
                Long number = stack.removeLast() + stack.peek();
                stack.push(number);

            }
            System.out.println(stack.pop());
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
