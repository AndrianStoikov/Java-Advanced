import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Integer[] sequence = Arrays.stream(Console.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> smallestElementIndex = (array) -> {
            int minIndex = 0;
            int minNumber = array[0];
            for (int i = 0; i < array.length; i++) {
                if(array[i] <= minNumber) {
                    minIndex = i;
                    minNumber = array[i];
                }
            }

            return minIndex;
        };


        System.out.println(smallestElementIndex.apply(sequence));
    }
}
