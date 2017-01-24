import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;


public class Voina {
    public static void main(String[] args) {
        TreeSet<Integer> playerOne = new TreeSet<>();
        TreeSet<Integer> playerTwo = new TreeSet<>();

        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Collections.addAll(playerOne, Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new));

            Collections.addAll(playerTwo, Arrays.stream(Console.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new));

            for (int i = 0; i < 50; i++) {
                int playerOneTop = playerOne.first();
                int playerTwoTop = playerTwo.first();
                if(playerOneTop > playerTwoTop)
                    playerOne.ceiling(playerOneTop + playerTwoTop);
                else {
                    playerTwo.ceiling(playerOneTop + playerTwoTop);
                }
                if(playerOne.isEmpty()) {
                    System.out.println("Second Player Win!");
                    return;
                } else if(playerTwo.isEmpty()){
                    System.out.println("First Player Win!");
                    return;
                }
            }

            System.out.println("Draw");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
