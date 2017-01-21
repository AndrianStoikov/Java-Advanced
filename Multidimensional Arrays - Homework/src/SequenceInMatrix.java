import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SequenceInMatrix {
    public static void main(String[] args) {
        //input N, A
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {

            //3 4
            //ha fifi ho hi
            //fo ha hi xx
            //xxx ho ha xx

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

            ArrayList<String> maxSequence = new ArrayList<>();
            ArrayList<String> maskSequence = new ArrayList<>();

            //Iterate from top left to bottom right
            for( int k = 0 ; k < rowsCols[0] * 2 ; k++ ) {
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    if( i < rowsCols[0] && j < rowsCols[0] ) {
                        addElementIfNecesery(maskSequence, matrix[i][j]);
                        if(maskSequence.size() > maxSequence.size()){
                            maxSequence = new ArrayList<>(maskSequence);
                            maskSequence.clear();
                        }
                    }
                }
            }

            //Iterate Top right to bottom left
            maskSequence.clear();
            for (int slice = 0; slice < rowsCols[0]*2-1; slice++) {
                int z = slice < rowsCols[0] ? 0 : slice - rowsCols[0] + 1;
                for (int rows = z; rows <= slice - z; ++rows) {
                    int cols=(rowsCols[1]-1)-(slice-rows);
                    addElementIfNecesery(maskSequence, matrix[rows][cols]);
                    if(maskSequence.size() > maxSequence.size()){
                        maxSequence = new ArrayList<>(maskSequence);
                        maskSequence.clear();
                    }
                }
                System.out.println();
            }

            for (int rows = 0; rows < rowsCols[0]; rows++) {
                for (int cols = 0; cols < rowsCols[1]; cols++) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addElementIfNecesery(ArrayList<String> arr, String element) {
        if(arr.size() == 0) {
            arr.add(element);
            return;
        };

        if(arr.get(arr.size() - 1).equals(element)) {
            arr.add(element);
        }  else {
            arr.clear();
            arr.add(element);
        }
    }
}
