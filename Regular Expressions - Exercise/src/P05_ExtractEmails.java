import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^((?!-|\\.|_.)[\\w-.]+(?<!-|\\.|_))@((?!-|\\.|_.)[A-z-.]+(?<!-|\\.|_))((?=\\.|,|$))";
        StringBuilder sb = new StringBuilder();
        while (true) {
            String text = Console.readLine();
            if ("end".equals(text)) break;

            sb.append(text);
        }

        String[] workingText = sb.toString().split(" ");
        sb.setLength(0);
        Pattern p = Pattern.compile(regex);

        for (int i = 0; i < workingText.length; i++) {
            String email = workingText[i];
            Matcher m = p.matcher(email);
            while (m.find()) {
                String secondGroup = m.group(2);
                if (secondGroup.split("\\.").length >= 2) {
                    sb.append(m.group()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
