package Median_of_Two_Sorted_Arrays;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JasonChen on 2016/12/19.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int i1=0;
        int i2=0;
        int middle=0;
        //HashMap<Integer,Integer> sMapToIndex;
        int[] result;
        if(length%2==1) {
            //sMapToIndex = new HashMap(1);
            result = new int[1];
            while (i1 < nums1.length && i2 < nums2.length && middle < length/2+1) {
                if (nums1[i1] <= nums2[i2]) {
                    middle++;
                    if(middle==(length/2+1))
                        //sMapToIndex.put(1,i1);
                        result[0]=nums1[i1];
                    i1++;
                }else {
                    middle++;
                    if(middle==(length/2+1))
                        //sMapToIndex.put(2,i2);
                        result[0]=nums2[i2];
                    i2++;
                }
            }
            if(middle<length/2+1){
                if(i1==nums1.length){
                    result[0] = nums2[i2+length/2+1-middle-1];
                }
                if(i2==nums2.length){
                    result[0] = nums1[i1+length/2+1-middle-1];
                }
            }
            return (double)result[0];
            //计算
            /*return (double)sMapToIndex.entrySet().stream().map((each) -> {
                if (each.getKey()==1)
                    return nums1[each.getValue()];
                if (each.getKey()==2)
                    return nums2[each.getValue()];
                return 0;
            }).reduce(0,Integer::sum);*/
        }else {
            //sMapToIndex = new HashMap(2);
            result = new int[2];
            while (i1 < nums1.length && i2 < nums2.length && middle < length/ 2+1) {
                if (nums1[i1] <= nums2[i2]) {
                    middle++;
                    if(middle==(length/2)) {
                        //sMapToIndex.put(1, i1);
                        result[0]=nums1[i1];
                    }
                    if(middle==(length/2+1)){
                        result[1]=nums1[i1];
                    }
                    i1++;
                }else {
                    middle++;
                    if(middle==(length/2)) {
                        //sMapToIndex.put(2, i2);
                        result[0] = nums2[i2];
                    }
                    if(middle==(length/2+1)){
                        result[1] = nums2[i2];
                    }
                    i2++;
                }
            }
            if(middle<length/2){
                if(i1==nums1.length){
                    result[0] = nums2[i2+length/2-middle-1];
                    result[1] = nums2[i2+length/2-middle];
                }
                if(i2==nums2.length){
                    result[0] = nums1[i1+length/2-middle-1];
                    result[1] = nums1[i1+length/2-middle];
                }
            }
            if(middle==length/2){
                if(i1==nums1.length){
                    result[1] = nums2[i2];
                }
                if(i2==nums2.length){
                    result[1] = nums1[i1];
                }
            }
            return  (double)(result[0]+result[1])/2;
            //计算
            /*int sum = sMapToIndex.entrySet().stream().map((each) -> {
                if (each.getKey()==1)
                    return nums1[each.getValue()];
                if (each.getKey()==2)
                    return nums2[each.getValue()];
                return 0;
            }).reduce(0,Integer::sum);
            return (double)sum/2;*/
        }
    }

    public static void main(String[] args){
        int[] a = {1,2};
        int[] b = {3,5,6};
        System.out.println(new Solution().findMedianSortedArrays(a,b));
    }
}
