package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by I330347 on 8/2/2016.
 */
public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        //scanner.useDelimiter("\n");
        while (scanner.hasNextLine()){
            String line =scanner.nextLine();
            String[] t =line.split(" ");
            for(String et:t){
                set.add(et);
            }
        }
        System.out.println(set.size());
    }
}
