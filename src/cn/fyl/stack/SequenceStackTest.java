package cn.fyl.stack;

/**
 * Created by Fang on 2017/9/8.
 */
public class SequenceStackTest {
    public static void main(String[] args){
        SequenceStack<String> sequenceStack = new SequenceStack<>();
        sequenceStack.push("aa");
        sequenceStack.push("bb");
        sequenceStack.push("cc");
        System.out.println(sequenceStack);
        System.out.println(sequenceStack.peek());
        System.out.println(sequenceStack.pop());
        System.out.println(sequenceStack);
    }
}
