package Algorithm;

import java.util.Scanner;

/**
 * Created by I330347 on 8/2/2016.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n,s,l=0;
        n=scanner.nextInt();
        s=scanner.nextInt();
        l = scanner.nextInt();
        System.out.println(test(n,s,l));
    }
    public static int test(int n ,int s,int l){
        int mod = l%(s+1);
        if(mod !=0){
            if(mod == s){
                int a = l/(s+1)+1;
                return cal(n,a);
            }
            if ((mod !=s)){
                int a = l/(s+1);
                return cal(n,a);
            }
        }
        int a= l/(s+1);
        return cal(n,a);
    }

    public static int cal(int n,int a){
        if(a==13){
            a=12;
        }
        if (n%a == 0)
            return n/a;
        if((n%a)%13==0) {
            if(n<a)
                return n/a + 2;
            if(a%13==1)
                return n / a + 2;
            return n/a + 1;
        }
        return n/a +1;
    }
}
