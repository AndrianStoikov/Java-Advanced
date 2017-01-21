import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = Console.readLine().split("\\s+");
            ArrayDeque<String> stack = new ArrayDeque<String>();
            Collections.addAll(stack, input);

            while(stack.size() > 1) {
                Integer first = Integer.parseInt(stack.pop());
                String ap = stack.pop();
                Integer second = Integer.parseInt(stack.pop());

                if(ap.equals("+")) {
                    stack.push("" + (first + second));
                } else {
                    stack.push("" + (first - second));
                }
            }

            System.out.println(stack.pop());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
