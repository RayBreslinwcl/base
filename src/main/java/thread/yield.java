package thread;

public class yield {
    public static void main(String[] args) {

        Runnable yieldTask=new Runnable() {
            public void run() {
                for (int i=1;i<=20;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                    if(i==5){
                        Thread.yield();
                    }
                }
            }
        };

        Thread t1=new Thread(yieldTask,"A");
        Thread t2=new Thread(yieldTask,"B");
        t1.start();
        t2.start();

    }
}
