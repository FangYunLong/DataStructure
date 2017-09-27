package cn.fyl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 创建哈夫曼树
 * Created by Fang on 2017/9/27.
 */
public class HuffmanTree {
    public static class Node<E>{
        E data;
        Node left;
        Node right;
        double weight;

        public Node(E data, double weight){
            this.data = data;
            this.weight = weight;
        }

        public String toString(){
            return "Node[data:"+data+" weight:"+weight+"]";
        }
    }

    public static Node createTree(List<Node> nodes){
        while(nodes.size() > 1){
            quickSort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null,left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static void quickSort(List<Node> nodes){
        subSort(nodes,0,nodes.size() - 1);
    }

    private static void swap(List<Node> nodes ,int i , int j){
        Node temp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, temp);
    }

    private static void subSort(List<Node> nodes, int start, int end){
        if (start < end){
            Node base = nodes.get(start);
            int i = start;
            int j = end + 1;
            while (true){
                while (i < end && nodes.get(++i).weight >= base.weight);
                while (j > start &&nodes.get(--j).weight <= base.weight);
                if (i < j) {
                    swap(nodes, i, j);
                }
                else {
                    break;
                }
            }
            swap(nodes,start,j);
            subSort(nodes,start,j - 1);
            subSort(nodes,j + 1,end);
        }
    }

    public static List<Node> breadthFirst(Node root){
        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            list.add(queue.peek());
            Node node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return list;
    }

}
