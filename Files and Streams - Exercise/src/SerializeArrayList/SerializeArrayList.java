package SerializeArrayList;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {

        String inputObject = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\SerializeArrayList\\input.ser";
        String outputObject = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\SerializeArrayList\\list.ser";


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputObject));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputObject))) {
            ArrayList<Double> list = (ArrayList<Double>) ois.readObject();
            list.add(1.2);
            list.add(34.62);
            list.add(123.6);
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
