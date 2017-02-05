import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = Console.readLine().split(" ");

            int result = multiplyChars(strings);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int multiplyChars(String[] strings) {
        int sum = 0;
        int size = Math.min(strings[0].length(), strings[1].length());

        for (int i = 0; i < size; i++) {
            sum += (strings[0].charAt(i) * strings[1].charAt(i));
        }

        String remaining;
        if(strings[0].length() == size) {
            remaining = strings[1].substring(size);
        } else {
            remaining = strings[0].substring(size);
        }

        for (int i = 0; i < remaining.length(); i++) {
            sum += remaining.charAt(i);
        }

        return sum;
    }


}
