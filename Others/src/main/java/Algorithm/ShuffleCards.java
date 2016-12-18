package Algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by I330347 on 2016/9/12.
 */
public class ShuffleCards  {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int zs = scanner.nextInt();
        while(zs>0&&scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nn = new int[2*n];
            for(int i=0;i<2*n;i++){
                nn[i]= scanner.nextInt();
            }
            Cal(nn,k);
            zs--;
        }
    }

    public static void Cal(int[] inputs,int k){
        Stack<Integer> stack = new Stack<>();
        int half = inputs.length/2;
        while (k>=1) {
            for (int i = half - 1, j = inputs.length - 1; i >= 0 && j >= half; i--, j--) {
                stack.push(inputs[j]);
                stack.push(inputs[i]);
            }
            int l = stack.size();
            for (int j=0;j<l;j++){
                inputs[j] = stack.pop();
                if(k==1) {
                    if(j!=l-1)
                        System.out.print(inputs[j]+" ");
                    else
                        System.out.print(inputs[j]+"\r\n");
                }
            }
            k--;
        }
    }
}
