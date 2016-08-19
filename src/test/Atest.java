package test;

import h.Son;

/**
 * Created by I330347 on 7/25/2016.
 */
public class Atest {
    public boolean test(){
        System.out.println(new Son());
        return true;
    }
    public void fun(){
       new Thread(()->{
           System.out.println("匿名函数");
       }).start();
    }
}
