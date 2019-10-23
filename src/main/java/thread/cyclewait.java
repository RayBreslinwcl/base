package thread;

public class cyclewait implements Runnable {

    private String value;

    /**
     * 等待7秒后再给value赋值
     */
    public void run() {
        try {
            Thread.currentThread().sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value="we have done now";
    }

    public static void main(String[] args) throws InterruptedException {

        //1.创建子线程
        cyclewait mcw=new cyclewait();
        Thread t=new Thread(mcw);
        //2.开启子线程
        t.start();

        //3.1主线程等待
//        while (mcw.value==null){
//            Thread.currentThread().sleep(1000);
//        }
//        System.out.println("value : " +mcw.value);

        //3.2 join方法：主线程阻塞
        t.join();
        System.out.println("value : " +mcw.value);
    }
}



