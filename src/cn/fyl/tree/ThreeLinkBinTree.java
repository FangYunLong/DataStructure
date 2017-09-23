package cn.fyl.tree;

/**
 *以三叉链表实现二叉树的基本功能
 * Created by Fang on 2017/9/23.
 */
public class ThreeLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(){}

        public TreeNode(Object data){
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent){
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    private TreeNode root;

    public ThreeLinkBinTree(){
        this.root = new TreeNode();
    }

    public ThreeLinkBinTree(E data){
        this.root = new TreeNode(data);
    }

    public TreeNode addNode(TreeNode parent, E data, boolean isLeft){
        if (parent == null){
            throw new RuntimeException("父节点为空，无法添加子节点");
        }
        if (isLeft && parent.left != null){
            throw new RuntimeException("父节点的左节点不为空，无法添加左子节点");
        }
        if(!isLeft && parent.right != null){
            throw new RuntimeException("父节点的右节点不为空，无法添加右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft){
            parent.left = newNode;
        }
        else{
            parent.right = new TreeNode(data);
        }

        return null;
    }
}
