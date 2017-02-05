package CreateZipArchive;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CreateZipArchive\\file1.txt";
        String file2 = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CreateZipArchive\\file2.txt";
        String file3 = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CreateZipArchive\\file3.txt";

        String zipFile = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CreateZipArchive\\ziped.zip";



        File zip = new File(zipFile);
        Path firstPath = Paths.get(file1);
        Path secondPath = Paths.get(file2);
        Path thirdPath = Paths.get(file3);

        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
        FileInputStream firstFile = new FileInputStream(file1);
        FileInputStream seocondFile = new FileInputStream(file2);
        FileInputStream thirdFile = new FileInputStream(file3)) {
            //get and create first file
            zipFile(out, firstPath, "file1.txt");

            //get and create second file
            zipFile(out, secondPath, "file2.txt");

            //get and create third file
            zipFile(out, thirdPath, "file3.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFile (ZipOutputStream out, Path path, String nameAndType) throws IOException {

        ZipEntry e = new ZipEntry(nameAndType);
        out.putNextEntry(e);
        byte[] data = Files.readAllBytes(path);
        out.write(data, 0, data.length);
        out.closeEntry();
    }
}
