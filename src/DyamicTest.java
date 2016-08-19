/**
 * Created by I330347 on 8/12/2016.
 */
public class DyamicTest {
    public static void main(String[] args){
        //String s = "jkdjkdjkaeecdfs2w";
        //System.out.println(s.length()-f(0,s.length()-1,s.toCharArray()));
        System.out.println((int)Math.pow(10,0));
    }
    public static int f(int i,int j,char[] a){
        if(j<i)
            return 0;
        if(i==j)
            return 1;
        if(i<j&&a[i]==a[j])
            return f(i+1,j-1,a)+2;
        return Math.max(f(i,j-1,a),f(i+1,j,a));
    }
}
