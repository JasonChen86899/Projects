package Algorithm;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jason Chen on 2016/9/19.
 */
public class NumericKeypad {
    static class Position{
        int x;
        int y;
        Position(int xx,int yy){
            x=xx;
            y=yy;
        }
    }
    private static int ii;
    private static HashMap<String,Position> hashMap = new HashMap<>();
    static {
        hashMap.put("1",new Position(1,1));
        hashMap.put("2",new Position(1,2));
        hashMap.put("3",new Position(1,3));
        hashMap.put("4",new Position(2,1));
        hashMap.put("5",new Position(2,2));
        hashMap.put("6",new Position(2,3));
        hashMap.put("7",new Position(3,1));
        hashMap.put("8",new Position(3,2));
        hashMap.put("9",new Position(3,3));
        hashMap.put("0",new Position(4,2));
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int flag = 0;
        String[] numm = new String[n];
        while (flag<n){
            String num = scanner.next();
            numm[flag] = num;
            flag++;
        }
        for(String a:numm) {
            System.out.println(judgeMent(a));
        }
    }

    private static String judgeMent(String l){
        int length = l.length();
        int xx = 0;
        int yy = 0;
        Stack<String> stringStack = new Stack<>();
        for(int i=0;i<length;i++){
            if(hashMap.get(String.valueOf(l.charAt(i))).x>=xx&&hashMap.get(String.valueOf(l.charAt(i))).y>=yy) {
                xx = hashMap.get(String.valueOf(l.charAt(i))).x;
                yy = hashMap.get(String.valueOf(l.charAt(i))).y;
            }
            else {
                int a = Integer.valueOf(String.valueOf(l.charAt(i)))-1;
                while(a>=0&&(hashMap.get(String.valueOf(a)).x<xx||hashMap.get(String.valueOf(a)).y<yy))
                    a--;
                if(a<0){
                    int b = Integer.valueOf(stringStack.pop())-1;
                    String result="";
                    for(int p=0;p<length-i;p++){
                        result+="9";
                    }
                    return judgeMent(popToString(stringStack)+b+result);
                }
                if(a==0){
                    String result="";
                    for(int p=0;p<length-i;p++){
                       result+="0";
                    }
                    return popToString(stringStack)+result;
                }
                if(a>0){
                    String result ="";
                    for(int p=0;p<length-1-i;p++){
                        result+="9";
                    }
                    return popToString(stringStack)+a+result;
                }
            }
            stringStack.push(String.valueOf(l.charAt(i)));
        }
        return popToString(stringStack);
    }

    private static String popToString(Stack<String> stack){
        String s ="";
        while (stack.size()!=0){
            s=stack.pop()+s;
        }
        return s;
    }
}
