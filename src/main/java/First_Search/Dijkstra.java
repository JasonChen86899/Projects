package First_Search;

import java.util.*;

/**
 * Created by Jason Chen on 2016/9/4.
 */
public class Dijkstra {
    private LinkedHashMap<Integer,Integer>[] ListArray = new LinkedHashMap[6];
    private HashMap<String,Boolean> mark = new HashMap<>();
    private HashMap<Integer,Integer> result = new HashMap<>();
    public Dijkstra(){
        ListArray[1] = new LinkedHashMap<>();
        ListArray[1].put(2,10);
        ListArray[1].put(5,5);
        ListArray[2] = new LinkedHashMap<>();
        ListArray[2].put(3,1);
        ListArray[2].put(5,2);
        ListArray[3] = new LinkedHashMap<>();
        ListArray[3].put(4,4);
        ListArray[4] = new LinkedHashMap<>();
        ListArray[4].put(1,7);
        ListArray[4].put(3,6);
        ListArray[5] = new LinkedHashMap<>();
        ListArray[5].put(2,3);
        ListArray[5].put(3,9);
        ListArray[5].put(4,2);
        for (int i = 1; i <= 5; i++) {
            mark.put(String.valueOf(i), false);
        }
    }

    public void addPoint(){
        //从1开始
        PriorityQueue<Node> supportQueue = new PriorityQueue<>();
        result.put(1,0);
        supportQueue.add(new Node<>(1,0));
        while(supportQueue.size()!=0){
            Node a = (Node)supportQueue.poll();
            if(mark.get(String.valueOf(a.key)).equals(false)){
                mark.put(String.valueOf(a.key),true);
                result.put((int)a.key,a.value);
                translate(ListArray[(int)a.key],supportQueue,(int)a.key);
            }
        }
    }

    private void translate(LinkedHashMap<Integer,Integer> map,PriorityQueue queue,int p){
        Iterator<Map.Entry<Integer,Integer>> i = map.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry<Integer,Integer> e = i.next();
            compareAndReset(queue,e,p);
        }
    }

    private void compareAndReset(PriorityQueue queue,Map.Entry e,int p){
        Iterator i = queue.iterator();
        while(i.hasNext()){
            Node each = (Node)i.next();
            if(((Integer)each.key).equals((Integer)e.getKey())){
                if((Integer)each.value>(result.get(p)+(Integer)e.getValue())) {
                    queue.remove(each);
                    each.value = result.get(p)+(Integer)e.getValue();
                    queue.add(each);
                    return;
                }
            }
        }
        queue.add(new Node<>(e.getKey(),new Integer(result.get(p)+(Integer)e.getValue())));
    }

    public static void main(String[] args){
        Dijkstra test = new Dijkstra();
        test.addPoint();
        System.out.println(Arrays.asList(test.result.values().toArray()).toString());
    }

    static class Node<K,V extends Integer> implements Map.Entry<K,V>,Comparable<Node>{
        K key;
        V value;

        Node(K k,V v) {
            this.key = k;
            this.value =v;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return value;
        }

        @Override
        public int compareTo(Node o) {
            return value.compareTo(o.value);
        }
    }


}
