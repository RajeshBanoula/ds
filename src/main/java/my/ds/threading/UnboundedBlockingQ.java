package my.ds.threading;

import java.util.ArrayList;
import java.util.List;

public class UnboundedBlockingQ<E> {

    private List<E> list;
    volatile int currentIndex =-1;
    //private int boundSize =-1;
    private boolean isEmpty;

    public UnboundedBlockingQ(){
        this.list = new ArrayList<>();
        //this.boundSize = size;
        isEmpty = true;
    }

    public void enqueue(E e){
        boolean inserted=false;
        while (!inserted) {
            synchronized (this) {
                //if (currentIndex < boundSize - 1) {
                inserted = list.add(e);
                currentIndex++;
                notifyAll();
                /*} else{
                    try {
                        System.out.println("the queue in full, waiting for consumer to empty the queue, list : "+ list);
                        wait();
                    } catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }*/
            }
        }
    }

    public E dequeue(){
        E rev = null;
        boolean removed=false;
        while (!removed) {
            synchronized (this) {
                if (currentIndex >= 0) {
                    rev = list.remove(currentIndex--);
                    removed = true;
                    //notifyAll();
                }
                else{
                    try {
                        System.out.println("the queue has no element, waiting for producer to insert");
                        wait();
                    } catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }

            }
        }
        return rev;
    }
}

class TestUnboundedBlockingQ{
    public static void main(String[] args) {
        UnboundedBlockingQ<Integer> b = new UnboundedBlockingQ<>();
        Runnable producer = ()-> {
            for (int j = 0; j < 15; j++) {
                b.enqueue(j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };

        Runnable consumer = ()-> {
            for (int i = 0; i < 15; i++) {
                System.out.println("removed element:" + b.dequeue());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }

        };

        new Thread(consumer).start();


        new Thread(producer).start();
    }
}
