package cn.fyl.stack;

/**
 * Created by Fang on 2017/9/9.
 */
public class LinkedStackTest {
    public static void main(String[] args){
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("aa");
        linkedStack.push("bb");
        linkedStack.push("cc");
        System.out.println(linkedStack);
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.pop());
        System.out.print(linkedStack);
    }
}
