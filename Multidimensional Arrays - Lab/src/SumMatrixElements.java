import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
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
                for (int j = 0; j < sizes[1]; j++) {
                    matrix[i][j] = values[j];
                }
            }

            System.out.println(sizes[0]);
            System.out.println(sizes[1]);
            int sum = 0;
            for (int i = 0; i < sizes[0]; i++) {
                for (int j = 0; j < sizes[1]; j++) {
                    sum += matrix[i][j];
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
