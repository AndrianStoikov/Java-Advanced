import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class GroupNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer[] numbers = Arrays.stream(Console.readLine().split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            map.put(0, new ArrayList<>());
            map.put(1, new ArrayList<>());
            map.put(2, new ArrayList<>());
            for (int i = 0; i < numbers.length; i++) {
                int reminder = Math.abs(numbers[i] % 3);
                ArrayList<Integer> mask = new ArrayList<>();
                mask.add(numbers[i]);
                map.get(reminder).forEach(mask::add);
                map.put(reminder, mask);
            }

            for (Integer key : map.keySet()) {
                Collections.reverse(map.get(key));
                map.get(key).forEach(a -> System.out.print(a + " "));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
