import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RubiksMatrix {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer[] rowsCols = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            int[][] matrix = new int[rowsCols[0]][rowsCols[1]];
            InicializeTheMatrix(matrix);
            Integer n = Integer.parseInt(Console.readLine());
            for (int i = 0; i < n; i++) {
                String[] command = Console.readLine().split(" ");
                MoveRowsCols(command, matrix);
            }

            RearangeTheMatrix(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InicializeTheMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = ++sum;
            }
        }
    }

    public static void MoveRowsCols(String[] command, int[][] matrix) {
        int col = Integer.parseInt(command[0]);
        int row = Integer.parseInt(command[2]);
        int oldRow = row;
        int oldCol = col;

        int buffer = matrix[row][col];
        switch (command[1]) {
            case "up": {
                row--;
            }
            break;
            case "down": {
                row++;
            }
            break;
            case "left": {
                col--;
            }
            break;
            case "right": {
                col++;
            }
            break;
        }

        try {
            int a = matrix[oldRow][oldCol];
            int b = matrix[row][col];
            matrix[oldRow][oldCol] = matrix[row][col];
            matrix[row][col] = buffer;
        } catch (IndexOutOfBoundsException e) {
            //Do nothing
        }
    }

    public static void RearangeTheMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();


        System.out.println(sb.toString());
    }
}
