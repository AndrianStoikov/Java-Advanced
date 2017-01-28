import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, LinkedHashMap<String, ArrayList<String>>> users = new HashMap<>();

        while (true) {
            String input = Console.readLine();
            if ("end".equals(input)) {
                break;
            }

            String[] messages = input.split(" ");
            String[] ip = messages[0].split("=");
            String[] message = messages[1].split("=");
            String[] userName = messages[2].split("=");

            if (!users.containsKey(userName[1])) {
                users.put(userName[1], new LinkedHashMap<>());
                users.get(userName[1]).put(ip[1], new ArrayList<>());
            }

            if (!users.get(userName[1]).containsKey(ip[1])) {
                users.get(userName[1]).put(ip[1], new ArrayList<>());
            }

            users.get(userName[1]).get(ip[1]).add(message[1]);
        }

        TreeMap<String, LinkedHashMap<String, ArrayList<String>>> finalMap = new TreeMap<>();
        finalMap.putAll(users);

        for (String username : finalMap.keySet()) {
            System.out.printf("%s: \n", username);

            Iterator<String> it = finalMap.get(username).keySet().iterator();
            while (it.hasNext()) {
                String ip = it.next();
                if (it.hasNext()) {
                    System.out.printf("%s => %d, ", ip, finalMap.get(username).get(ip).size());
                } else {
                    System.out.printf("%s => %d. \n", ip, finalMap.get(username).get(ip).size());
                }
            }
        }
    }
}
