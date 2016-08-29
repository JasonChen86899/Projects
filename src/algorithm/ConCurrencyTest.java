package algorithm;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by I330347 on 5/10/2016.
 */
public class ConCurrencyTest {
    private static Object lock = new Object();
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    private static int i=0;
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public ConCurrencyTest(){
    }
    static Runnable runnable1 = () ->{
        while (i<1000) {
            reentrantLock.lock();
            if(i<1000)
                i++;
            System.out.println("runnable1: "+i+"  "+Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    };
    static Runnable runnable2 = () ->{
        while (i<1000) {
            reentrantLock.lock();
            if (i<1000)
                i++;
            System.out.println("runnable2: "+i+"  "+Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    };
    static Runnable runnable3 = () -> {
        while (i<20){
            String oldvalue =(String)concurrentHashMap.put(i,("id1_"+i));
            System.out.println(oldvalue);
            i++;
        }
        synchronized (lock){
            lock.notify();
        }
    };
    static Runnable runnable4 = () -> {
        while (i<20){
            String oldvalue =(String)concurrentHashMap.put(i,("id2_"+i));
            System.out.println(oldvalue);
        }
    };
    public static void main(String[] args){
        //new Thread(runnable1).start();
        //new Thread(runnable1).start();
        //System.out.println(Thread.currentThread().getName());
        //List<String> l = Arrays.asList("chenhao","wuzhenyu","hhhhh");
        //System.out.println(l.stream().map(s -> s.toUpperCase()).reduce("",(sum,s) -> sum+=s));
        ThreadPoolExecutor threadPoolExecutor =(ThreadPoolExecutor) Executors.newCachedThreadPool();
        threadPoolExecutor.execute(runnable3);
        threadPoolExecutor.execute(runnable4);
        /**try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (lock){
            try {
                if(i<20)
                    lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<Map.Entry> entryHashSet =concurrentHashMap.entrySet();
        Iterator<Map.Entry> iterator= entryHashSet.iterator();
        while (iterator.hasNext()){
            Map.Entry entry =iterator.next();
            System.out.println((Integer) entry.getKey()+"____"+(String)entry.getValue());
        }
        threadPoolExecutor.shutdown();
    }
}
