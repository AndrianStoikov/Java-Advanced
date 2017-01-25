import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;


public class CountValues {
    public static void main(String[] args) throws IOException {

        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> countMap = new HashMap<>();
        try {
            String[] input = Console.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                String number = input[i];
                if(!countMap.containsKey(number)) {
                    countMap.put(number, 1);
                } else {
                    countMap.put(number, countMap.get(number) + 1);
                }
            }

            for (String s : countMap.keySet()) {
                System.out.printf("%s - %d times\n", s, countMap.get(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
