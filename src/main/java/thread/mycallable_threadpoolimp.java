package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mycallable_threadpoolimp {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool= Executors.newCachedThreadPool();
        Future<String> future=newCachedThreadPool.submit(new mycallable());
        //1.判断是否执行完，没有执行完，给出提示
        if(!future.isDone()){
            System.out.println("task has not finished, please waitandsleep");
        }
        //2.阻塞主线程，直到子线程执行结束
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();
        }

    }
}
