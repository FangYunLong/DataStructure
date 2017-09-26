package cn.fyl.tree;

import java.util.List;

/**
 * Created by Fang on 2017/9/22.
 */
public class TwoLinkBinTreeTest {
    public static void main(String[] args){
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree("1");
        TwoLinkBinTree.TreeNode root = binTree.root();
        binTree.addNode(root,"2",true);                           //           1
        binTree.addNode(root,"3",false);                         //        2       3
        binTree.addNode(root.left,"4",true);                    //      4    5  6     7
        binTree.addNode(root.left,"5",false);
        binTree.addNode(root.right,"6",true);
        binTree.addNode(root.right,"7",false);
        System.out.println(binTree.deep());
        System.out.println("广度遍历：");
        List<TwoLinkBinTree.TreeNode> list1 = binTree.breadthFirst();
        for (TwoLinkBinTree.TreeNode node : list1){
            System.out.print(node.data+" ");
        }
        System.out.println();
        System.out.println("深度遍历：");
        List<TwoLinkBinTree.TreeNode> list2 = binTree.depthFirst();
        for (TwoLinkBinTree.TreeNode node : list2){
            System.out.print(node.data+" ");
        }
        System.out.println();
        System.out.println("先序遍历：");
        binTree.preOrder();
        System.out.println();
        System.out.println("中序遍历：");
        binTree.inOrder();
        System.out.println();
        System.out.println("后序遍历：");
        binTree.postOrder();
    }
}
