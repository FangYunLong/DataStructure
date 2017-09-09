package cn.fyl.sequence;

import java.util.Arrays;

/**
 * 实现顺序表基本功能
 * Created by Fang on 2017/9/5.
 */
public class SequenceList<T> {

    private final int DEFAULT_SIZE = 16;
    //容量
    private int capacity;
    private int size = 0;
    //保存顺序表元素
    private Object[] elementData;

    public SequenceList (){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public SequenceList (T element){
        this();
        elementData[0] = element;
        size++;
    }

    public SequenceList (T element, int initSize){
        capacity = 1;
        while (capacity < initSize){
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }


    private void ensureCapactity(int minCapacity){
        if (minCapacity > capacity){
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
        }
        elementData = Arrays.copyOf(elementData,capacity);
    }

    public int length(){
        return size;
    }

    public T get(int index){
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T)elementData[index];
    }

    public int locate(T element){
        for (int i = 0; i <size; i++){
            if (elementData[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public void insert(T element,int index){
        if (index <0 || index >size){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        ensureCapactity(size + 1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = element;
        size++;
    }

    public void add(T element){
        insert(element,size);
    }

    public T delete(int index){
        if (index < 0 || index >size){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        T oldValue = (T)elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    public T remove(){
       return delete(size-1);
    }

    public boolean empty(){
        return size == 0;
    }

    public void clear(){
        Arrays.fill(elementData,null);
        size = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size ;i++){
            sb.append(elementData[i].toString()+",");
        }
        int len = sb.length();
        return sb.delete(len - 1,len).append("]").toString();
    }

}
