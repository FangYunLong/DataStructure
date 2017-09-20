package cn.fyl.tree;

/**
 * Created by Fang on 2017/9/19.
 */
public class TreeChildTest {
    public static void main(String[] agrs){
        TreeChild<String> treeChild = new TreeChild<String>("root");
        TreeChild.Node root = treeChild.root();
        System.out.println(root);
        treeChild.addNode("节点1",root);
        treeChild.addNode("节点2",root);
        TreeChild.Node second = treeChild.child(root,1);
        treeChild.addNode("节点3",second);
        System.out.println(treeChild.deep());
    }
}
