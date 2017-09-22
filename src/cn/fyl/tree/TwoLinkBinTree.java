package cn.fyl.tree;

/**
 * 以二叉链表实现二叉树的基本功能
 * Created by Fang on 2017/9/22.
 */
public class TwoLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode rigth;

        public TreeNode(){}

        public TreeNode(Object data){
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode rigth){
            this.data = data;
            this.left = left;
            this.rigth = rigth;
        }

        public String toString(){
            return "TreeNode[data:"+data+" left:"+left+" rigth:"+rigth+"]";
        }
    }

    private TreeNode root;

    public TwoLinkBinTree(){
        this.root = new TreeNode();
    }

    public TwoLinkBinTree(E data){
        this.root = new TreeNode(data);
    }

    /**
     * 为指定节点添加节点
     * @param parent 为该节点添加子节点
     * @param data 新增节点的数据
     * @param left 是否为左孩子
     */
    public TreeNode addNode(TreeNode parent, E data, boolean left){
        if (parent == null){
            throw new RuntimeException("该节点为null，无法添加的新节点");
        }
        if (left && parent.left != null){
            throw new RuntimeException("该节点已有左子节点，无法添加左子节点");
        }
        if (!left && parent.rigth != null){
            throw new RuntimeException("该节点已有右子节点，无法添加右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (left){
            parent.left = newNode;
        }
        else{
            parent.rigth = newNode;
        }
        return newNode;
    }

    public boolean empty(){
        return root.data == null;
    }

    public TreeNode root(){
        if (empty()){
            throw new RuntimeException("该树为空，无法访问根节点");
        }
        return root;
    }

    public E parent(TreeNode node){
        return null;
    }

    public E getLeftChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException("该节点为空，无左子节点");
        }
        if (parent.left == null){
            throw new RuntimeException("该节点的左子节点为空");
        }
        return (E)parent.left.data;
    }

    public E getRightChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException("该节点为空，无右子节点");
        }
        if (parent.rigth == null){
            throw new RuntimeException("该节点的右子节点为空");
        }
        return (E)parent.rigth.data;
    }

    public int deep(){
        return deep(root);
    }

    private int deep(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.rigth == null){
            return 1;
        }
        else{
           int leftDeep = deep(root.left);
           int rigthDeep = deep(root.rigth);
           int max = leftDeep > rigthDeep ? leftDeep : rigthDeep;
           return max + 1;
        }
    }
}
