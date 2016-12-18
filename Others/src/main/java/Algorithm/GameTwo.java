package Algorithm;

import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/19.
 */
public class GameTwo {
    private static int count;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int flag = 0;
        String[] input = new String[n];
        while(flag<n){
            input[flag] = scanner.next();
            flag++;
        }
        looper(input);
        System.out.println(count);
    }

    private static boolean judgemnetHw(String s1,String s2){
        String newS = s1+s2;
        int length = newS.length();
        int half = length/2;
        for(int i=0;i<half;i++){
            if(newS.charAt(i)!= newS.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }

    private static void looper(String[] input){
        for(int i=0;i<input.length-1;i++){
            for(int j=i+1;j<input.length;j++){
                if(judgemnetHw(input[i],input[j]))
                    count++;
                if(judgemnetHw(input[j],input[i]))
                    count++;
            }
        }
    }
}
