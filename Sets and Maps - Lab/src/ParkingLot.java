import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.LinkedHashMap;


public class ParkingLot {
    public static void main(String[] args) {
        HashMap<String, String> parkingLot = new HashMap<String, String>();
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String input = Console.readLine();
                if(input.equals("END")) {
                    break;
                } else {
                    String[] reminder = input.split(", ");
                    if(reminder[0].equals("IN")) {
                        parkingLot.put(reminder[1], reminder[1]);
                    } else {
                        parkingLot.remove(reminder[1]);
                    }
                }
            }

            if(parkingLot.isEmpty()) {
                System.out.println("Parking Lot is Empty");
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                for (String s : parkingLot.keySet()) {
                    sb.append(s + "\n");
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
