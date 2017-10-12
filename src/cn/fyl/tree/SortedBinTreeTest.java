package cn.fyl.tree;

import org.junit.Test;

/**
 * Created by Fang on 2017/10/12.
 */
public class SortedBinTreeTest {
    @Test
    public void test(){
        SortedBinTree<Integer> sortedBinTree = new SortedBinTree<>();
        sortedBinTree.add(1);
        sortedBinTree.add(2);
        sortedBinTree.add(3);
        sortedBinTree.add(4);
        sortedBinTree.add(5);
        sortedBinTree.add(6);
        sortedBinTree.add(7);
        System.out.println(sortedBinTree.breadthFirst());
        sortedBinTree.remove(7);
        System.out.println(sortedBinTree.breadthFirst());
    }
}
