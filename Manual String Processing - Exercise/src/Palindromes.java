import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindromes {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = Console.readLine();
            TreeSet<String> palindromes = new TreeSet<>();

            Pattern p = Pattern.compile("\\w+");
            Matcher m = p.matcher(text);

            while (m.find()) {
                String word = m.group();
                if (isPalindrome(word))
                    palindromes.add(word);
            }

            System.out.println(Arrays.toString(palindromes.toArray()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i))
                return false;
        }

        return true;
    }
}
