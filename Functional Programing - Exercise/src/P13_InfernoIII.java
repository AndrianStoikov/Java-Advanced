import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class P13_InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nums = Arrays.stream(Console.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        LinkedHashMap<String, ArrayList<Integer>> commands = new LinkedHashMap<>();

        while (true) {
            String[] input = Console.readLine().split(";");
            if ("Forge".equals(input[0])) {
                ArrayList<Integer> result = new ArrayList<>();
                result.addAll(removeNums(nums, commands));
                for (Integer integer : result) {
                    System.out.printf("%d ", integer);
                }
                break;
            }

            if ("Exclude".equals(input[0])) {
                if (!commands.containsKey(input[1]))
                    commands.put(input[1], new ArrayList<>());

                commands.get(input[1]).add(Integer.valueOf(input[2]));
            } else {
                int ind = commands.get(input[1]).indexOf(Integer.valueOf(input[2]));
                commands.get(input[1]).remove(ind);
            }
        }
    }

    private static ArrayList<Integer> removeNums(ArrayList<Integer> nums,
                                                 LinkedHashMap<String, ArrayList<Integer>> commands) {

        ArrayList<Integer> indexToRemove = new ArrayList<>();

        for (String command : commands.keySet()) {
            ArrayList<Integer> values = commands.get(command);
            for (Integer value : values) {
                for (int i = 0; i < nums.size(); i++) {
                    int sum = getSum(i, command, nums);
                    if (value == sum)
                        indexToRemove.add(i);
                }
            }
        }

        ArrayList<Integer> newNums = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if(!indexToRemove.contains(i))
                newNums.add(nums.get(i));
        }

        return newNums;
    }

    private static int getSum(int i, String command, ArrayList<Integer> nums) {
        int lastIndex = 0;
        if ("Sum Left".equals(command)) {
            lastIndex = i;
            i--;
        }
        if ("Sum Right".equals(command)) lastIndex = i + 1;
        if ("Sum Left Right".equals(command)) {
            lastIndex = i + 1;
            i--;
        }

        int sum = 0;
        for (int j = i; j <= lastIndex; j++) {
            int num;
            try {
                num = nums.get(j);
            } catch (IndexOutOfBoundsException e) {
                num = 0;
            }

            sum += num;
        }

        return sum;
    }
}
