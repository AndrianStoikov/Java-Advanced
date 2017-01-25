import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regular = new TreeSet<>();
        //try {
            Scanner sc = new Scanner(System.in);

            while (true) {
                String input = sc.nextLine();
                if (input.equals("PARTY")) {
                    break;
                }else {
                    char sign = input.charAt(0);
                    if (sign >= 48 && sign <= 57) {
                        vip.add(input);
                    } else {
                        regular.add(input);
                    }
                }
            }


            while(true) {
                String input = sc.nextLine();
                if (input.equals("END")) {
                    break;
                }else {
                    if(vip.contains(input)) {
                        vip.remove(input);
                    } else if(regular.contains(input)) {
                        regular.remove(input);
                    }
                }
            }


            regular.addAll(vip);

        System.out.println(regular.size());
        for (String s : regular) {
            System.out.println(s);
        }
        //} //catch (IOException e) {
          //  e.printStackTrace();
        //}
    }
}
