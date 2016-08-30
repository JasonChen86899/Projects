package MQ;

/**
 * Created by I330347 on 2016/8/29.
 */


import org.springframework.test.context.ContextConfiguration;

/**
 * 此客户端可以和Spring进行结合,当然无法和Spring的Jms进行结合
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MQService extends Thread {
    private int type;



}
