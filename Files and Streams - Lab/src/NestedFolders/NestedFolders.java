package NestedFolders;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String directory = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\GetFolderSize\\Files-and-Streams";

        File folder = new File(directory);
        System.out.println(folder.getName());
        ArrayDeque<File> folders = new ArrayDeque<>();
        folders.addLast(folder);
        folderSize(folder, folders);
        System.out.println(folders.size() + " folders");
    }

    public static void folderSize(File directory, ArrayDeque<File> folders) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                folders.addLast(file);
                System.out.println(file.getName());
                folderSize(file, folders);
            }
        }
    }

}
