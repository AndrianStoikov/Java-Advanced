import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> names = Arrays.stream(Console.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayList::new));


        Predicate<String[]> predicate = (arguments) -> {
            switch (arguments[1]) {
                case "StartsWith": return arguments[0].startsWith(arguments[2]);
                case "Length ": return arguments[0].length() == Integer.parseInt(arguments[2]);
                case "EndsWith ": return arguments[0].endsWith(arguments[2]);
            }

            return true;
        };


        while (true) {
            String[] command = Console.readLine().split(" ");
            if ("Party!".equals(command[0])) break;

            if(command[0].equals("Remove")) {
                names = names.stream().filter(a -> predicate
                        .test(new String[]{a, command[1], command[2]}))
                            .collect(Collectors.toCollection(ArrayList::new));
            } else {
                //TODO
            }
        }
    }
}
