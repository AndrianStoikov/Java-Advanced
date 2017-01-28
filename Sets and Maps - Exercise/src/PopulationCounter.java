import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, HashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();

        while (true) {
            String input = Console.readLine();
            if ("report".equals(input)) {
                break;
            }

            String[] countryCityPopulation = input.split("\\|");
            Long population = Long.parseLong(countryCityPopulation[2]);
            String country = countryCityPopulation[1];

            if (!countries.containsKey(country)) {
                countries.put(country, new HashMap<>());
                countryPopulation.put(country, 0L);
                countries.get(country).put(countryCityPopulation[0], 0L);
            }

            if (!countries.get(country).containsKey(countryCityPopulation[0])) {
                countries.get(country).put(countryCityPopulation[0], 0L);
            }

            Long oldPopulation = countries.get(country).get(countryCityPopulation[0]);
            countries.get(country).put(countryCityPopulation[0], oldPopulation + population);
            countryPopulation.put(country, countryPopulation.get(country) + population);
        }

        //countryPopulation = new LinkedHashMap<>(sortByValue(countryPopulation));


        countryPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " (total population: " + entry.getValue() + ")");
                    countries.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                            .forEach(pair -> {
                                System.out.println("=>" + pair.getKey() + ": " + pair.getValue());
                            });
                });

        //for (String country : countryPopulation.keySet()) {
        //    TreeMap<String, Long> townPopulation = new TreeMap(Collections.reverseOrder());
        //    townPopulation.putAll(countries.get(country));
        //    System.out.printf("%s (total population: %d)\n", country, countryPopulation.get(country));
        //    for (String town : townPopulation.keySet()) {
        //        System.out.printf("=>%s: %d\n", town, townPopulation.get(town));
        //    }
        //}
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
