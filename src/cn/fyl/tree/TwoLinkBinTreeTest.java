package cn.fyl.tree;

import java.util.List;

/**
 * Created by Fang on 2017/9/22.
 */
public class TwoLinkBinTreeTest {
    public static void main(String[] args){
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree("root");
        TwoLinkBinTree.TreeNode root = binTree.root();
        binTree.addNode(root,"left1",true);
        binTree.addNode(root,"right1",false);
        binTree.addNode(root.left,"left2",true);
        System.out.println(binTree.deep());
        List<TwoLinkBinTree.TreeNode> list1 = binTree.breadthFirst();
        for (TwoLinkBinTree.TreeNode node : list1){
            System.out.print(node.data+" ");
        }
        System.out.println();
        List<TwoLinkBinTree.TreeNode> list2 = binTree.depthFirst();
        for (TwoLinkBinTree.TreeNode node : list2){
            System.out.print(node.data+" ");
        }
    }
}
