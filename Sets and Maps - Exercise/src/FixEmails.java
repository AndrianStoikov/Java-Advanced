import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class FixEmails {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        LinkedList<String> invalidEmails = new LinkedList<>(Arrays.asList("us", "com", "uk"));
        try {
            while(true) {
                String name = Console.readLine();
                if("stop".equals(name)) {
                    break;
                }
                String email = Console.readLine();
                String[] input = email.split("@");

                String asd = input[1];
                String[] domain = asd.split("\\.");
                String lastPart = domain[domain.length - 1].toLowerCase();
                if(!invalidEmails.contains(lastPart)) {
                    emails.put(name, email);
                }
            }

            for (String s : emails.keySet()) {
                System.out.printf("%s -> %s\n", s, emails.get(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
