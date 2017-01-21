import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            Integer kilometers = Integer.parseInt(Console.readLine());
            String time = Console.readLine().trim();

            Double price = Double.parseDouble("0");
            Double pricePerKilometer = 0.0;
            if(kilometers < 20) {
                price += 0.70;
                if(time.equals("day")) pricePerKilometer = 0.79;
                else pricePerKilometer = 0.90;
                price += pricePerKilometer * kilometers;
            } else if(kilometers >= 20 && kilometers < 100) {
                pricePerKilometer = 0.09;
                price = pricePerKilometer * kilometers;
            } else {
                pricePerKilometer = 0.06;
                price = pricePerKilometer * kilometers;
            }

            System.out.printf("%.2f", price);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
