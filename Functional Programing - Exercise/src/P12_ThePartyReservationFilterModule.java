import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class P12_ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> names = Arrays.stream(Console.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayList::new));

        HashMap<String, ArrayList<String>> filter = new HashMap<>();

        while(true) {
            String[] input = Console.readLine().split(";");
            if("Print".equals(input[0])) {
                for (String crt : filter.keySet()) {
                    BiPredicate<String,String> checker = createChecker(crt);
                    ArrayList<String> crtVals = filter.get(crt);
                    for (String crtVal : crtVals) {
                        names = names.stream().filter(a -> !checker.test(crtVal, a))
                        .collect(Collectors.toCollection(ArrayList::new));
                    }
                }
                break;
            }

            if(input[0].equals("Add filter")) {
                if(!filter.containsKey(input[1]))
                    filter.put(input[1], new ArrayList<>());

                filter.get(input[1]).add(input[2]);
            } else {
                if(filter.containsKey(input[1])) {
                    int ind =  filter.get(input[1]).indexOf(input[2]);
                    filter.get(input[1]).remove(ind);
                }
            }
        }

        System.out.println(String.join(" ", names));
    }

    private static BiPredicate<String, String> createChecker(String crt) {
            if(crt.equals("Starts with"))
                return (s, name) -> name.startsWith(s);

            if(crt.equals("Ends with"))
                return (s, name) -> name.endsWith(s);

            if(crt.equals("Length"))
                return (s, name) -> name.length() == Integer.parseInt(s);

            if(crt.equals("Contains"))
                return (s, name) -> name.contains(s);

            return (s, name) -> name.startsWith(name);
    }
}

