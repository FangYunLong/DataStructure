package cn.fyl.tree;

/**
 * Created by Fang on 2017/9/20.
 */
public class ArrayBinTreeTest {
    public static void main(String[] args){
        ArrayBinTree<String> binTree = new ArrayBinTree(3,"root");
        binTree.addNode(0,"left1",true);
        binTree.addNode(0,"right1",false);
        binTree.addNode(1,"left2",true);
        binTree.addNode(1,"right2",false);
        System.out.println("树的deep："+binTree.deep());
        System.out.println("根节点的左节点："+binTree.left(0));
        System.out.println("left1的父节点："+binTree.parent(1));
        System.out.println(binTree);
    }
}
