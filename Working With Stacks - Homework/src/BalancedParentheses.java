import javax.xml.parsers.FactoryConfigurationError;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = Console.readLine();

            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isParanthesis = true;
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                if(symbol == '[' | symbol == '(' | symbol == '{')
                    stack.push(symbol);
                else {
                    char closingSymbol = input.charAt(i);
                    char openingSymbol = ' ';
                    if(stack.size() > 0)
                        openingSymbol = stack.pop();
                    if(closingSymbol == 41 && openingSymbol == 40) {
                        isParanthesis = true;
                    } else if(closingSymbol == 93 && openingSymbol == 91) {
                        isParanthesis = true;
                    } else if (openingSymbol == 123  && closingSymbol == 125) {
                        isParanthesis = true;
                    } else {
                        isParanthesis = false;
                    }

                    if (!isParanthesis) {
                        System.out.println("NO");
                        return;
                    }
                }
            }

            System.out.println("YES");
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
