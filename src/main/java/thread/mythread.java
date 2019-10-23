package thread;

public class mythread {
    public static void main(String[] args) {
        System.out.println("cuuurent thread:"+ Thread.currentThread().getName());

        //测试实现接口线程：java.thread.mythreadofRunnable
        //1.实现接口
        Runnable threadrun=new mythreadofRunnable();
        //2.通过接口实现Thread
        Thread t1=new Thread(threadrun);
        //3.通过（Thread）t1对象start运行方法
        t1.start();
        for (int i=0;i<10;i++){
            System.out.println("线程外部方法第"+i+"次输出");
        }


        //测试集成thread类线程：java.thread.mythreadofThread
        //1.实现mythreadofThread线程类
        mythreadofThread t2=new mythreadofThread();
        //2.通过（Thread）t2对象start运行方法
        t2.start();
        for (int i=0;i<10;i++){
            System.out.println("线程外部方法第"+i+"次输出");
        }
    }

}

/**
 * 线程1
 * 实现接口线程：java.thread.mythreadofRunnable
 * 实现方法：重写run方法
 */
class mythreadofRunnable implements Runnable{

    public void  run(){
        int count=0;
        while (count<=10){
            if (count%2==0){
                System.out.println("count="+count);
            }
            count++;
        }
        System.out.println("cuuurent thread:"+ Thread.currentThread().getName());
    }
}


/**
 * 线程2
 * 继承Thread类：java.thread.mythreadofThread
 * 实现方法：重写run方法
 */
class mythreadofThread extends Thread{
    int count=0;
    public void  run(){
        while (count<=10){
            if (count%2==0){
                System.out.println("count="+count);
            }
            count++;
        }
        System.out.println("cuuurent thread:"+ Thread.currentThread().getName());
    }
}
