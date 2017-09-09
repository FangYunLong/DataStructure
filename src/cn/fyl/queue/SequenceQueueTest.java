package cn.fyl.queue;

/**
 * Created by Fang on 2017/9/9.
 */
public class SequenceQueueTest {
    public static void main(String[] args){
        SequenceQueue<String> sequenceQueue = new SequenceQueue<>();
        sequenceQueue.add("aa");
        sequenceQueue.add("bb");
        sequenceQueue.add("cc");
        System.out.println(sequenceQueue);
        sequenceQueue.remove();
        System.out.println(sequenceQueue);
        System.out.println(sequenceQueue.getFront());
        System.out.println(sequenceQueue.length());
    }
}
