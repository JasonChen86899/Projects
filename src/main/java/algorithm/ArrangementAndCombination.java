package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by I330347 on 8/19/2016.
 */
public class ArrangementAndCombination {
    private static HashMap<String,Integer> StringMap = new HashMap<>();
    public static void main(String[] args){
        String[] l={"1","2","3","9"};
        CoreMethod(l,"",0);
        //System.out.println(StringSet.size());
    }

    /**
     *
     * @param l
     * @param result
     * @param length length为递归最后的判断指标
     */
    private static void CoreMethod(String[] l,String result,int length){
        if(l.length==length)
            StringMap.put(result,1);
        else{
            for(int i=0;i<l.length;i++){
                CoreMethod(deleteOne(l,i),result+l[i],length);
            }
        }
    }

    private static String[] deleteOne(String[] l,int j){
        String[] copy = l.clone();
        for(int i=j;i<copy.length-1;i++){
            copy[i]=copy[i+1];
        }
        String[] copy2 = new String[copy.length-1];
        for(int p=0;p<copy.length-1;p++)
            copy2[p]=copy[p];
        return copy2;
    }

    private static void judgement(String l){
        String half = l;
        while(half.length()%2==0) {
            String one = half.substring(0, l.length() / 2);
            String two = half.substring(l.length() / 2, l.length());
            if (one.equals(two)) {
                StringMap.put(l, StringMap.get(l) + 1);
                half = one;
            }else
                break;
        }
        if(o(l))
            StringMap.put(l,StringMap.get(l)+l.length()-1);
        else{

        }
    }

    private static boolean o(String l){
        char[] chars = l.toCharArray();
        for(char c : chars){
            if(c!=chars[0])
                return false;
        }
        return true;
    }
}
