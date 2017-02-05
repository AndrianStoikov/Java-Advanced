import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        String text = Console.readLine();

        //                                    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String matchUsernameRegex = "(?<=[ \\/\\\\().]|^)([A-Za-z][A-Za-z\\d_]{2,24})(?=[ \\/\\\\().]|$)";
        Pattern p = Pattern.compile(matchUsernameRegex);
        Matcher m  = p.matcher(text);

        ArrayList<String> validUserNames = new ArrayList<>();
        while (m.find()) {
            String username = m.group(1);
            validUserNames.add(username);
        }

        int maxLength = Integer.MIN_VALUE;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < validUserNames.size() - 1; i++) {
            String username1 = validUserNames.get(i);
            String username2 = validUserNames.get(i + 1);
            int sum = username1.length() + username2.length();
            if(sum > maxLength) {
                maxLength = sum;
                result.clear();
                result.add(username1);
                result.add(username2);
            }
        }

        result.forEach(System.out::println);
    }
}
