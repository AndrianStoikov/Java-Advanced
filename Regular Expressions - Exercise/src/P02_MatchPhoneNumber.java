import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_MatchPhoneNumber {

    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^(\\+359)( |-)(2)\\2(\\d{3})\\2(\\d{4})$";
        try {
            while(true) {
                String phoneNumber = Console.readLine();
                if("end".equals(phoneNumber))
                    break;

                if(phoneNumber.matches(regex))
                    System.out.println(phoneNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
