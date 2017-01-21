import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            String[] input = Console.readLine().split("\\s+");
            Integer a = Integer.parseInt(input[0]);
            Double b = Double.parseDouble(input[1]);
            Double c = Double.parseDouble(input[2]);

            System.out.printf("|%s|%s|%s|%s|",
                    String.format("%-10s", Integer.toHexString(a).toUpperCase()),
                    String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0'),
                    String.format("%10.2f", b),
                    String.format("%-10.3f", c));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
