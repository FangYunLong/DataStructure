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

        public String toString(){
            return "TreeNode[data:"+data+" left:"+left+" right:"+right+" parent:"+parent+"]";
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
            parent.right = newNode;
        }
        newNode.parent = parent;
        return newNode;
    }

    public boolean empty(){
        return root.data == null;
    }

    public TreeNode getRoot(){
        if(empty()) {
            throw new RuntimeException("该树为空，无根节点");
        }
        return root;
    }

    public E getParent(TreeNode node){
        if (node == null){
            throw new RuntimeException("该节点为空，无根节点");
        }
        return (E)node.parent.data;
    }

    public E getLightChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException("该节点为空，无左子节点");
        }
        return parent.left == null ? null : (E)parent.left.data;
    }

    public E getRightChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException("该节点为空，无右子节点");
        }
        return parent.right == null ? null : (E)parent.right.data;
    }

    public int getDeep(){
        return getDeep(root);
    }

    private int getDeep(TreeNode node){
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }
        else {
            int max = 0;
            int leftDeep = getDeep(node.left);
            int rightDeep = getDeep(node.right);
            return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
        }
    }
}
