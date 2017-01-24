import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PascalTriangle {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            int height = Integer.parseInt(Console.readLine());

            long[][] pascal = new long[height][];
            for (int i = 0; i < height; i++) {
                pascal[i] = new long[i + 1];
            }

            pascal[0][0] = 1;

            for (int row = 1; row < height; row++) {
                pascal[row][0] = 1;
                pascal[row][pascal[row].length - 1] = 1;
                for (int col = 1; col < pascal[row].length - 1; col++) {
                    pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
                }
            }

            for (long[] ints : pascal) {
                for (long anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
