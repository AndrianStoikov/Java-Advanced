import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P06_ValidTime {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$";
        Pattern p = Pattern.compile(regex);

        try {

            while (true) {
                String text = Console.readLine();
                if ("END".equals(text)) break;

                Matcher m = p.matcher(text);
                if (m.find()) {
                    if (isValidTime(m))
                        System.out.println("valid");
                    else System.out.println("invalid");
                } else {
                    System.out.println("invalid");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidTime(Matcher m) {
        int hours = Integer.parseInt(m.group(1));
        int minutes = Integer.parseInt(m.group(2));
        int seconds = Integer.parseInt(m.group(3));

        if (!(hours >= 1 && hours <= 12))
            return false;

        if (minutes < 0 || minutes > 59)
            return false;

        if (seconds < 0 || seconds > 59)
            return false;

        if (m.group().equals("12:00:00 PM"))
            return false;


        return true;
    }
}
