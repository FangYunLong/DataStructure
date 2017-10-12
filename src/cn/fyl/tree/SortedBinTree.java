package cn.fyl.tree;

import java.util.*;

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

    public void add(T data){
        if (root == null){
            root = new Node(data,null,null,null);
        }
        //搜索合适叶子节点，以该节点作为父节点添加新节点
        else{
            Node current = root;
            Node parent = null;
            int cmp = 0;

            do {
                parent = current;
                cmp = data.compareTo(current.data);
                if (cmp > 0){
                    current = current.right;
                }
                else{
                    current = current.left;
                }
            }while (current != null);

            Node newNode = new Node(data,parent,null,null);
            if (cmp > 0){
                parent.right = newNode;
            }
            else{
                parent.left = newNode;
            }
        }
    }

    public Node get(T data){
        Node current = root;
        int cmp = 0;
        while (current != null){
            cmp = data.compareTo(current.data);
            if (cmp > 0){
                current = current.right;
            }
            else if(cmp < 0){
                current = current.left;
            }
            else{
                return current;
            }
        }
        return null;
    }

    public void remove(T data){

    }

    public List<Node> breadthFirst(){
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            list.add(queue.peek());
            Node current = queue.poll();
            if (current.left != null){
                queue.offer(current.left);
            }
            if (current.right != null){
                queue.offer(current.right);
            }
        }
        return list;
    }

    public List<Node> depthFirst(){
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.empty()){
            list.add(stack.peek());
            Node current = stack.pop();
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
        }
        return list;
    }
}
