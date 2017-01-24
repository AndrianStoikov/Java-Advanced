import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        StringTokenizer inputTokenizer = new StringTokenizer(reader.readLine(), ";");
        String startTime = reader.readLine();

        Robot[] robotsLine = new Robot[inputTokenizer.countTokens()];

        int robotInd = 0;
        while (inputTokenizer.hasMoreTokens()) {
            StringTokenizer robotTokenizer = new StringTokenizer(inputTokenizer.nextToken(), "-");

            while (robotTokenizer.hasMoreTokens()) {
                String name = robotTokenizer.nextToken();
                int processingTime = Integer.valueOf(robotTokenizer.nextToken());

                Robot newRobot = new Robot(name, processingTime, startTime);
                robotsLine[robotInd] = newRobot;
                robotInd += 1;
            }
        }

        // Enqueue products
        String productInput = reader.readLine();
        while (!productInput.equals("End")) {
            productsQueue.offer(productInput);
            productInput = reader.readLine();
        }

        // Start time-lapse
        while (!productsQueue.isEmpty()) {
            boolean productTaken = false;

            for (Robot robot : robotsLine) {
                robot.updateStatus();

                if (!robot.busy() && !productTaken) {
                    robot.takeProduct(productsQueue.poll());
                    productTaken = true;
                }
            }

            if (!productTaken) {
                String toBack = productsQueue.poll();
                productsQueue.offer(toBack);
            }
        }
    }
}

class Robot {
    private int processingTime;
    private String name;
    private boolean isBusy;
    private SimpleClock robotClock;
    private SimpleClock endTime;

    public Robot(String name, int processingTime, String currentTime) {
        this.name = name;
        if(processingTime == 0 )
            this.processingTime = processingTime + 1;
        else this.processingTime = processingTime;
        this.robotClock = new SimpleClock(currentTime);
        this.isBusy = false;
    }

    public void takeProduct(String product) {
        if (this.isBusy) {
            return;
        }
        System.out.printf("%s - %s %s", this.name, product, this.robotClock.getTime());
        System.out.println();
        this.endTime = new SimpleClock(this.robotClock);
        this.endTime.addSeconds(this.processingTime);
        this.isBusy = true;
    }

    public void updateStatus() {
        this.robotClock.tick();

        if (this.busy()) {
            if (this.robotClock.equals(this.endTime)) {
                this.isBusy = false;
            }
        }
    }

    public boolean busy() {
        return this.isBusy;
    }
}

class SimpleClock {
    private byte hours;
    private byte minutes;
    private byte seconds;

    public SimpleClock(String startTime) {
        StringTokenizer clockTokenizer = new StringTokenizer(startTime, ":");

        this.hours = Byte.valueOf(clockTokenizer.nextToken());
        this.minutes = Byte.valueOf(clockTokenizer.nextToken());
        this.seconds = Byte.valueOf(clockTokenizer.nextToken());
    }

    public SimpleClock(SimpleClock otherClock) {
        this.hours = otherClock.hours;
        this.minutes = otherClock.minutes;
        this.seconds = otherClock.seconds;
    }

    public boolean equals(SimpleClock otherClock) {
        return ((this.hours == otherClock.hours)
                && (this.minutes == otherClock.minutes)
                && (this.seconds == otherClock.seconds));
    }

    public void tick() {
        this.seconds += 1;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes += 1;
        }
        if (this.minutes == 60) {
            this.minutes = 0;
            this.hours += 1;
        }
        if (this.hours == 24) {
            this.hours = 0;
        }
    }

    public String getTime() {
        String seconds = this.seconds < 10 ? ("0" + this.seconds) : String.valueOf(this.seconds);
        String minutes = this.minutes < 10 ? ("0" + this.minutes) : String.valueOf(this.minutes);
        String hours = this.hours < 10 ? ("0" + this.hours) : String.valueOf(this.hours);

        return String.format("[%s:%s:%s]", hours, minutes, seconds);
    }

    public void addSeconds(int seconds) {
        for (int i = 0; i < seconds; i++) {
            this.tick();
        }
    }
}