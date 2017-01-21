import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class PalindromeChecker {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String word = Console.readLine();
            ArrayDeque<String> stringArrayDeque = new ArrayDeque<String>();
            Collections.addAll(stringArrayDeque, word.split(""));

            int size = stringArrayDeque.size() / 2;
            boolean isPalindrome = true;
            for (int i = 0; i < size; i++) {
                String first = stringArrayDeque.removeFirst();
                String last = stringArrayDeque.removeLast();
                if(!first.equals(last)) isPalindrome = false;
            }

            System.out.println(isPalindrome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
