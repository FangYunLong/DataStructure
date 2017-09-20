package cn.fyl.tree;

import java.util.Arrays;

/**
 * 以顺序储存结构实现二叉树
 * Created by Fang on 2017/9/20.
 */
public class ArrayBinTree<T> {
    private Object[] tree;
    private final int DEFAULT_DEEP = 8;
    private int deep;
    private int treeSize;
    private int nodeNums;

    public ArrayBinTree(){
        deep = DEFAULT_DEEP;
        treeSize = (int)Math.pow(2,deep) - 1;
        tree = new Object[treeSize];

    }

    public ArrayBinTree(int deep){
        this.deep = deep;
        treeSize = (int)Math.pow(2,deep) - 1;
        tree = new Object[treeSize];
    }

    public ArrayBinTree(T data){
        deep = DEFAULT_DEEP;
        treeSize = (int)Math.pow(2,deep) - 1;
        tree = new Object[treeSize];
        tree[0] = data;
    }

    public ArrayBinTree(int deep , T data){
        this.deep = deep;
        treeSize = (int)Math.pow(2,deep) - 1;
        tree = new Object[treeSize];
        tree[0] = data;
    }

    /**
     * 添加节点
     * @param index 需要添加节点的父节点的索引
     * @param data 添加节点的数据
     * @param left 是否为左节点
     */
    public void addNode(int index , T data , boolean left){
        if (tree[index] == null){
            throw new RuntimeException(index+"处节点为空，无法添加子节点");
        }
        if (index * 2 + 1 >= treeSize){
            throw new RuntimeException("树的底层数组已满，树越界异常");
        }
        if (left){
            //底层数组索引从零开始
            tree[index * 2 + 1] = data;
        }
        else{
            tree[index * 2 + 2] =data;
        }
        nodeNums++;
    }

    public boolean empty(){
        return tree[0] == null;
    }

    public T root(){
        return (T)tree[0];
    }

    public T parent(int index){
        return (T)tree[(index - 1)/2];
    }

    public T left(int index){
        if (index * 2 + 1 >= treeSize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T)tree[index * 2 + 1];
    }

    public T right(int index){
        if (index * 2 + 1 >= treeSize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T)tree[index * 2 + 2];
    }

    public int deep(){
        return deep;
    }

    public int pos(T data){
        for (int i = 0; i < treeSize - 1; i++){
            if (tree[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        return Arrays.toString(tree);
    }
}
