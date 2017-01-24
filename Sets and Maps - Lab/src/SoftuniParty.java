import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SoftuniParty {
    public static void main(String[] args) {
        HashMap<String, String> vipList = new HashMap<String, String>();
        HashMap<String, String> normalGuestList = new HashMap<String, String>();
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String guest = Console.readLine();
                if(guest.equals("PARTY")) {
                    break;
                } else {
                    char first = guest.charAt(0);
                    if(first >= 48 && first <= 57) {
                        vipList.put(guest, guest);
                    } else {
                        normalGuestList.put(guest, guest);
                    }
                }
            }

            while (true) {
                String guest = Console.readLine();
                if(guest.equals("END")) {
                    break;
                } else {
                    if(vipList.containsKey(guest)) {
                        vipList.remove(guest);
                    } else {
                        normalGuestList.remove(guest);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (String s : vipList.keySet()) {
                sb.append(s);
                sb.append("\n");
            }

            for (String s : normalGuestList.keySet()) {
                sb.append(s);
                sb.append("\n");
            }

            System.out.println(vipList.size() + normalGuestList.size() + "\n" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
