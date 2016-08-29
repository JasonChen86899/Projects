package algorithm;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by I330347 on 8/12/2016.
 */
public class MaxMapping {
    public static class node{
        String a;
        int value;
    }
    private static HashMap<String,Double> characterMap= new HashMap<>();
    public static void transfer(String s){
        char[] chars = s.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            if(characterMap.get(String.valueOf(chars[i]))==null)
                characterMap.put(String.valueOf(chars[i]), Math.pow(10,chars.length-1-i));
            else
                characterMap.put(String.valueOf(chars[i]),Math.pow(10,chars.length-1-i)+characterMap.get(String.valueOf(chars[i])));
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        HashSet<String> head = new HashSet<>();
        int b=a;
        while (scanner.hasNextLine()&&b>0){
            String ss;
            transfer(ss=scanner.nextLine());
            head.add(ss.substring(0,1));
            b--;
        }
        Set<Map.Entry<String,Double>> entry =characterMap.entrySet();
        Object[] array = entry.toArray();
        Collections.sort( Arrays.asList(array), new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<String,Double> e1 = (Map.Entry) o1;
                Map.Entry<String,Double> e2 = (Map.Entry) o2;
                if(e1.getValue()>e2.getValue())
                    return 1;
                if(e1.getValue()<e2.getValue())
                    return -1;
                return 0;
            }
        });
        int i=0;
        HashMap<String,String> result = new HashMap<>();
        for(;i<characterMap.size();i++){
            Map.Entry<String,Double> entry1 =(Map.Entry)array[i];
            result.put(String.valueOf(10-characterMap.size()+i),entry1.getKey());
        }
        if(characterMap.size()==10) {
            int j = 0;
            while (head.contains(result.get(String.valueOf(j)))) {
                j++;
            }
            String end = result.get(String.valueOf(j));
            for (int e = 1; e <= j; e++) {
                Map.Entry<String,Double> entry1 =(Map.Entry)array[e-1];
                result.put(String.valueOf(e), entry1.getKey());
            }
            result.put("0", end);
            Double r = 0.0;
            for (int ii = 0; ii < characterMap.size(); ii++) {
                r += ii * characterMap.get(result.get(String.valueOf(ii)));
            }
            System.out.println(r.longValue());
        }else {
            Double r = 0.0;
            for (int ii = 10-characterMap.size(); ii < 10; ii++) {
                r += ii * characterMap.get(result.get(String.valueOf(ii)));
            }
            System.out.println(r.longValue());
        }
    }
}
