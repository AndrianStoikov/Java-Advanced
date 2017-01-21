import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CollectTheCoins {
    public static void main(String[] args) throws Throwable {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[][] matrix = new String[4][];
            for (int i = 0; i < 4; i++) {
                matrix[i] = Console.readLine().split("");
            }

            String[] moves = Console.readLine().split("");
            //System.out.println(Arrays.toString(moves));
            //System.out.println(Arrays.toString(matrix[0]));

            int startRow = 0;
            int startCol = 0;
            int hitWalls = 0;
            int collectedMoney = 0;
            int oldRow = 0;
            int oldCol = 0;
            for (int i = 0; i < moves.length; i++) {
                Integer[] rowsCols = Move(moves[i], startRow, startCol);
                oldRow = startRow;
                oldCol = startCol;
                startRow = rowsCols[0];
                startCol = rowsCols[1];
                try {
                    if(matrix[startRow][startCol].equals("$")) collectedMoney++;
                } catch(IndexOutOfBoundsException wallHit) {
                    startCol = oldCol;
                    startRow = oldRow;
                    hitWalls++;
                }
            }

            System.out.printf("Coins = %d\n", collectedMoney);
            System.out.printf("Walls = %d\n", hitWalls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Integer[] Move(String value,Integer row, Integer col) {
        Integer[] a = new Integer[2];
        a[0] = row;
        a[1] = col;
        switch (value) {
            case "^": {
                a[0] = row - 1;
                return a;
            }
            case "V": {
                a[0] = row + 1;
                return a ;
            }
            case ">": {
                a[1] = col + 1;
                return a;
            }
            case "<": {
                a[1] = col - 1;
                return a;
            }
            default: return a;
        }
    }
}
