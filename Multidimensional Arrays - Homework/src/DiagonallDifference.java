import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonallDifference {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer n = Integer.parseInt(Console.readLine());
            int[][] matrix = new int[n][n];

            for (int rows = 0; rows < n; rows++) {
                Integer[] nums = Arrays.stream(Console.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
                for (int cols = 0; cols < n; cols++) {
                    matrix[rows][cols] = nums[cols];
                }
            }

            int primaryDiagonaSum = 0, secondaryDiagonalSum = 0;
            int size = matrix.length -1;
            for(int i = 0; i<matrix.length; i++){
                primaryDiagonaSum += matrix[i][i];
                secondaryDiagonalSum+= matrix[i][size-i];
            }

            System.out.println(Math.abs(primaryDiagonaSum - secondaryDiagonalSum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
