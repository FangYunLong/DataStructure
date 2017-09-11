package cn.fyl.queue;

/**
 * Created by Fang on 2017/9/11.
 */
public class LinkQueueTest {
    public static void main(String[] args){
        LinkQueue linkQueue = new LinkQueue("aa");
        linkQueue.add("bb");
        linkQueue.add("cc");
        System.out.println(linkQueue);
        System.out.println(linkQueue.getRear());
        System.out.println(linkQueue.remove());
        System.out.println(linkQueue);
    }
}
