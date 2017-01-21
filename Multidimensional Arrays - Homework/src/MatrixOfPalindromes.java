import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] rowsCols = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            String[][] matrix = new String[rowsCols[0]][rowsCols[1]];

            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    String firstAndLastLetter = Character.toString((char)((int)'a' + rows));
                    String middleLetter = Character.toString((char)((int)firstAndLastLetter.toCharArray()[0] + cols));
                    matrix[rows][cols] = firstAndLastLetter + middleLetter + firstAndLastLetter;
                }
            }

            Printer(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Printer(String[][] matrix) {
        for (String[] aMatrix : matrix) {
            for (String anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
