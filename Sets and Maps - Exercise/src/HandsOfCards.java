import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> playerScores = new LinkedHashMap<>();
        HashMap<String, Integer> cardsPower = new HashMap<>();
        cardsPower.put("1", 1);
        cardsPower.put("2", 2);
        cardsPower.put("3", 3);
        cardsPower.put("4", 4);
        cardsPower.put("5", 5);
        cardsPower.put("6", 6);
        cardsPower.put("7", 7);
        cardsPower.put("8", 8);
        cardsPower.put("9", 9);
        cardsPower.put("10", 10);
        cardsPower.put("J", 11);
        cardsPower.put("Q", 12);
        cardsPower.put("K", 13);
        cardsPower.put("A", 14);


        HashMap<String, Integer> MultiPliers = new HashMap<>();
        MultiPliers.put("S", 4);
        MultiPliers.put("H", 3);
        MultiPliers.put("D", 2);
        MultiPliers.put("C", 1);

        try {
            while(true) {
                String namePlusCards = Console.readLine();
                if("JOKER".equals(namePlusCards)) {
                    break;
                }

                String[] nameCards = namePlusCards.split(":");
                String name = nameCards[0];
                HashSet<String> cards = new HashSet<>(Arrays.asList(nameCards[1].trim().split(", ")));
                Iterator<String> it = cards.iterator();

                int score = 0;
                while (it.hasNext()) {
                    String value = it.next();
                    String multiplier = value.substring(value.length() - 1, value.length());
                    String card = value.substring(0, value.length() - 1);
                    int result = cardsPower.get(card) * MultiPliers.get(multiplier);
                    score += result;
                }

                if(!playerScores.containsKey(name))
                    playerScores.put(name, 0);
                playerScores.put(name, playerScores.get(name) + score);
            }

            for (String name : playerScores.keySet()) {
                System.out.printf("%s: %s\n", name, playerScores.get(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
