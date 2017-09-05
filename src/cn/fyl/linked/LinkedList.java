package cn.fyl.linked;

/**
 * 实现单链表的基本功能
 * Created by Fang on 2017/9/5.
 */
public class LinkedList<T> {

    private class Node{
        private T data;
        private Node next;

        public Node(){}

        public Node(T data , Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node header,tail;
    private int size;

    public LinkedList(){
        header=null;
        tail=null;
    }

    public LinkedList(T element){
        header = new Node(element,null);
        header = tail;
        size++;
    }

    public int length(){
        return size;
    }

    private Node getNodeByIndex(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = current.next){
            if (i == index){
                return current;
            }
        }
        return null;
    }

    public T get(int index){
        return getNodeByIndex(index).data;
    }

    public int locate(T element){
        Node current = header;
        for (int i = 0; i < size && current != null; i++,current = current.next){
            if (current.data.equals(element)) {
                return i;
            }
        }
        return  -1;
    }

    /**
     * 尾插法
     * @param element
     */
    public void add(T element){
        if (header == null){
            header =  new Node(element,null);
            tail = header;
        }else{
            Node newNode = new Node(element,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtHeader(T element){
        header = new Node(element,header);
        if (header == null){
            tail = header;
        }
        size++;
    }

    public void insert(T element , int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        if (header == null){
            add(element);
        }else{
            if (index == 0){
                addAtHeader(element);
            }else{
                Node prev = getNodeByIndex(index - 1);
                prev.next = new Node(element,prev.next);
                size++;
            }
        }
    }

    public T delete(int index){
        if (index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        Node del = null;
        if (index == 0){
            del = header;
            header = header.next;
        }else{
            del = getNodeByIndex(index);
            Node prev = getNodeByIndex(index - 1);
            prev.next = del.next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    public T remove(){
        return delete(size - 1);
    }

    public boolean empty(){
        return size == 0;
    }

    public void clear(){
        header = null;
        tail = null;
        size = 0;
    }

    public String toString(){
        if (empty()){
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next){
                sb.append(current.data.toString()+",");
            }
            int len =sb.length();
            return sb.delete(len - 1,len).append("]").toString();
        }
    }
}
