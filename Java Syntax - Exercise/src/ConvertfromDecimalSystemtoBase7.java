import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConvertfromDecimalSystemtoBase7 {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String x = Console.readLine();
            System.out.println(Integer.toString(Integer.parseInt(x, 7), 10));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
