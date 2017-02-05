package WriteEveryThirdLine;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String input = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\WriteEveryThirdLine\\input.txt";
        String output = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\WriteEveryThirdLine\\output.txt";


        Path inPath = Paths.get(input);
        try(Scanner reader = new Scanner(new FileInputStream(input));
            PrintWriter writer = new PrintWriter(new FileOutputStream(output))) {

            int counter = 1;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (counter % 3 == 0)
                    writer.println(line);
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
