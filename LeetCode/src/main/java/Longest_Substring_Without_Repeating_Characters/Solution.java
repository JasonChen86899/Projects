package Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by JasonChen on 2016/12/18.
 */
public class Solution {
    private HashMap<Character,Integer> charMapToIndex = new HashMap<>();
    int fist  =0;
    int end =0;
    public int lengthOfLongestSubstring(String s) {
        int longestLength =0;
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;) {
            for (int j = i; j<charArray.length; j++) {
                if (!charMapToIndex.containsKey(charArray[j])||charMapToIndex.get(charArray[j])<fist) {
                    charMapToIndex.put(charArray[j],j);
                    end=j;
                }else {
                    System.out.println(end-fist+1);
                    longestLength = Math.max(longestLength, end-fist+1);
                    fist = charMapToIndex.get(charArray[j])+1;
                    charMapToIndex.put(charArray[j],j);//对找到的回溯点进行覆盖
                    i = j+1;
                    break;
                }
            }
        }
        return longestLength;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
