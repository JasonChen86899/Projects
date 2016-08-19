import java.util.*;

/**
 * Created by I330347 on 8/2/2016.
 */
public class Main4 {
    public static class Node{
        Node fatherOne;
        Node fatherTwo;
        String value;
        public Node(Node one,Node two,String v){
            fatherOne = one;
            fatherTwo = two;
            value = v;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] n = scanner.nextLine().split(" ");
        HashSet<Node> hashSet = new HashSet<>();
        Node[] nodes = new Node[num];
        for (int i =0;i<num;i++){
            hashSet.add(nodes[i]=new Node(null,null,n[i]));
        }
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                String valuetemp = String.valueOf(Integer.valueOf(nodes[i].value)^Integer.valueOf(nodes[j].value));
                Node node = FindByValue(nodes,valuetemp);
                if(node!=null) {
                    if(!findIfExist(nodes[i],nodes[j],valuetemp)) {
                        System.out.println(nodes[i].value);
                        System.out.println(nodes[j].value);
                        System.out.println(node.value);
                        hashSet.remove(node);
                        node.fatherOne = nodes[i];
                        node.fatherTwo = nodes[j];
                    }
                }
            }
        }
        /*for(Iterator<Node> iterator=hashSet.iterator();iterator.hasNext();) {
            System.out.println("++++++++++");
            System.out.println(iterator.next().value);
        }*/
        System.out.println(hashSet.size());
    }

    public static  Node FindByValue(Node[] nodes,String v){
        for(Node node: nodes){
            if(node.value.equals(v))
                return node;
        }
        return null;
    }

    public static boolean findIfExist(Node node1,Node node2,String v){
        return cc(node1,v)||cc(node2,v);
    }
    private static boolean cc(Node node,String v){
        if(node.value.equals(v))
            return true;
        if(node.fatherOne==null||node.fatherTwo==null)
            return false;
        return cc(node.fatherOne,v)||cc(node.fatherTwo,v);

    }
}
