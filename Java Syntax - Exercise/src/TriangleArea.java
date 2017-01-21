import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            int[] input = Arrays.stream(Console.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Integer Ax = input[0];
            Integer Ay = input[1];

            input = Arrays.stream(Console.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Integer Bx = input[0];
            Integer By = input[1];

            input = Arrays.stream(Console.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Integer Cx = input[0];
            Integer Cy = input[1];

            Integer Area = (Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By) ) / 2;
            System.out.println(Math.abs(Area));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
