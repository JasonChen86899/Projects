package algorithm;

import java.util.*;

/**
 * Created by I330347 on 8/18/2016.
 */
public class PolygonsJudgment {
    private static class node{
        int version;
        int value;
        node(int version,int value){
            this.version = version;
            this.value = value;
        }
    }
    private static TreeSet<node> valueSet = new TreeSet<>( new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            node node1 = (node) o1;
            node node2 = (node) o2;
            if (node1.version > node2.version)
                return 1;
            if (node1.version < node2.version)
                return -1;
            return 0;
        }
    }
    );
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int n =scanner.nextInt();
        int version =1;
        while (scanner.hasNext()){
            String line = scanner.next();
            String[] eachLine = line.split(" ");
            if(eachLine[0].equals("2"))
                deleteNodeValue(eachLine[1]);
            if(eachLine[0].equals("1"))
                valueSet.add(new node(version++,Integer.valueOf(eachLine[1])));
            if(polygonsJudgmentCoreMethod()) {
                //print();
                System.out.println("Yes");
            }
            else {
                //print();
                System.out.println("No");
            }
        }
    }

    private static void deleteNodeValue(String v){
        for (Iterator nodeIterator= valueSet.iterator();nodeIterator.hasNext();){
            node node = (node)nodeIterator.next();
            if(String.valueOf(node.value).equals(v)){
                valueSet.remove(node);
                break;
            }
        }
    }
    private static boolean polygonsJudgmentCoreMethod(){
        int count=0;
        if(valueSet.size()<=2)
            return false;
        int max=0;
        for (Iterator nodeIterator= valueSet.iterator();nodeIterator.hasNext();){

            node node = (node)nodeIterator.next();
            if(node.value>max)
                max=node.value;
            count+= node.value;
        }
        if(count-max>max)
            return true;
        else
            return false;

    }

    private static void print(){
        for(Iterator<node> i = valueSet.iterator();i.hasNext();){
            System.out.print(i.next().value+" ");
        }
    }
}
