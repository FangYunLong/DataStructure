package cn.fyl.queue;

/**
 * Created by Fang on 2017/9/10.
 */
public class LoopQueueTest {
    public static void main(String[] args){
        LoopQueue loopQueue = new LoopQueue();
        loopQueue.add("aa");
        loopQueue.add("bb");
        loopQueue.add("cc");
        System.out.println(loopQueue);
        System.out.println(loopQueue.getFront());
        loopQueue.remove();
        System.out.println(loopQueue);
        System.out.println(loopQueue);
    }
}
