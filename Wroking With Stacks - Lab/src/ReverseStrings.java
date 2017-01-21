
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class ReverseStrings {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = Console.readLine();
            ArrayDeque<Character> stackReverse = new ArrayDeque<Character>();
            for (Character letter :
                    input.toCharArray()) {
                stackReverse.push(letter);
            }

            for (Character letter :
                    stackReverse) {
                System.out.print(stackReverse.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
