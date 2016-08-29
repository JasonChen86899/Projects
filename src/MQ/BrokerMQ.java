package MQ;


import org.zeromq.ZMQ;

/**
 * Created by I330347 on 2016/8/27.
 */
public class BrokerMQ extends Thread {
    private String tcp;
    private int type;
    private ZMQ.Socket transfer;
    public BrokerMQ(String tcpAddress,int t){//type 指的是ZMQ下面的传输方式
        this.tcp = tcpAddress;
        this.type = t;
        ZMQ.Context context = ZMQ.context(1);//可以分配两个线程给给这个context，主要针对两个线程一个分别是消费者，一个是生产者,当然也可以不这样做表示  启动两个在这样的线程，之间可以实行持久化
        this.transfer = context.socket(type);
        transfer.bind(tcp);
    }

    public String doReceive(){
       if(type == ZMQ.PULL){
           return transfer.recvStr();
       }
        return null;
    }

    public boolean doSend(String sendData){
        if(type == ZMQ.PUSH){
            try{
                return transfer.send(sendData);
            }catch (Throwable throwable) {
                return false;
            }
        }
        return false;
    }

}
