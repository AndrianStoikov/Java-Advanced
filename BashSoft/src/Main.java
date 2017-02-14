import java.io.IOException;

import static IO.InputReader.readCommands;

public class Main {
    public static void main(String[] args) {
        try {
            readCommands();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
