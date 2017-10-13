package cn.fyl.tree;

import org.junit.Test;

/**
 * Created by Fang on 2017/10/12.
 */
public class SortedBinTreeTest {
    @Test
    public void test(){
        SortedBinTree<Integer> sortedBinTree = new SortedBinTree<>();
        sortedBinTree.add(5);
        sortedBinTree.add(20);
        sortedBinTree.add(10);
        sortedBinTree.add(3);
        sortedBinTree.add(8);
        sortedBinTree.add(15);

        System.out.println(sortedBinTree.breadthFirst());
        sortedBinTree.remove(20);
        System.out.println(sortedBinTree.breadthFirst());
        sortedBinTree.inOrder();
    }
}
