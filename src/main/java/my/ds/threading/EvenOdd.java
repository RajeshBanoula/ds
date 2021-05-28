package my.ds.threading;


public class EvenOdd {
    public static void main(String[] args) {

        Print p = new Print(2, 10);

        Thread t1 = new Thread(()->p.printEven());
        Thread t2 = new Thread(()->p.printOdd());

        t1.start();
        t2.start();
    }
}
class Print{
    int limit;
    int start;
    public Print(int min, int max){
        this.limit = max;
        this.start = min;
    }
    public void printOdd(){

        boolean odd = true;
        while(start<=limit){
            synchronized (this){
                if(odd){
                    System.out.println(start++);
                    odd=false;
                    notifyAll();
                } else{
                    try {
                        wait();
                        odd= true;
                    }catch(InterruptedException ie){

                    }
                }
            }
        }
    }

    public void printEven(){
        boolean even = false;
        while(start<=limit){
            synchronized (this){
                if(even){
                    System.out.println(start++);
                    even=false;
                    notifyAll();
                } else{
                    try {
                        wait();
                        even= true;
                    }catch(InterruptedException ie){

                    }
                }
            }
        }

    }
}
