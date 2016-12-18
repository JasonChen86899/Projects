package First_Search;

import java.util.*;

/**
 * Created by Jason Chen on 2016/9/11.
 */
public class MultipleTree {
    private LinkedHashMap<Integer,Integer[]> map = new LinkedHashMap<>();
    private Integer first;
    public MultipleTree(){
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        ArrayList arrayList =  new ArrayList();
        while(scanner.hasNext()&&n<10){
            String a = scanner.next();
            arrayList.add(a);
            /*
            if(a.equals(""))
                break;
            String[] aa = a.split(" ");
            if(n==0)
                first=Integer.valueOf(aa[0]);
            transfer(aa);*/
            n++;
        }
        System.out.println(arrayList);
    }
    private void transfer(String[] b){
        Integer[] bb= new Integer[b.length-1];
        for(int i =1;i<b.length;i++){
            bb[i-1] =Integer.valueOf(b[i]);
        }
        map.put(Integer.valueOf(b[0]),bb);
    }

    public void print(){
        LinkedList<Integer> queue = new LinkedList();
        queue.add(first);
        while(queue.size()>0){
            Integer en =(Integer) queue.removeFirst();
            System.out.print(en);
            Integer[] needin=map.get(en);
            if(needin !=null) {
                for (int i = 0; i < needin.length; i++) {
                    queue.add(needin[i]);
                }
            }
        }
    }

    public static void main(String[] args){
        new MultipleTree().print();
    }
}
