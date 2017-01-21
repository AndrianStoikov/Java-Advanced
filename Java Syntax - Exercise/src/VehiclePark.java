import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehiclePark {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try {
            List<String> Cars = Arrays.stream(Console.readLine().split("\\s+")).collect(Collectors.toList());

            String input = Console.readLine();

            int soldVehicles = 0;
            while (!input.equals("End of customers!")) {
                String[] searchedVehicle = input.split("\\s+");
                String vehicleLetter = searchedVehicle[0].substring(0,1).toLowerCase().trim();
                String vehicleSize = searchedVehicle[2].toLowerCase().trim();
                String search = vehicleLetter + vehicleSize;

                if(Cars.contains(search)) {
                    int indexOfCars = Cars.indexOf(search);
                    Cars.remove(indexOfCars);
                    System.out.printf("Yes, sold for %d$\n", calculatePrice(search));
                    soldVehicles++;
                } else System.out.println("No");

                input = Console.readLine();
            }

            System.out.printf("Vehicles left: %s\n", Cars.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
            System.out.printf("Vehicles sold: %d", soldVehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer calculatePrice(String vehicle) {
        int ascii = vehicle.charAt(0);
        int seats = Integer.parseInt(vehicle.substring(1));
        return ascii * seats;
    }
}
