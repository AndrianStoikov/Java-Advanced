import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] plants = new int[n];
        Deque<Integer> previousPlantData = new ArrayDeque<>();

        for (int i = 0; i < plants.length; i++) {
            plants[i] = scanner.nextInt();
        }

        int[] days = new int[plants.length];
        previousPlantData.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (previousPlantData.size() > 0 && plants[previousPlantData.peek()] >= plants[x]) {
                maxDays = Integer.max(days[previousPlantData.pop()], maxDays);
            }
            if (previousPlantData.size() > 0) {
                days[x] = maxDays + 1;
            }
            previousPlantData.push(x);
        }

        Arrays.sort(days);
        int max = days[days.length-1];
        System.out.println(max);
    }
}