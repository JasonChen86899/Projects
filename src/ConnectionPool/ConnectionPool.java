package ConnectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by I330347 on 8/25/2016.
 */
public class ConnectionPool extends AbstractExecutorService {
    private ConcurrentLinkedDeque<Runnable> runableQueue = new ConcurrentLinkedDeque();
    private HashSet<Thread> threadsset = new HashSet<>();
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notEmpty = reentrantLock.newCondition();
    private Runnable recycleRunable = () ->{
        while(true){
            Runnable firstRunable = runableQueue.poll();
            if(firstRunable!=null)
                firstRunable.run();
            else {
                reentrantLock.lock();
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        }
    };
    private int coreNum;
    private int MaxNum;
    public ConnectionPool(int c,int m){
        this.coreNum = c;
        this.MaxNum = m;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {
        if(command == null)
            return;
        if(threadsset.size()<coreNum){
            Thread newthread = new Thread(command){
                @Override
                public void run(){
                    command.run();
                    recycleRunable.run();
                }
            };

            //ProxyProduce proxyProduce = new ProxyProduce(newthread,recycleRunable);
            //Thread proxyThread =(Thread)proxyProduce.bind();
            threadsset.add(newthread);
            //proxyThread.start();
            newthread.start();
        }else {
            runableQueue.add(command);
            reentrantLock.lock();
            notEmpty.signal();
            reentrantLock.unlock();
        }
    }

    public void printInfo(){
        Iterator<Thread> iterator = threadsset.iterator();
        while (iterator.hasNext()) {
            Thread thread = iterator.next();
            System.out.println(thread.toString()+thread.getState().name());
        }
        System.out.println(runableQueue.size());
    }

    private static class ProxyProduce implements InvocationHandler{
        private Runnable runnable;
        private Object target;
        public ProxyProduce(Object target,Runnable r){
            this.target = target;
            this.runnable = r;
        }
        public Object bind(){
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(target,args);
            runnable.run();
            return result;
        }
    }
}
