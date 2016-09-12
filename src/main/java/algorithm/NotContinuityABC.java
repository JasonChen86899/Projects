package algorithm;

import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/12.
 */
public class NotContinuityABC {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(function(n));
    }
    private static int function(int n){
        if(n==1)
            return 3;
        if(n==2)
            return 9;
        return function(n-2)+function(n-1)*2;
    }
}
