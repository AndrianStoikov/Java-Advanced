import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Long>> venus = new LinkedHashMap<>();

        while (true) {
            String input = Console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String regexForTown = "\\B(@)(.*?)(?=[0-9])\\b";
            Pattern patternForTown = Pattern.compile(regexForTown);
            Matcher matcherForTown = patternForTown.matcher(input);   // get a matcher object

            String regexForName = "^.*?(?=@)";
            Pattern patternForName = Pattern.compile(regexForName);
            Matcher matcherForName = patternForName.matcher(input);


            String town = "";
            while (matcherForTown.find()) {
                town = matcherForTown.group(2);
                town = town.trim();

                //Check if town has valid length
                if (town.split(" ").length > 3) {
                    break;
                }
            }

            String name = "";
            //Find name
            while (matcherForName.find()) {
                name = matcherForName.group();
                name = name.trim();

                //Check if name has valid length
                if (name.split(" ").length > 3) {
                    break;
                }
            }

            String[] inf = input.split(" ");

            //If wrong, skip 1 iteration
            if (town.equals("") | name.equals(""))
                continue;

            try {
                Long ticketPrice = Long.parseLong(inf[inf.length - 2]);
                Long ticketCount = Long.parseLong(inf[inf.length - 1]);

                Long result = ticketCount * ticketPrice;
                if (!venus.containsKey(town))
                    venus.put(town, new LinkedHashMap<>());

                if (!venus.get(town).containsKey(name)) {
                    venus.get(town).put(name, 0L);
                }

                venus.get(town).put(name, venus.get(town).get(name) + result);
            } catch (Exception e) {
                //Do nothing if the format is wrong
                continue;
            }

        }

        //Sort and print
        StringBuffer sb = new StringBuffer();
        venus.entrySet()
                .forEach(entry -> {
                    sb.append(entry.getKey()).append("\n");
                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                            .forEach(pair -> {
                                String output = String.format("#  %s -> %d\n", pair.getKey(), pair.getValue());
                                sb.append(output);
                            });
                });

        System.out.println(sb);
    }
}
