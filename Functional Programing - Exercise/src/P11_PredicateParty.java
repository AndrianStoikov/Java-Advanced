import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> names = Arrays.stream(Console.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayList::new));


        while (true) {
            String[] input = Console.readLine().split(" ");
            if (input[0].equals("Party!")) break;

            if (input[0].equals("Remove")) {
                BiPredicate<String, String> filter = createChecker(input[1]);
                names = names.stream()
                        .filter(a -> !filter.test(input[2], a))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                BiPredicate<String,String> checker = createChecker(input[1]);
                ArrayList<String> result = new ArrayList<>();
                for (int i = 0; i < names.size(); i++) {
                    if(checker.test(input[2], names.get(i))) {
                        result.add(names.get(i));
                    }
                    result.add(names.get(i));
                }

                names = (ArrayList<String>)result.clone();
            }
        }


        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            String output = String.format("%s", String.join(", ", names));
            System.out.printf("%s are going to the party!", output);
        }
    }

    private static BiPredicate<String, String> createChecker(String crt) {
        switch (crt) {
            case "StartsWith":
                return (s, name) -> name.startsWith(s);
            case "EndsWith":
                return (s, name) -> name.endsWith(s);
            case "Length":
                return (s, name) -> name.length() == Integer.parseInt(s);
            default: return null;
        }
    }
}