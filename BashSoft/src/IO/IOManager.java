package IO;

import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.util.LinkedList;

public class IOManager {
    public static void traverseDirectory(int depth) {
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0)
                break;

            try {
                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        if (file.isDirectory()) {
                            subFolders.add(file);
                        } else {
                            int indexOfLastSlash = file.toString().lastIndexOf("\\");
                            for (int i = 0; i < indexOfLastSlash; i++) {
                                OutputWriter.writeMessage("-");
                            }

                            OutputWriter.writeMessageOnNewLine(file.getName());
                        }
                    }
                }

                OutputWriter.writeMessageOnNewLine(currentFolder.toString());
            } catch (Exception e) {
                System.out.print("Access denied");
            }
        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectoryPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            // go one directory up
            String currentPath = SessionData.currentPath;
            int indexOfLastSlash = currentPath.lastIndexOf("\\");
            String newPath = currentPath.substring(0, indexOfLastSlash);
            SessionData.currentPath = newPath;
        } else {
            // go to a given directory
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}
