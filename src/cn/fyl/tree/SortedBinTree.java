package cn.fyl.tree;

/**
 * 实现排序二叉树
 * Created by Fang on 2017/10/11.
 */
public class SortedBinTree<T extends Comparable> {
    static class Node{
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(Object data, Node parent, Node left, Node right){
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return "[data= "+data+"]";
        }

        public boolean equals(Object obj){
            if (this == obj){
                return true;
            }
            if (obj.getClass() == Node.class){
                Node target = (Node)obj;
                return data.equals(target.data)
                        && parent == target.parent
                        && left == target.left
                        && right == target.right;
            }
            return false;
        }
    }

    private Node root;

    public SortedBinTree(){
        root = null;
    }

    public SortedBinTree(T data){
        root = new Node(data,null,null,null);
    }


}
