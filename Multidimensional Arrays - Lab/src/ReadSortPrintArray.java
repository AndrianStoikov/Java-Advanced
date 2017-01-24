import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadSortPrintArray {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer n = Integer.parseInt(Console.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Console.readLine();
            }
            Arrays.sort(arr);
            Arrays.stream(arr).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
