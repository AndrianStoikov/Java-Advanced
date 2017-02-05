import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = Console.readLine();
            StringBuilder sb = new StringBuilder(20);
            sb.append(input);

            String s = "*";
            String str = new String(new char[20 - input.length()]).replace("\0", s);
            sb.append(str);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
