package my.ds.structure;

public class QueueUsingStack {

    StackUsingArray<Integer> s1 = new StackUsingArray<>(10);
    StackUsingArray<Integer> s2 = new StackUsingArray<>(10);

    public void enqueue(Integer e){

        if(s1.getSize()>10){
            throw new RuntimeException("");
        }
        s1.push(e);

    }

    public Integer dequeue(){

        while(s1.getSize()!=0){
            s2.push(s1.pop());
        }
        Integer e = s2.pop();

        while(s2.getSize()!=0){
            s1.push(s2.pop());
        }
        return e;
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        q.enqueue(6);
        q.enqueue(7);
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(8);
        System.out.println(q.s1.toString());
    }
}
