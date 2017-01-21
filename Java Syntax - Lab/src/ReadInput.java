import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String firstString = scanner.next("\\w+");
        String secondString = scanner.next("\\w+");
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        scanner.nextLine();
        String nextLine = scanner.nextLine();
        System.out.printf("%s %s %s %d", firstString, secondString, nextLine, a1 + a2 + a3);
    }
}
