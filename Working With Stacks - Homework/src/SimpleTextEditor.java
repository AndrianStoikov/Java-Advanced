import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long n = Long.parseLong(Console.readLine());
            String text = "";
            ArrayDeque<String> oldText = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                String[] command = Console.readLine().split(" ");
                if(command.length == 2) {
                    switch (command[0]) {
                        case "1": {
                            oldText.push(text);
                            text = text + command[1];
                            break;
                        }
                        case "2": {
                            oldText.push(text);
                            int count = Integer.parseInt(command[1]);
                            text = text.substring(0,text.length() - count);
                        }break;
                        case "3": {
                            int index = Integer.parseInt(command[1]);
                            char charAtIndex = text.charAt(index - 1);
                            System.out.println(charAtIndex);
                        }break;
                        default: break;
                    }
                } else {
                    text = oldText.pop();
                }
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
