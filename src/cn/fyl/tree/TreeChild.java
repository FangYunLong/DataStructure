package cn.fyl.tree;

/**
 * Created by Fang on 2017/9/14.
 */
public class TreeChild<E> {
    private static class ChildNode{
        private int pos;
        private ChildNode next;

        public ChildNode(int pso,ChildNode next){
            this.pos = pos;
            this.next = next;
        }
    }

    public static class Node<T>{
        T data;
        ChildNode first;

        public Node(T data){
            this.data = data;
            first = null;
        }

        public String toString(){
            if (first != null){
                return "TreeChild.Node[data="+data+",first="+first.pos+"]";
            }else {
                return "TreeChild.Node[data="+data+",first=-1]";
            }
        }
    }
}
