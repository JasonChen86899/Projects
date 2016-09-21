package algorithm;

import java.util.*;

/**
 * Created by I330347 on 2016/9/19.
 */
public class GameThree {
    private static HashMap<String,ArrayList<String>> hashMap = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int flag =1;
        while (flag<=n){
            String l = scanner.nextLine();
            String[] num =l.split(" ");
            for(int i =1 ;i<num.length;i++){
                for(int jj =1;jj<num.length;jj++){
                    if(!num[i].equals(num[jj])){
                        if(hashMap.get(num[i])!=null){
                            ArrayList<String> arrayList = hashMap.get(num[i]);
                            arrayList.add(num[jj]);
                        }else {
                            ArrayList<String> a = new ArrayList<>();
                            a.add(num[jj]);
                            hashMap.put(num[i],a);
                        }
                    }
                }
            }
            flag++;
        }
        System.out.println(BFS());
    }

    private static int BFS(){
        LinkedList<String> queue = new LinkedList();
        HashSet<String> set = new HashSet<>();
        queue.add("1");
        while(queue.size()!=0) {
            String out = queue.removeFirst();
            ArrayList<String> a = hashMap.get(out);
            for (String e : a) {
                if(!set.contains(e))
                    queue.add(e);
            }
            set.add(out);
        }
        return set.size()-1;
    }
}
