package algorithm;

import java.util.*;

/**
 * Created by Jason Chen on 2016/9/21.
 */

/**
 * 20 35 23 40 需要添加两个数字，使得有3个数字能组成一起，a+10<=b,b+10<=c,
 */
public class FindNeedNum {
    private static int count ;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int flag = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while(flag<n){
            nums.add(in.nextInt());
            flag++;
        }
        Collections.sort(nums);
        chuli(z(nums));
        System.out.println(count);
    }

    private static void chuli(int[] b){
        int p=0;
        int q=0;
        retry:
        while(q<b.length){
            int bb=b[p];
            for(int i=0;i<3;i++){
                if(q<b.length&&bb+10>=b[q]) {
                    bb=b[q];
                    q++;
                }
                else {
                    count+=3-(q-p);
                    p=q;
                    continue retry;
                }
            }
            p=q;
        }
    }

    private static int[] z(ArrayList<Integer> a){
        Iterator<Integer> integerIterator =  a.iterator();
        int[] aa = new int[a.size()];
        int i =0;
        while(integerIterator.hasNext()){
            aa[i] = integerIterator.next().intValue();
            i++;
        }
        return aa;
    }
}
