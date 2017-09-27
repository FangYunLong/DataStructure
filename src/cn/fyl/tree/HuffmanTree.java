package cn.fyl.tree;

import java.util.List;

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

        }
        return null;
    }

    private void quickSort(List<Node> nodes){
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

            }
        }
    }
}
