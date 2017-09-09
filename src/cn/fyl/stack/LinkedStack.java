package cn.fyl.stack;

/**
 * Created by Fang on 2017/9/8.
 */
public class LinkedStack<T> {
    private class Node{
        private T data;
        private Node next;

        public Node(){}

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public LinkedStack(){}

    public LinkedStack(T element){
        Node newNode = new Node(element,null);
        top = newNode;
        size++;
    }

    public int length(){
        return size;
    }

    public void push(T element){
        top = new Node(element,top);
        size++;
    }

    public T pop(){
        Node oldNode = top;
        top = null;
        top = oldNode.next;
        size--;
        return oldNode.data;
    }

    public T peek(){
        return top.data;
    }

    public boolean empty(){
        return size == 0;
    }

    public void clear(){
        top = null;
        size = 0;
    }

    public String toString(){
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node current = top; current != null; current = current.next){
            sb.append(current.data.toString()+",");
        }
        int len = sb.length();
        return sb.delete(len - 1, len).append("]").toString();
    }
}
