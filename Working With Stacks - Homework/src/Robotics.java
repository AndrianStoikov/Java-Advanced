import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Robotics {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        /*
            INPUT
            ROB-15;SS2-10;NX8000-3
            8:00:00
            detail
            glass
            wood
            apple
            End
         */


        try {
            //Get robots and Inicialize the time
            String[] robotsInfo = Console.readLine().split(";");
            Integer[] time = Arrays.stream(Console.readLine().split(":"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            LocalTime StartTime = LocalTime.of(time[0], time[1], time[2]);

            //Inicialize array of Robot objects
            ArrayList<Robot> robots = new ArrayList<>();

            //Inicialize the que
            for (int i = 0; i < robotsInfo.length; i++) {
                String robot = robotsInfo[i];
                String[] nameAndNeededTime = robot.split("-");
                Integer[] secondsMinutesHours = convertToSecondsMinutesHours(nameAndNeededTime[1]);
                LocalTime neededTime = LocalTime.of(secondsMinutesHours[2],
                        secondsMinutesHours[1],
                        secondsMinutesHours[0]);
                Robot a = new Robot(nameAndNeededTime[0], neededTime, StartTime);
                robots.add(a);
            }

            ArrayDeque<String> objectsToProcess = new ArrayDeque<>();
            String obj = Console.readLine();
            while (!obj.equals("End")) {
                objectsToProcess.addLast(obj);
                obj = Console.readLine();
            }

            //Do the thIng ;)
            while (objectsToProcess.size() > 0) {
                StartTime = StartTime.plusSeconds(1);
                String object = objectsToProcess.removeFirst();
                boolean freeRobot = false;
                for (int i = 0; i < robots.size(); i++) {
                    if (robots.get(i).isFree(StartTime)) {
                        robots.get(i).setCurrentTime(StartTime);
                        freeRobot = true;
                        System.out.printf("%s - %s [%s]\n", robots.get(i).getName(), object, printDate(StartTime));
                        break;
                    }
                }

                if (!freeRobot) {
                    objectsToProcess.addLast(object);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] convertToSecondsMinutesHours (String time){
        Integer parsedTime = Integer.parseInt(time);
        Integer seconds = parsedTime % 60;
        Integer minutes = (parsedTime/60)%60;
        Integer hours = parsedTime/3600;
        return new Integer[]{seconds, minutes, hours};
    }


    /*
    Implementing my own LocalTime .toString()
     */
    public static String printDate(LocalTime date) {
        StringBuilder buf = new StringBuilder(18);
        int hourValue = date.getHour();
        int minuteValue = date.getMinute();
        int secondValue = date.getSecond();
        int nanoValue = date.getNano();
        buf.append(hourValue < 10 ? "0" : "").append(hourValue)
                .append(minuteValue < 10 ? ":0" : ":").append(minuteValue);
        if (secondValue >= 0 || nanoValue > 0) {
            buf.append(secondValue < 10 ? ":0" : ":").append(secondValue);
            if (nanoValue > 0) {
                buf.append('.');
                if (nanoValue % 1000_000 == 0) {
                    buf.append(Integer.toString((nanoValue / 1000_000) + 1000).substring(1));
                } else if (nanoValue % 1000 == 0) {
                    buf.append(Integer.toString((nanoValue / 1000) + 1000_000).substring(1));
                } else {
                    buf.append(Integer.toString((nanoValue) + 1000_000_000).substring(1));
                }
            }
        }
        return buf.toString();
    }
}

class Robot {
    private String name = "";
    private LocalTime neededTime;
    private LocalTime timeToFree;
    private LocalTime currentTime;

    public Robot(String name, LocalTime neededTime, LocalTime currentTime) {
        this.name = name;
        this.neededTime = neededTime;
        this.currentTime = currentTime;
    }

    public String getName() {
        return name;
    }

    public void setCurrentTime(LocalTime currentTime) {
        /*
        Calculate needed time to so the robot can be free
        */
        this.currentTime = currentTime;
        Long neededTimeAsNanoOfDay = neededTime.toNanoOfDay();
        Long currenTimeAsNanoOfDay = currentTime.toNanoOfDay();

        this.timeToFree = LocalTime.ofNanoOfDay(neededTimeAsNanoOfDay + currenTimeAsNanoOfDay);
    }

    public LocalTime getTimeToFree() {
        return timeToFree;
    }

    public Boolean isFree(LocalTime currentTime) {
        if(this.timeToFree == null) return  true;
        int comp = currentTime.compareTo(this.timeToFree);

        if(comp == -1)
            return false;
        else if(comp == 0)
            return true;
        else
            return true;
    }
}
