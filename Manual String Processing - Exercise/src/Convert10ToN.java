import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;


public class Convert10ToN {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] nums = Console.readLine().split(" ");

            String number = nums[0];
            BigInteger base10 = new BigInteger(nums[1]);

            StringBuilder sb = new StringBuilder();

            while(base10.compareTo(new BigInteger("0")) > 0) {
                BigInteger reminder = base10.divideAndRemainder(new BigInteger(number))[1];
                BigInteger divide = base10.divideAndRemainder(new BigInteger(number))[0];
                sb.insert(0, reminder);
                base10 = divide;
            }


            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
