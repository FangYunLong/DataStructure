package cn.fyl.stack;

import java.util.Arrays;

/**
 * 实现顺序栈基本功能
 * Created by Fang on 2017/9/7.
 */
public class SequenceStack<T> {
    private final int DEFAULT_SIZE = 10;
    private int capacity;
    private int capacityIncrement;
    private Object[] elementData;
    private int size;

    public SequenceStack(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public SequenceStack(T element){
        this();
        elementData[0] = element;
        size++;
    }

    public SequenceStack(T element, int initSize){
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    public SequenceStack(T element, int initSize, int capacityIncrement){
        this(element,initSize);
        this.capacityIncrement = capacityIncrement;
    }

    private void ensureCapacity(int minCapacity){
        if (minCapacity > capacity){
            if (capacityIncrement > 0){
                while (capacity < minCapacity){
                    capacity += capacityIncrement;
                }
            }else {
                while (capacity < minCapacity){
                    capacity <<= 1;
                }
            }
            elementData = Arrays.copyOf(elementData,capacity);
        }
    }

    public int length(){
        return size;
    }

    public void push(T element){
        ensureCapacity(capacity + 1);
        elementData[size++] = element;
    }

    public T pop(){
        T del = (T)elementData[size - 1];
        elementData[--size] = null;
        return del;
    }

    public T peek(){
        return (T)elementData[size - 1];
    }

    public boolean empty(){
        return  size == 0;
    }

    public void clear(){
        Arrays.fill(elementData,null);
        size = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >-1; i--){
            sb.append(elementData[i].toString()+",");
        }
        int len = sb.length();
        sb.delete(len - 1 , len).append("]");
        return sb.toString();
    }
}
