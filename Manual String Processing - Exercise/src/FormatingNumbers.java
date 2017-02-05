import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;

public class FormatingNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] values = Console.readLine().split("\\s++");

            Integer a = Integer.parseInt(values[0]);
            Double b = Double.parseDouble(values[1]);
            Double c = Double.parseDouble(values[2]);

            String binaryStringA = Integer.toBinaryString(a);
            while (binaryStringA.length() < 10) {
                binaryStringA = "0" + binaryStringA;
            }

            if(binaryStringA.length() > 10) {
                binaryStringA = binaryStringA.substring(0 , 10);
            }

            StringBuilder sb = new StringBuilder();

            sb.append("|").append(String.format("%-10X", a));
            sb.append("|").append(String.format("%s", binaryStringA));
            sb.append("|").append(String.format("%10.2f", b));
            sb.append("|").append(String.format("%-10.3f", c));
            sb.append("|");
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
