package cn.fyl.tree;

/**
 * Created by Fang on 2017/9/22.
 */
public class TwoLinkBinTreeTest {
    public static void main(String[] args){
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree("root");
        TwoLinkBinTree.TreeNode root = binTree.root();
        binTree.addNode(root,"lefe1",true);
        binTree.addNode(root,"right1",false);
        binTree.addNode(root.left,"lefe2",true);
        System.out.println(binTree.deep());
    }
}
