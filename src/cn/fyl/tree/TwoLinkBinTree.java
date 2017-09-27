package cn.fyl.tree;

import java.util.*;

/**
 * 以二叉链表实现二叉树的基本功能
 * Created by Fang on 2017/9/22.
 */
public class TwoLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(Object data){
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return "TreeNode[data:"+data+" left:"+left+" right:"+right+"]";
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
        if (!left && parent.right != null){
            throw new RuntimeException("该节点已有右子节点，无法添加右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (left){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
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
        if (parent.right == null){
            throw new RuntimeException("该节点的右子节点为空");
        }
        return (E)parent.right.data;
    }

    public int deep(){
        return deep(root);
    }

    private int deep(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        else{
           int leftDeep = deep(root.left);
           int rigthDeep = deep(root.right);
           int max = leftDeep > rigthDeep ? leftDeep : rigthDeep;
           return max + 1;
        }
    }

    public List<TreeNode> breadthFirst(){
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            list.add(queue.peek());
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return list;
    }

    public List<TreeNode> depthFirst(){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            list.add(stack.peek());
            TreeNode node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    public void preOrder(){
        preOrder(root);

    }

    private void preOrder(TreeNode node){
        if (node != null){
            System.out.print(node.data+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }
    }
}
