package my.ds.structure;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class StackUsingQueue {

    int size;
    public StackUsingQueue(int size){
        this.size = size;
    }

    Queue<Integer> q1 = new ArrayBlockingQueue<>(size);
    Queue<Integer> q2 = new ArrayBlockingQueue<>(size);

    public void push(Integer e){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(e);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public Integer pop(){
        return q1.poll();
    }

    public static void main(String[] args) {
        StackUsingQueue queue = new StackUsingQueue(20);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.pop();
        queue.push(6);
        queue.pop();
        queue.pop();
        System.out.println(queue.q1.toString());

    }
}
