import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MelrahShake {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String text = Console.readLine();
            String pattern = Console.readLine();

            StringBuilder sb = new StringBuilder(text);
            while (pattern.length() > 0) {
                int occurences = findOccurences(text, pattern);
                if (occurences < 1) {
                    break;
                }

                if (occurences == 1) {
                    int startIndex = sb.indexOf(pattern);
                    sb = sb.replace(startIndex, startIndex + pattern.length(), "");
                } else {
                    int startIndex = sb.indexOf(pattern);
                    sb = sb.replace(startIndex, startIndex + pattern.length(), "");

                    int lastIndexOf = sb.lastIndexOf(pattern);
                    sb = sb.replace(lastIndexOf, lastIndexOf + pattern.length(), "");
                }

                try {
                    int index = pattern.length() / 2;
                    StringBuilder pat = new StringBuilder(pattern);
                    pat = pat.replace(index, index + 1, "");
                    pattern = pat.toString();
                } catch (IndexOutOfBoundsException e) {
                    pattern = "";
                }

                System.out.println("Shaked it.");
            }

            System.out.println("No shake.");
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer findOccurences(String string, String pattern) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = string.indexOf(pattern, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += pattern.length();
            }
        }
        return count;
    }
}
