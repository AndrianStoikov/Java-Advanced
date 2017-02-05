package CopyBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

public class CopyBytes {
    public static void main(String[] args) {
        String input = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\CopyBytes\\input.txt";
        String output = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\CopyBytes\\output.txt";


        try(FileInputStream reader = new FileInputStream(input);
            FileOutputStream writer = new FileOutputStream(output)) {

            int oneByte = 0;
            while ((oneByte = reader.read()) >= 0) {
                if (((char)oneByte == ' ' || (char)oneByte == '\n')) {
                    writer.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        writer.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
