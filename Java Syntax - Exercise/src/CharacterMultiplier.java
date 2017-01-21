import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String[] strings = Console.readLine().split("\\s+");
            System.out.println(Multiplier(strings[0], strings[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer Multiplier(String a, String b) {
        int sum = 0;

        int minSize = Math.min(a.length(), b.length());
        int maxSize = Math.max(a.length(), b.length());

        String biggerString = a.length() >= b.length() ? "a" : "b";

        for (int i = 0; i < maxSize; i++) {
            if(i < minSize)
                sum += a.charAt(i) * a.charAt(i);
            else if(biggerString.equals("a"))
                sum += a.charAt(i);
            else if(biggerString.equals("b"))
                sum += b.charAt(i);
        }
        return sum;
    }
}
