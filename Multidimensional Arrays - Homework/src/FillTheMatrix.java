import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = Console.readLine().split(", ");
            Integer size  = Integer.parseInt(input[0]);
            String pattern  = input[1];

            Integer[][] matrix = new Integer[size][size];
            if(pattern.equals("A")) matrixA(matrix);
            else matrixB(matrix);

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matrixB(Integer[][] matrix) {
        int num = 1;
        for (int row = 0; row < matrix.length; row++) {
            if(row % 2 == 0) {
                for (int i = 0; i < matrix[row].length; i++) {
                    matrix[i][row] = num++;
                }
            } else {
                for (int i = matrix[row].length - 1; i >= 0; i--) {
                    matrix[i][row] = num++;
                }
            }

        }
    }

    private static void matrixA(Integer[][] matrix) {
        int num = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int i = 0; i < matrix[row].length; i++) {
                matrix[i][row] = num++;
            }
        }
    }
}
