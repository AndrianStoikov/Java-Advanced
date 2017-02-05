import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P07_ValidUsernames {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^[\\w-]{3,16}$";
        Pattern p = Pattern.compile(regex);

        try {
            while (true) {
                String username = Console.readLine();
                if("END".equals(username)) break;

                if(username.matches(regex)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
