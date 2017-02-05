import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertNto10 {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] nums = Console.readLine().split(" ");

            BigInteger baseN = new BigInteger(nums[0]);
            String number = nums[1];

            StringBuilder sb = new StringBuilder();

            System.out.println(rebase(number, baseN));


            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BigInteger rebase(String number, BigInteger base)
    {
        final String SYMBOLS = "0123456789ABCDEF";
        BigInteger result = new BigInteger("0");
        int position = number.length(); //we start from the last digit in a String (lowest value)
        for (char ch : number.toCharArray())
        {
            BigInteger value = new BigInteger("" + SYMBOLS.indexOf(ch));
            result = result.add(value.multiply(base.pow(--position)));

        }
        return result;
    }

}
