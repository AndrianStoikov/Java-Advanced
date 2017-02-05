package MergeTwoFiles;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\MergeTwoFiles\\file1.txt";
        String file2 = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\MergeTwoFiles\\file2.txt";
        String output = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\MergeTwoFiles\\results.txt";

        Path file1Path = Paths.get(file1);
        Path file2Path = Paths.get(file2);
        Path result = Paths.get(output);

        try (BufferedReader file1Reader = Files.newBufferedReader(file1Path);
             BufferedReader file2Reader = Files.newBufferedReader(file2Path);) {

            List<String> file1Content = Files.readAllLines(file1Path);
            List<String> file2Content = Files.readAllLines(file2Path);
            file1Content.addAll(file2Content);

            Files.write(result, file1Content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
