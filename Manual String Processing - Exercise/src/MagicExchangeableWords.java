import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = Console.readLine().split("\\s+");
            String str1 = input[0];
            String str2 = input[1];

            HashMap<Character, Character> letterMatches = new HashMap<>();

            //TODO THIS FUCKING BULLSHIT

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
