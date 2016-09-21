package algorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/19.
 */
public class GameOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line =scanner.nextLine();
            String[] num =line.split(" ");
            int a = Integer.valueOf(num[0]);
            int b = Integer.valueOf(num[1]);
            System.out.println(maxGy(a,b)+" "+minGb(a,b));
        }
    }

    private static int maxGy(int aa,int bb){
        int a = Math.max(aa,bb);
        int b = Math.min(aa,bb);
        int r= a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }

    private static BigInteger minGb(int a, int b){
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(maxGy(a,b)));
    }
}
