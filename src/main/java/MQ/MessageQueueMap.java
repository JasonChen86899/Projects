package MQ;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by I330347 on 2016/8/30.
 */
public class MessageQueueMap {
    private HashMap<String,ConcurrentLinkedDeque> Map = new HashMap<String, ConcurrentLinkedDeque>();
}
