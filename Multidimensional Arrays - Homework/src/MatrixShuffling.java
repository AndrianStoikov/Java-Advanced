import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] dimensions = Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            String[][] matrix = new String[dimensions[0]][dimensions[1]];
            for (int rows = 0; rows < dimensions[0]; rows++) {
                matrix[rows] = Arrays.stream(Console.readLine().split(" "))
                        .toArray(String[]::new);
            }

            String command = Console.readLine();
            while(!command.equals("END")) {
                if(isValidCommand(command, matrix)) {
                    String[] arr = command.split(" ");
                    Integer row1 = Integer.parseInt(arr[1]);
                    Integer col1 = Integer.parseInt(arr[2]);
                    Integer row2 = Integer.parseInt(arr[3]);
                    Integer col2 = Integer.parseInt(arr[4]);
                    String buf = "";
                    buf = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = buf;
                    Print(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
                command = Console.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean isValidCommand(String command, String[][] matrixToCheck) {
        String[] arr = command.split(" ");
        if(arr.length != 5) return  false;
        if(!arr[0].equals("swap")) return false;
        Integer row1 = Integer.parseInt(arr[1]);
        Integer col1 = Integer.parseInt(arr[2]);
        Integer row2 = Integer.parseInt(arr[3]);
        Integer col2 = Integer.parseInt(arr[4]);

        try {
            matrixToCheck[row1][col1] = matrixToCheck[row1][col1];
            matrixToCheck[row2][col2] = matrixToCheck[row2][col2];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public static void Print(String[][] matrixToPrint) {
        for (String[] Stringers : matrixToPrint) {
            for (String integer : Stringers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
