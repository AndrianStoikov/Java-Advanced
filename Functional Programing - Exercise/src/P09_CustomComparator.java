import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P09_CustomComparator {
    public static void main(String[] args) {
        Integer[] names;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = console.readLine();
            names = Arrays.stream(Arrays.stream(input.split(" "))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray()).boxed().toArray(Integer[]::new);

            names = Arrays.stream(names).sorted(P09_CustomComparator::OddBeforeEven).toArray(Integer[]::new);

            String[] result = Arrays.toString(names).split("[\\[\\]]")[1].split(", ");
            System.out.println(String.join(" ", result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer OddBeforeEven (Integer x,Integer y) {
        if(x % 2 == 0 && y % 2 != 0) {
            return -1;
        }

        if (x % 2 != 0 && y % 2 == 0){
            return 1;
        }


        if (x % 2 == 0 && y % 2 == 0){
            if(x < y) return -1;
            if(x == y) return 0;
            if(x > y) return 1;
        }

        if(x < y) return -1;
        if(x == y) return 0;
        if(x > y) return 1;
        return 0;
    }
}
