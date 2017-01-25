import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> phoneBook = new HashMap<>();

        try {
            while(true) {
                String input = Console.readLine();
                if("search".equals(input)) {
                    break;
                }
                String[] namePhone = input.split("-");
                phoneBook.put(namePhone[0], namePhone[1]);
            }

            while(true) {
                String input = Console.readLine();
                if("stop".equals(input)) {
                    break;
                }
                if(phoneBook.containsKey(input)) {
                    System.out.printf("%s -> %s\n", input, phoneBook.get(input));
                } else {
                    System.out.printf("Contact %s does not exist.\n", input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
