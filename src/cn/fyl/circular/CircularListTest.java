package cn.fyl.circular;

/**
 * Created by Fang on 2017/9/6.
 */
public class CircularListTest {
    public static void main(String[] args){
        CircularList<String> circularList = new CircularList<>();
        circularList.add("aa");
        circularList.add("bb");
        circularList.add("cc");
        System.out.println(circularList);
        circularList.insert("ss",1);
        System.out.println(circularList);
        System.out.println(circularList.delete(1));
        circularList.addAtHeader("abc");
        System.out.println(circularList);
        System.out.println(circularList.locate("aa"));
        System.out.println(circularList.remove());
        System.out.println(circularList.delete(1));
        System.out.println(circularList.get(1));

    }
}
