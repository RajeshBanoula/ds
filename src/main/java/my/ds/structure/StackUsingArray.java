package my.ds.structure;

import java.util.Arrays;

public class StackUsingArray<E>{

    private Object[] array;
    private int currentIndex;
    private int allowedSize =0;
    private int size =0;

    public StackUsingArray(int size){
        this.array = new Object[size];
        this.currentIndex = -1;
        this.allowedSize =size;
    }

    public void push(E e){
        if(currentIndex < allowedSize-1) {
            this.array[++currentIndex] = e;
            size++;
            return;
        }
        throw new RuntimeException("Stack is full.");
    }

    public E pop(){
        if(currentIndex>=0) {
            size--;
            return (E)array[currentIndex--];
        }
        throw new RuntimeException("Stack is Empty.");
    }

    public E peek(){
        if(currentIndex<0) {
            return (E)array[currentIndex];
        }
        throw new RuntimeException("Stack is Empty.");
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "StackUsingArray{" +
                "array=" + Arrays.toString(array) +
                ", currentIndex=" + currentIndex +
                ", allowedSize=" + allowedSize +
                ", size=" + size +
                '}';
    }
}
