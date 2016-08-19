package h;

/**
 * Created by I330347 on 7/25/2016.
 */
public class Son extends Father {
    protected String c = "son";
    public void setC(){
        this.c=super.c;
    }

    public boolean S(int i){
        if(this.h) ;
        return true;
    }
    public static void main(String[] args){
        Son S  =new Son();
        S.setC();
        S.S();
        System.out.println(S.c);
        Father father = new Son();
        System.out.println(father.c);
    }
}
