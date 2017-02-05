package GetFolderSize;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String directory = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\GetFolderSize\\Files-and-Streams";

        File folder = new File(directory);

        long size = folderSize(folder);
        System.out.println(size);
    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
