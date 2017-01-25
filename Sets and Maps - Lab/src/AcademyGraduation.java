import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;


public class AcademyGraduation {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Double[]> map = new TreeMap<>();
        try {
            Integer n = Integer.parseInt(Console.readLine());

            for (int i = 0; i < n; i++) {
                String name = Console.readLine();
                Double[] score = Arrays.stream(Console.readLine().split(" "))
                        .map(Double::parseDouble)
                        .toArray(Double[]::new);
                map.put(name, score);
            }

            StringBuilder sb = new StringBuilder();
            for (String s : map.keySet()) {
                Double averageScore = Average(map.get(s));
                sb.append(s).append(" is graduated with ").append(averageScore).append("\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Double Average(Double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }
}
