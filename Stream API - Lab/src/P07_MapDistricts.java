import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P07_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        List<String> townsDistricts = Arrays
                .stream(Console.readLine().split(" "))
                .collect(Collectors.toList());

        Integer minPopulation = Integer.valueOf(Console.readLine());

        LinkedHashMap<String, ArrayList<Integer>> towns = new LinkedHashMap<>();

        for (String info : townsDistricts) {
            String[] townDistrict = info.split(":");

            towns.putIfAbsent(townDistrict[0], new ArrayList<>());
            towns.get(townDistrict[0]).add(Integer.valueOf(townDistrict[1]));
        }

        towns.entrySet().stream()
                .filter(getCityPopulationBiggerThanMinimumPredicate(minPopulation))
                .sorted(getCityPopulationDescendingComparator())
                .forEach(getPritnerConsumer());

    }

    private static Consumer<Map.Entry<String, ArrayList<Integer>>> getPritnerConsumer() {
        return entry -> {
            System.out.printf("%s: ", entry.getKey());
            entry.getValue().stream()
                    .sorted(Collections.reverseOrder())
                    .limit(5)
                    .forEach(d -> System.out.printf("%d ", d));
            System.out.println();
        };
    }

    private static Predicate<Map.Entry<String, ArrayList<Integer>>>
    getCityPopulationBiggerThanMinimumPredicate(Integer minPopulation) {
        return entry -> entry.getValue().stream().mapToInt(Integer::intValue).sum() > minPopulation;
    }

    private static Comparator<Map.Entry<String, ArrayList<Integer>>> getCityPopulationDescendingComparator() {
        return (s1, s2) -> Integer.compare(
                s2.getValue().stream().mapToInt(Integer::intValue).sum(),
                s1.getValue().stream().mapToInt(Integer::intValue).sum());
    }
}
