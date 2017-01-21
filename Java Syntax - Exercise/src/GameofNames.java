import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameofNames {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            Integer count = Integer.parseInt(Console.readLine());
            int maxScore = Integer.MIN_VALUE;
            String bestPlayerName = "";
            for (int i = 0; i < count; i++) {
                String name = Console.readLine();
                Integer initialScore = Integer.parseInt(Console.readLine());
                int score = calculateScore(name, initialScore);
                if(score > maxScore) {
                    maxScore = score;
                    bestPlayerName = name;
                }
            }

            System.out.printf("The winner is %s - %d points", bestPlayerName, maxScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer calculateScore(String name, Integer initialScore) {
        int score = initialScore;
        for (int i = 0; i < name.length(); i++) {
            int ascii = name.charAt(i);
            if(ascii % 2 == 0) score += ascii;
            else score -= ascii;
        }
        return score;
    }
}
