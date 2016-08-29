package algorithm; /**
 * Created by I330347 on 8/1/2016.
 */
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            //int b = in.nextInt();
            //System.out.println(a + b);
            Kaprekar(a);

        }
    }
    public static void Kaprekar(int a){
        String s=checkInput(a);
        //s = String.valueOf(a);
        int length = s.length();
        while (!s.equals("6174")&&!s.equals("0000")) {
            int[] b = new int[length];
            int[] c = new int[length];
            for (int i = 0; i < length; i++) {
                b[i] = Integer.valueOf(s.substring(i, i + 1));
                c[i] = Integer.valueOf(s.substring(i, i + 1));
            }
            SortMax(b);
            SortMin(c);
            s=jian(b,c);
        }
    }
    public static void SortMax(int [] b){
        for(int i=0;i<b.length;i++){
            for(int j= i;j<b.length;j++){
                if(b[i]<b[j]){
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
    }
    public static void SortMin(int[] b){
        for(int i=0;i<b.length;i++){
            for(int j= i;j<b.length;j++){
                if(b[i]>b[j]){
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
    }
    public static String jian(int[] b,int[] c){
        String s = null;
        int e = b[0]*1000+b[1]*100+b[2]*10+b[3]-(c[0]*1000+c[1]*100+c[2]*10+c[3]);
        if(String.valueOf(e).length()<4){
            int p = 4-String.valueOf(e).length();
            switch (p){
                case 1:
                    s="0"+e;break;
                case 2:
                    s="00"+e;break;
                case 3:
                    s="000"+e;break;
            }
            System.out.println(String.valueOf(b[0])+String.valueOf(b[1])+String.valueOf(b[2])+String.valueOf(b[3])+" - "+String.valueOf(c[0])+String.valueOf(c[1])+String.valueOf(c[2])+String.valueOf(c[3])+" = "+s);
            return s;
        }
        System.out.println(String.valueOf(b[0])+String.valueOf(b[1])+String.valueOf(b[2])+String.valueOf(b[3])+" - "+String.valueOf(c[0])+String.valueOf(c[1])+String.valueOf(c[2])+String.valueOf(c[3])+" = "+e);
        return String.valueOf(e);
    }
    public static String checkInput(int a){
        String s =null;
        if(String.valueOf(a).length()<4){
            int p = 4-String.valueOf(a).length();
            switch (p){
                case 1:
                    s="0"+a;break;
                case 2:
                    s="00"+a;break;
                case 3:
                    s="000"+a;break;
            }
        }else
            s= String.valueOf(a);
        if(s.charAt(0)==s.charAt(1)&&s.charAt(1)==s.charAt(2)&&s.charAt(2)==s.charAt(3)){
            System.out.println(s+" - "+s+" = "+"0000");
            return "0000";
        }
        return s;
    }
}
