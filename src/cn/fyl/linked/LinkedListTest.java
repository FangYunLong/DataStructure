package cn.fyl.linked;

/**
 * Created by Fang on 2017/9/5.
 */
public class LinkedListTest {

    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.insert("dd",1);
        System.out.println(linkedList);
        linkedList.delete(1);
        System.out.println(linkedList);
        linkedList.addAtHeader("abc");
        System.out.println(linkedList);
        System.out.println(linkedList.locate("abc"));
        System.out.println(linkedList.get(0));
    }

}
