package cn.fyl.queue;

import java.util.Arrays;

/**
 * 实现循环队列的基本功能
 * Created by Fang on 2017/9/10.
 */
public class LoopQueue<T> {
    private Object[] elementData;
    private int DEFAULT_SIZE = 10;
    private int capacity;
    private int front;
    private int rear;

    public LoopQueue(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public LoopQueue(T element){
        this();
        elementData[0] = element;
        rear++;
    }

    public LoopQueue(T element, int initSize){
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    public int length(){
        if (empty()){
            return 0;
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    public boolean empty(){
        return rear == front && elementData[rear] == null;
    }

    public void add(T element){
        if (rear == front && elementData[front] != null){
            throw new IndexOutOfBoundsException("队列已满");
        }
        elementData[rear++] = element;
        //队列已满，队尾为0
        rear = rear == capacity ? 0 : rear;
    }

    public T remove(){
        if (empty()){
            throw new IndexOutOfBoundsException("空队列");
        }
        T del = (T)elementData[front];
        elementData[front++] = null;
        front = front == capacity ? 0 : front;
        return del;
    }

    public T getFront(){
        if (empty()){
            throw new IndexOutOfBoundsException("空队列");
        }
        return (T)elementData[front];
    }

    public void clear(){
        Arrays.fill(elementData,null);
        front = 0;
        rear = 0;
    }

    public String toString(){
        if (empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        if (front < rear){
            for (int i = front; i < rear; i++){
                sb.append(elementData[i].toString()+",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
        else{
            for (int i = front; i <capacity; i++){
                sb.append(elementData[i].toString()+",");
            }
            for (int i = front; i > rear; i++){
                sb.append(elementData[i].toString()+",");
            }
            int len = sb.length();
            return sb.delete(len - 1,len).append("]").toString();
        }
    }
}
