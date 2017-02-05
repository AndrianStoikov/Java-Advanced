package ExtractIntegers;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String input = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\ExtractIntegers\\input.txt";
        String output = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\ExtractIntegers\\output.txt";


        Path inPath = Paths.get(input);
        try(Scanner reader = new Scanner(inPath);
        PrintWriter writer = new PrintWriter(new FileOutputStream(output))) {
            while (reader.hasNext()) {
                if (reader.hasNextInt())
                    writer.println("" + reader.nextInt());

                reader.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
