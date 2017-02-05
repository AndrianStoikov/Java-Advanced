package ListFiles;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String folder = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Lab\\src\\ListFiles\\Files-and-Streams";

        File file = new File(folder);
        File[] allFilesInFolder = file.listFiles();

        for (File file1 : allFilesInFolder) {
            if(file1.exists() && !file1.isDirectory()) {
                System.out.printf("%s: %d\n", file1.getName(), file1.length());
            }
        }
    }
}
