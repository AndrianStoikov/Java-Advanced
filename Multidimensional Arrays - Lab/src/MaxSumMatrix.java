import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumMatrix {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] sizes = Arrays.stream(Console.readLine().split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Integer[][] matrix = new Integer[sizes[0]][sizes[1]];

            for (int i = 0; i < sizes[0]; i++) {
                Integer[] values = Arrays.stream(Console.readLine().split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
                System.arraycopy(values, 0, matrix[i], 0, sizes[1]);
            }


            int maxSum = Integer.MIN_VALUE;
            int maxRow = 0;
            int maxCol = 0;
            for (int row = 0; row < sizes[0] - 1; row++) {
                for (int col = 0; col < sizes[1] - 1; col++) {
                    int minRow = row;
                    int minCol = col;
                    int sum = 0;

                    for (int i = row; i <= minRow + 1; i++) {
                        for (int j = col; j <= minCol + 1; j++) {
                            sum += matrix[i][j];
                        }
                    }

                    if(sum > maxSum) {
                        maxSum = sum;
                        maxRow = row;
                        maxCol = col;
                    }
                }
            }

            maxSum = 0;
            for (int i = maxRow; i <= maxRow + 1; i++) {
                for (int j = maxCol; j <= maxCol + 1; j++) {
                    maxSum += matrix[i][j];
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(maxSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
