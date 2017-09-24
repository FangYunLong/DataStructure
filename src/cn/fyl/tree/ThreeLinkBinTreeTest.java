package cn.fyl.tree;

import org.junit.Test;

/**
 * Created by Fang on 2017/9/24.
 */
public class ThreeLinkBinTreeTest {
    @Test
    public void test(){
        ThreeLinkBinTree<String> binTree = new ThreeLinkBinTree<>("root");
        ThreeLinkBinTree.TreeNode root = binTree.getRoot();
        binTree.addNode(root,"left1",true);
        binTree.addNode(root,"right1",false);
        binTree.addNode(root.left,"left2",true);
        binTree.addNode(root.left,"right2",false);
        System.out.println(binTree.getDeep());
        System.out.println(binTree.getLightChild(root));
        System.out.println(binTree.getLightChild(root.left));
    }
}
