package SerializeCustomObject;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Course course = new Course("Java-Advanced", 123);

        String outputObject = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\SerializeCustomObject\\course.ser";

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputObject))) {
            oos.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
