import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MathPotato {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] kids = Console.readLine().split("\\s+");
            Integer n = Integer.parseInt(Console.readLine());
            ArrayDeque<String> queue = new ArrayDeque<>();
            Collections.addAll(queue, kids);

            int cycle = 1;
            while(queue.size() > 1) {
                for (int i = 1; i < n; i++) {
                    queue.offer(queue.poll());
                }

                if(isPrime(cycle)) {
                    System.out.println("Prime is " + queue.getFirst());
                } else {
                    System.out.println("Removed " + queue.removeFirst());
                }
                cycle++;
            }

            System.out.println("Last is " + queue.getFirst());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean isPrime(Integer number) {
        if(number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }

        return true;
    }
}
