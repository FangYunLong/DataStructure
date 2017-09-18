package cn.fyl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 以子节点链表示法实现一棵树
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

    private final int DEFAULT_SIZE = 100;
    private int treeSize;
    private Node<E>[] nodes;
    private int nodeNums;

    public TreeChild(E data){
        treeSize = DEFAULT_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    public TreeChild(E data,int treeSize){
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    public void addNode(E data,Node parent){
        for (int i = 0; i < treeSize; i++){
            if (nodes[i] == null){
                if (parent.first == null){
                    parent.first = new ChildNode(i , null);
                }
                else{
                    ChildNode next = parent.first;
                    while (next.next != null){
                        next = next.next;
                    }
                    next.next = new ChildNode(i , null);
                }
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("该树已满，无法添加新结点");
    }

    public boolean empty(){
        return nodes[0] == null;
    }

    public Node<E> root(){
        return nodes[0];
    }

    public List<Node<E>> children(Node parent){
        List<Node<E>> children = new ArrayList<>();
        ChildNode next = parent.first;
        while (next != null){
            children.add(nodes[next.pos]);
            next = next.next;
        }
        return children;
    }

    public Node<E> child(Node parent , int index){
        ChildNode next = parent.first;
        for (int i = 0; next != null; i++){
            if (index == i){
                return nodes[next.pos];
            }
            next = next.next;
        }
        return null;
    }

    public int deep(){
        return deep(root());
    }

    public int deep(Node node){
        if (node.first == null){
            return 1;
        }
        else{
            int max = 0;
            ChildNode next = node.first;
            while (next != null){
                int tmp = deep(nodes[next.pos]);
                if (tmp > max){
                    max = tmp;
                }
                next = next.next;
            }
            return max + 1;
        }
    }
}
