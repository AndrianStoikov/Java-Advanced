import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

/**
 * Created by Andrian on 21.1.2017 г..
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer input = Integer.parseInt(Console.readLine());
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

            if(input == 0) {
                System.out.println("0");
                return;
            }

            while(input != 0) {
                stack.push(input % 2);
                input /= 2;
            }

            for (Integer num :
                    stack) {
                System.out.print(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
