package cn.fyl.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fang on 2017/9/27.
 */
public class HuffmanTreeTest {
    @Test
    public void test(){
        List<HuffmanTree.Node> nodes = new ArrayList<>();
        nodes.add(new HuffmanTree.Node<>("A",0));
        nodes.add(new HuffmanTree.Node<>("B",1));
        nodes.add(new HuffmanTree.Node<>("C",2));
        nodes.add(new HuffmanTree.Node<>("D",3));
        nodes.add(new HuffmanTree.Node<>("E",4));
        nodes.add(new HuffmanTree.Node<>("F",5));
        HuffmanTree.Node root = HuffmanTree.createTree(nodes);
        List<HuffmanTree.Node> huffmanTree = HuffmanTree.breadthFirst(root);
        for (HuffmanTree.Node node : huffmanTree){
            System.out.println(node);
        }
    }
}
