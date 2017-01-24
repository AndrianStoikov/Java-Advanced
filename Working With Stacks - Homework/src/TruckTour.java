import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<PetrolPump> petrolPumpsQueue = new ArrayDeque<>();

        try {
            Long n = Long.parseLong(Console.readLine());

            for (long i = 0; i < n; i++) {
                Long[] pumpInfo = Arrays.stream(Console.readLine().split(" "))
                        .map(Long::parseLong)
                        .toArray(Long[]::new);
                PetrolPump pump  = new PetrolPump(pumpInfo[0], pumpInfo[1]);
                petrolPumpsQueue.addLast(pump);
            }

            ArrayDeque<PetrolPump> bufferQueue = new ArrayDeque<>();

            int smallestPossibleIndex = -1;
            while(petrolPumpsQueue.size() > 0) {
                smallestPossibleIndex++;
                bufferQueue = petrolPumpsQueue.clone();
                PetrolPump firstPump = petrolPumpsQueue.removeFirst();
                boolean truckHasFuel = true;
                Truck truck = new Truck((long)0);
                while(bufferQueue.size() > 0) {
                    PetrolPump pump = bufferQueue.removeFirst();
                    truck.setFuel(pump.getAmountOfPetrol());
                    if(truck.getDistance() < pump.getDistanceToNextPump()) {
                        truckHasFuel = false;
                        break;
                    } else {
                        truck.burnFuel(pump.getDistanceToNextPump());
                    }
                }
                if(truckHasFuel) {
                    System.out.println(smallestPossibleIndex);
                    break;
                } else {
                    petrolPumpsQueue.addLast(firstPump);
                }
            }

            System.out.println();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}

class PetrolPump {
    private Long distanceToNextPump;
    private Long amountOfPetrol;

    public PetrolPump(Long AmountOfPetrol, Long distanceToNextPump) {
        this.amountOfPetrol = AmountOfPetrol;
        this.distanceToNextPump = distanceToNextPump;
    }

    public Long getDistanceToNextPump() {
        return distanceToNextPump;
    }

    public Long getAmountOfPetrol() {
        return amountOfPetrol;
    }

    public void setDistanceToNextPump(Long distanceToNextPump) {
        this.distanceToNextPump = distanceToNextPump;
    }

    public void setAmountOfPetrol(Long amountOfPetrol) {
        this.amountOfPetrol = amountOfPetrol;
    }
}

class Truck {
    private Long fuel;

    public Truck(Long AmountOfPetrol) {
        this.fuel = AmountOfPetrol;
    }

    public Long getFuel() {
        return fuel;
    }

    public void setFuel(Long fuel) {
        this.fuel += fuel;
    }

    public void burnFuel(Long fuel) {
        this.fuel -= fuel;
    }

    public long getDistance() {
        return fuel;
    }
}