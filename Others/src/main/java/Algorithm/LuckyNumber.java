package Algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/5.
 */
public class LuckyNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        while (n>0){
            int e = Integer.valueOf(scanner.nextLine());
            complute(e);
        }
    }

    public static void complute(int e){
        LinkedList<String> queue = new LinkedList<>();
        queue.add("4");
        queue.add("7");
        int a =1;
        while(a<=e){
            String pop  = queue.removeFirst();
            if((a+queue.size())<e) {
                queue.add(pop + "4");
                queue.add(pop + "7");
            }else{
                int mark = (a+queue.size())-e;
                int l =queue.size()-1-mark;
                if(l<0)
                    System.out.println(pop);
                else
                    System.out.println(queue.get(queue.size()-1-mark));
                return;
            }
            a++;
        }
        //System.out.println(queue.removeFirst());
    }
}
