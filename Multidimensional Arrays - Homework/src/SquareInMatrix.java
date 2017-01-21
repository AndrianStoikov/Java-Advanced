import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SquareInMatrix {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] rowsCols = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            String[][] matrix = new String[rowsCols[0]][rowsCols[1]];

            for (int rows = 0; rows < rowsCols[0]; rows++) {
                String[] input = Console.readLine().split(" ");
                for (int cols = 0; cols < rowsCols[1]; cols++) {
                    matrix[rows][cols] = input[cols];
                }
            }

            int count = 0;
            for (int rows = 0; rows < rowsCols[0] - 1; rows++) {
                for (int cols = 0; cols < rowsCols[1] - 1; cols++) {
                    boolean isSquare = true;
                    for (int i = rows; i <= rows + 1; i++) {
                            if(!matrix[i][cols].equals(matrix[i][cols + 1])) isSquare = false;
                    }
                    if(isSquare) count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
