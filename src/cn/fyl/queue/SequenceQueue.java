package cn.fyl.queue;

import java.util.Arrays;

/**
 * 实现顺序队列的基本功能
 * Created by Fang on 2017/9/9.
 */
public class SequenceQueue<T> {
    private Object[] elementData;
    private int DEFUULT_SIZE = 10;
    private int capacity;
    private int front;
    private int rear;

    public SequenceQueue(){
        capacity = DEFUULT_SIZE;
        elementData = new Object[capacity];
    }

    public SequenceQueue(T element){
        this();
        elementData[0] = element;
        rear++;
    }

    public SequenceQueue(T element, int initSize){
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    private void ensureCapacity(int minCapacity){
        if (minCapacity > capacity){
            while(capacity < minCapacity){
                capacity <<= 1;
            }
        }
    }

    public int length(){
        return rear - front;
    }

    public boolean empty(){
        return rear == front;
    }

    public void add(T element){
        if (rear == capacity){
            ensureCapacity(rear + 1);
        }
        elementData[rear++] = element;
    }

    public T remove(){
        if (empty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        T del = (T)elementData[front];
        elementData[front++] = null;
        return del;
    }

    public T getFront(){
        if (empty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T)elementData[front];
    }

    public void clear(){
        Arrays.fill(elementData,null);
        front = rear = 0;
    }

    public String toString(){
        if (empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = front;i < rear; i++){
            sb.append(elementData[i].toString()+",");
        }
        int len = sb.length();
        return sb.delete(len - 1, len).append("]").toString();
    }



}
