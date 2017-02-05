package CopyPicture;

import java.io.*;

public class CopyPicture {
    public static void main(String[] args) {
        String picture = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CopyPicture\\Picture.jpg";
        String resultPicture = "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Files and Streams - Exercise\\src\\CopyPicture\\Result.jpg";

        try(InputStream is = new FileInputStream(new File(picture));
            OutputStream os = new FileOutputStream(new File(resultPicture));){
            byte[] buffer = new byte[4 * 1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
