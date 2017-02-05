import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TreeMap;


public class ParseUrls {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = Console.readLine();

            String[] reminder = input.split("://");
            if(reminder.length != 2) {
                System.out.println("Invalid URL");
                return;
            }

            String protocol = reminder[0];
            System.out.printf("Protocol = %s\n", protocol);

            int serverEndIndex = reminder[1].indexOf("/");
            String server = reminder[1].substring(0, serverEndIndex + 1);
            System.out.printf("Server = %s\n", server);
            String resource = reminder[1].substring(serverEndIndex + 1);
            System.out.printf("Resources = %s\n", resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
