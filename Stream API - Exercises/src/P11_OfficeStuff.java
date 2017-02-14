import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P11_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(Console.readLine());

        String regex = "^\\|(\\w+) - (\\d+) - (\\w+)\\|$";
        Pattern p = Pattern.compile(regex);


        LinkedHashMap<String, LinkedHashMap<String, Integer>> products = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = Console.readLine();
            Matcher m = p.matcher(input);

            while (m.find()) {
                String company = m.group(1);
                Integer amount = Integer.valueOf(m.group(2));
                String product = m.group(3);

                if (!products.containsKey(company))
                    products.put(company, new LinkedHashMap<>());
                if (!products.get(company).containsKey(product))
                    products.get(company).put(product, 0);

                int oldAmount = products.get(company).get(product);
                products.get(company).put(product, oldAmount + amount);
            }
        }


        TreeMap<String, LinkedHashMap<String, Integer>> sortedMap = new TreeMap<>();
        sortedMap.putAll(products);

        StringBuilder sb = new StringBuilder();
        for (String company : sortedMap.keySet()) {
            ArrayList<String> list = new ArrayList<>();
            for (String product : sortedMap.get(company).keySet()) {
                list.add(String.format("%s-%d", product, sortedMap.get(company).get(product)));
            }
            sb.append(company).append(": ").append(String.join(", ", list)).append("\n");
        }

        System.out.println(sb);
    }
}
