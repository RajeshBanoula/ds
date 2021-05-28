package my.ds.structure;


import java.util.LinkedList;

public class StackUsingLinkedList<E>{

    private LinkedList<E> list;
    private int allowedSize;

    public StackUsingLinkedList(E ele, int size){
        this.list = new LinkedList<E>();
        this.allowedSize = size;
    }

    public void push(E e){
        if (list.size() <= allowedSize) {
            list.push(e);
        }
        throw new RuntimeException("Stack is full.");
    }

    public E pop(){
        if (list.size() > 0) {
            return list.pop();
        }
        throw new RuntimeException("Stack is Empty.");
    }

    public E peek(){
        if (list.size() > 0) {
            return list.peek();
        }
        throw new RuntimeException("Stack is Empty.");
    }
}
