import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MinerTask {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> mineProducts = new LinkedHashMap<>();

        try {
            while(true) {
                String input = Console.readLine();
                if("stop".equals(input)) {
                    break;
                }
                Long quantity = Long.parseLong(Console.readLine());
                if(!mineProducts.containsKey(input)) {
                    mineProducts.put(input, 0L);
                }
                mineProducts.put(input, mineProducts.get(input) + quantity);
            }

            for (String s : mineProducts.keySet()) {
                System.out.printf("%s -> %s\n", s, mineProducts.get(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
