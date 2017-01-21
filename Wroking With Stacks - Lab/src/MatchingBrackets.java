import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MatchingBrackets {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = Console.readLine();
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

            for (int i = 0; i < input.length(); i++) {
                int ch = input.charAt(i);
                if(ch == '(') {
                    stack.push(i);
                }
                if(ch == ')') {
                    int lastBracketIndex = stack.pop();
                    String exp = input.substring(lastBracketIndex, i + 1);
                    System.out.println(exp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
