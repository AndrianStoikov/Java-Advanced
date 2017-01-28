import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, HashSet<String>> logs = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> userTime = new LinkedHashMap<>();

        Integer n = Integer.parseInt(Console.readLine());
        for (int i = 0; i < n; i++) {
            String[] userLog = Console.readLine().split(" ");
            String userName = userLog[1];
            String ip = userLog[0];
            Integer seconds = Integer.parseInt(userLog[2]);
            if (!logs.containsKey(userName)) {
                logs.put(userName, new HashSet<>());
                userTime.put(userName, 0);
            }

            logs.get(userName).add(ip);
            userTime.put(userName, userTime.get(userName) + seconds);
        }

        logs.entrySet().stream()
                .sorted(Map.Entry.<String, HashSet<String>>comparingByKey())
                .forEach(entry -> {
                    userTime.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Integer::compareTo))
                            .forEach(pair -> {
                                if (entry.getKey().equals(pair.getKey())) {
                                    String[] arr = entry.getValue().stream().toArray(String[]::new);
                                    Arrays.sort(arr);
                                    System.out.printf("%s: %d %s\n",
                                            entry.getKey(),
                                            pair.getValue(),
                                            Arrays.toString(arr)
                                    );
                                }
                            });
                });

    }
}
