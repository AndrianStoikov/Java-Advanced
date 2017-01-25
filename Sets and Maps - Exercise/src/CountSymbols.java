import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class CountSymbols {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<Character, Integer> counter = new LinkedHashMap<>();

        try {
            String input = Console.readLine();
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                if(!counter.containsKey(letter)) {
                    counter.put(letter, 0);
                }
                counter.put(letter, counter.get(letter) + 1);
            }


            TreeMap<Character, Integer> finalMap = new TreeMap<>();
            finalMap.putAll(counter);
            for (Character character : finalMap.keySet()) {
                System.out.printf("%s: %d time/s\n", character, counter.get(character));
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
