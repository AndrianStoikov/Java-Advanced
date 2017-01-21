import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] rowsCols = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Integer[][] matrix = new Integer[rowsCols[0]][rowsCols[1]];

            for (int rows = 0; rows < rowsCols[0]; rows++) {
                Integer[] input = Arrays.stream(Console.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
                for (int cols = 0; cols < rowsCols[1]; cols++) {
                    matrix[rows][cols] = input[cols];
                }
            }

            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            int maxMatrixRow = 0;
            int maxMatrixCol = 0;
            for (int rows = 0; rows < rowsCols[0] - 2; rows++) {
                for (int cols = 0; cols < rowsCols[1]- 2; cols++) {
                    sum = 0;
                    for (int i = rows; i <= rows + 2; i++) {
                        for (int j = cols; j <= cols + 2; j++) {
                            sum += matrix[i][j];
                        }
                    }
                    if(sum > maxSum) {
                        maxMatrixRow = rows;
                        maxMatrixCol = cols;
                        maxSum = sum;
                    }
                }
            }

            System.out.println("Sum = " + maxSum);
            for (int rows = maxMatrixRow; rows < maxMatrixRow + 3; rows++) {
                for (int cols = maxMatrixCol; cols < maxMatrixCol + 3; cols++) {
                    System.out.print(matrix[rows][cols] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
