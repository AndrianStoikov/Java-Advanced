import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>(); //Needed materials to build weapon
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);

        HashMap<String, String> items = new HashMap<>(); //From what weapons are build
        items.put("shards", "Shadowmourne");
        items.put("fragments", "Valanyr");
        items.put("motes", "Dragonwrath");

        boolean itemIsObtained = false; //Legendary item is still not created
        while (!itemIsObtained) {
            String input = Console.readLine();
            if (input == null)
                break;

            String regex = "([0-9]+) ([\\w+-]+)";
            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);   // get a matcher object

            String material = "";
            while (m.find()) {
                material = m.group(2).toLowerCase();
                Integer quantity = Integer.parseInt(m.group(1));

                if (material.equals("shards") | material.equals("fragments") | material.equals("motes")) {
                    //check if material is a key material
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        String legendaryItem = items.get(material);
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.printf("%s obtained!\n", legendaryItem);
                        itemIsObtained = true;
                        break;
                    }

                } else {
                    if (!junk.containsKey(material))
                        junk.put(material, 0);

                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEach(item -> {
                    sb.append(item.getKey()).append(": ").append(item.getValue()).append("\n"); //Print key materials
                });

        junk.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(item -> {
                    sb.append(item.getKey()).append(": ").append(item.getValue()).append("\n"); //Print junk materials
                });

        System.out.println(sb);
    }
}
