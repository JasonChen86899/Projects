package algorithm;

import java.util.Scanner;

/**
 * Created by I330347 on 2016/9/12.
 */
public class ReverseInteger {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int frist = scanner.nextInt();
        int second = scanner.nextInt();
        function(frist,second);
    }

    private static void function(int first,int second){
        System.out.print(rev(Integer.valueOf(rev(first))+Integer.valueOf(rev(second))));
    }

    private static String rev(int a){
        String b= String.valueOf(a);
        char[] chars = b.toCharArray();
        boolean mark = true;
        String result="";
        for(int i= chars.length-1;i>=0;i--){
            if(mark&&chars[i]=='0'){
            }else {
                mark =false;
                result+=chars[i];
            }
        }
        if(result.equals(""))
            return "0";
        return result;
    }
}
