package algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Jason Chen on 2016/9/18.
 */
public class LuckyString {
    private static TreeSet<String> stringTreeSet = new TreeSet<>();//String 本身以字典序排序实现compable接口
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        splitToSubString(s);
        Iterator<String> i= stringTreeSet.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

    public static void splitToSubString(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String a =s.substring(i,j);
                if(ifFibonacci(a))
                    stringTreeSet.add(a);
            }
        }
    }

    public static boolean ifFibonacci(String s){
        int num =0;
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for(char chareach : chars){
            hashSet.add(chareach);
        }
        int f1 =1;
        int f2 =1;
        while(num<hashSet.size()){
            if(hashSet.size()==1)
                return true;
            num = f1+f2;
            f1=f2;
            f2=num;
        }
        if(num==hashSet.size())
            return true;
        else
            return false;
    }


}
