package thread;

public class waitandsleep {
    public static void main(String[] args) {
        final Object lock=new Object();
        //线程A：执行wait逻辑
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread A is waiting to get the lock.");
                synchronized (lock){
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait(1000);
//                        Thread.sleep(1000);
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //保证线程A先执行
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程B：执行sleep逻辑
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread B is waiting to get the lock.");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(10);
//                        lock.wait(10);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
