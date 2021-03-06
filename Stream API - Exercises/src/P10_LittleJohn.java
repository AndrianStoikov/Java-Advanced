import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int small = 0, medium = 0, large = 0;

        Pattern pattern = Pattern.compile("(?<small>>-{5}>)|(?<medium>>>-{5}>)|(>>>-{5}>>)");
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                if(matcher.group("small") != null)
                    small++;
                else if(matcher.group("medium") != null)
                    medium++;
                else
                    large++;
            }
        }
        String sum = small + "" + medium + "" + large;
        String binary = Integer.toBinaryString(Integer.valueOf(sum));
        String reversedBinary = new StringBuilder(Integer.toBinaryString(Integer.valueOf(sum)) + "").reverse()+ "";
        System.out.println(Integer.valueOf(binary + reversedBinary, 2));
    }
}