package cn.fyl.tree;

import java.util.List;

/**
 * Created by Fang on 2017/9/12.
 */
public class TreeParentTest {
    public static void main(String[] args){
        TreeParent<String> treeParent = new TreeParent<String>("root");
        TreeParent.Node root = treeParent.root();
        System.out.println(treeParent.root());
        treeParent.addNode("left children1",root);
        treeParent.addNode("right children1",root);
        System.out.println(treeParent.deep());
        List<TreeParent.Node<String>> childrens = treeParent.children(root);
        TreeParent.Node leftChildren1 = childrens.get(0);
        treeParent.addNode("leftChildren2",leftChildren1);
        System.out.print(treeParent.deep());
    }
}
