import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class VoinaGame {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers();
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers();

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty())
                break;

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }

        if (firstPlayer.size() > secondPlayer.size())
            System.out.println("First player win!");
        else if (secondPlayer.size() > firstPlayer.size())
            System.out.println("Second player win!");
        else
            System.out.println("Draw!");
    }

    private static LinkedHashSet<Integer> getPlayerNumbers() throws IOException {
        String input = CONSOLE.readLine();

        LinkedHashSet<Integer> parsedNumbers = new LinkedHashSet<>();

        StringTokenizer numbers = new StringTokenizer(input);
        while (numbers.hasMoreTokens()) {
            Integer n = Integer.valueOf(numbers.nextToken());
            parsedNumbers.add(n);
        }

        return parsedNumbers;
    }
}
