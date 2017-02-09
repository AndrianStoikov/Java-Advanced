import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class P07_PredicateForNames {
    public static void main(String[] args) {
        String[] names;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            int size = Integer.parseInt(console.readLine());
            String input = console.readLine();
            names = input.split(" ");

            Function<String[], String[]> filterArray = arrayOfNames -> {
                List<String> result = new ArrayList<>();
                for (int i = 0,j = 0; i < arrayOfNames.length; i++) {
                    if(arrayOfNames[i].length() <= size) {
                        result.add(arrayOfNames[i]);
                    }
                }

                return result.toArray(new String[result.size()]);
            };

            Consumer<String[]> printer = a -> {
                for (String name :
                        a) {
                    System.out.println(name);
                }
            } ;

            names = filterArray.apply(names);
            printer.accept(names);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
