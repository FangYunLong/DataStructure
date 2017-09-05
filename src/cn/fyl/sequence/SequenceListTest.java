package cn.fyl.sequence;

/**
 * Created by Fang on 2017/9/5.
 */
public class SequenceListTest {

    public static void main(String[] args){
        SequenceList<String> list = new SequenceList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.insert("dd",2);
        System.out.println(list+"  dd位置：  "+list.locate("dd"));
        list.delete(2);
        System.out.print(list);
    }

}
