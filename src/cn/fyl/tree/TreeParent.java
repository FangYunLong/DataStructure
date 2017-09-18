package cn.fyl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 以父节点表示法实现一一棵树
 * Created by Fang on 2017/9/12.
 */
public class TreeParent<E> {
    //保存结点的数据及结点的父节点位置
    public static class Node<T>{
        T data;
        int parent;

        public Node(){}

        public Node(T data){
            this.data = data;
        }

        public Node(T data, int parent){
            this.data = data;
            this.parent = parent;
        }

        public String toString(){
            return "TreeParent.Node[data="+data+" parent="+parent+"]";
        }
    }

    private final int DEFUALT_TREE_SIZE =100;
    private int treeSize;
    private Node<E>[] nodes;
    private int nodeNums;

    public TreeParent(E data){
        treeSize = DEFUALT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data,-1);
        nodeNums++;
    }

    public TreeParent(E data,int treeSize){
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data,-1);
        nodeNums++;
    }

    public int pos(Node node){
        for (int i = 0; i <treeSize; i++){
            if (nodes[i] == node){
                return i;
            }
        }
        return -1;
    }

    public void addNode(E data, Node parent){
        for (int i = 0; i <treeSize; i++){
            if (nodes[i] == null){
                nodes[i] = new Node(data,pos(parent));
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

    public Node<E> parent(Node node){
        return nodes[node.parent];
    }

    public List<Node<E>> children(Node parent){
        List<Node<E>> childrens = new ArrayList<>();
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null && nodes[i].parent == pos(parent)){
                childrens.add(nodes[i]);
            }
        }
        return childrens;
    }

    public int deep(){
        int max = 0;
        for (int i = 0; i <treeSize && nodes[i] != null; i++){
            int currentDeep = 1;
            int parentPos = nodes[i].parent;
            while (parentPos != -1 && nodes[parentPos] != null){
                parentPos = nodes[parentPos].parent;
                currentDeep++;
            }
            if (max < currentDeep){
                max = currentDeep;
            }
        }
        return max;
    }

}
