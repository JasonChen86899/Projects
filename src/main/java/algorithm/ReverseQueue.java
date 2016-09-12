package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/12.
 */
public class ReverseQueue {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int Znm = scanner.nextInt();
        while(Znm>0){
            int n  = scanner.nextInt();
            reverse(n);
            Znm--;
        }
    }

    public static void reverse(int n){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(linkedList.size()!=0) {
                int r = linkedList.removeLast();
                linkedList.addFirst(r);
            }
            linkedList.addFirst(n-i);
        }
        int r = linkedList.removeLast();
        linkedList.addFirst(r);
        int l= linkedList.size();
        for(int i =0;i<l;i++){
            if(i==l-1)
                System.out.print(linkedList.removeFirst().intValue()+"\r\n");
            else
                System.out.print(linkedList.removeFirst().intValue()+" ");
        }
    }
}
