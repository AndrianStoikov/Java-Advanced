import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BlurFilter {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            Long blurAmount = Long.parseLong(Console.readLine());
            Integer[] sizes = Arrays.stream(Console.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            long[][] matrix = new long[sizes[0]][sizes[1]];
            for (int rows = 0; rows < sizes[0]; rows++) {
                Long[] nums = Arrays.stream(Console.readLine().split("\\s+"))
                        .map(Long::parseLong)
                        .toArray(Long[]::new);
                for (int cols = 0; cols < sizes[1]; cols++) {
                    matrix[rows][cols] = nums[cols];
                }
            }

            Integer[] coordinates = Arrays.stream(Console.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            int minCol = Math.max(coordinates[1] - 1, 0);
            int maxCol = Math.min(coordinates[1] + 1, sizes[1] - 1);

            int minRow = Math.max(coordinates[0] - 1, 0);
            int maxRow = Math.min(coordinates[0] + 1, sizes[0] - 1);

            for (int row = minRow; row <= maxRow; row++) {
                for (int col = minCol; col <= maxCol; col++) {
                        matrix[row][col] += blurAmount;
                }
            }

            for (int row = 0; row < sizes[0]; row++) {
                for (int col = 0; col < sizes[1]; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
