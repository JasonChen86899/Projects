package Algorithm;

import java.util.Scanner;

/**
 * Created by Jason Chen on 2016/9/20.
 */
public class CountZeroAndOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String n = scanner.next();
            System.out.println(dg(n));
        }
    }
    private static boolean judgement(String s){
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='0'&&chars[i]!='1')
                return false;
        }
        return true;
    }
    private static int dg(String s){
        char[] chars = s.toCharArray();
        if(s.length()==0)
            return 0;
        if(chars[0]=='1'){
            return (int)Math.pow(2,s.length()-1)+dg(s.substring(1,s.length()));
        }else {
            if(chars[0]>='1'){
                return (int)Math.pow(2,s.length())+dg(s.substring(1,s.length()))-1;
            }else
                return dg(s.substring(1,s.length()));
        }
    }
}
