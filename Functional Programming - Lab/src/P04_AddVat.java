import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.UnaryOperator;

public class P04_AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Double[] nums = Arrays.stream(Console.readLine().split(", "))
                .map(Double::parseDouble)
                .toArray(Double[]::new);

        UnaryOperator<Double> addVAT = (num) -> num *= 1.20;

        StringBuilder sb = new StringBuilder();
        sb.append("Prices with VAT:\n");
        Arrays.stream(nums).forEach(num -> {
            String output = String.format(Locale.GERMANY, "%.2f\n", addVAT.apply(num));
            sb.append(output);
        });

        System.out.println(sb);
    }
}
