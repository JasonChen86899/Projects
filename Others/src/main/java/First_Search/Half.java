package First_Search;

import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/11.
 */
public class Half {
    private static String record ="";
    public static void Dg(int start,int end,int value){
        int mid = (start+end)/2;
        if(value<mid){
            record=record+0;
            if(record.length()>=6) {
                System.out.println(record);
                return;
            }
            Dg(start,mid,value);
        }else {
            record=record+1;
            if(record.length()>=6){
                System.out.println(record);
                return;
            }
            Dg(mid,end,value);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        Dg(-90,90,value);
    }
}
