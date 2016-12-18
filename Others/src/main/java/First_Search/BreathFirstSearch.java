package First_Search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by I330347 on 2016/9/2.
 */
public class BreathFirstSearch {
    private LinkedList<Integer>[] ListArray = new LinkedList[9];
    private HashMap<String,Boolean> mark = new HashMap<>();
    public BreathFirstSearch(){
        ListArray[1] = new LinkedList<>();
        ListArray[1].add(1);
        ListArray[1].add(2);
        ListArray[1].add(5);
        ListArray[2] = new LinkedList<>();
        ListArray[2].add(2);
        ListArray[2].add(6);
        ListArray[2].add(1);
        ListArray[3] = new LinkedList<>();
        ListArray[3].add(3);
        ListArray[3].add(4);
        ListArray[3].add(6);
        ListArray[3].add(7);
        ListArray[4] = new LinkedList<>();
        ListArray[4].add(4);
        ListArray[4].add(3);
        ListArray[4].add(7);
        ListArray[4].add(8);
        ListArray[5] = new LinkedList<>();
        ListArray[5].add(5);
        ListArray[5].add(1);
        ListArray[6] = new LinkedList<>();
        ListArray[6].add(6);
        ListArray[6].add(2);
        ListArray[6].add(3);
        ListArray[6].add(7);
        ListArray[7] = new LinkedList<>();
        ListArray[7].add(7);
        ListArray[7].add(3);
        ListArray[7].add(4);
        ListArray[7].add(6);
        ListArray[7].add(8);
        ListArray[8] = new LinkedList<>();
        ListArray[8].add(8);
        ListArray[8].add(4);
        ListArray[8].add(7);
        for(int i=1;i<=8;i++){
            mark.put(String.valueOf(i),false);
        }
    }
    public void BFS(){
        LinkedList<Integer> supportQueue = new LinkedList<>();
        Integer b = ListArray[1].getFirst();
        supportQueue.add(b);
        while(supportQueue.size()!=0) {
            int c = supportQueue.removeFirst();
            if (mark.get(String.valueOf(c)).equals(false)) {
                mark.put(String.valueOf(c), true);
                System.out.println(c);
                EnQueue(supportQueue, c);
            }

        }
    }

    private void EnQueue(Queue queue,int i){
        for(int j =1;j<ListArray[i].size();j++){
            queue.add(ListArray[i].get(j));
        }
    }

    public static void main(String[] args){
        new BreathFirstSearch().BFS();
    }

}
