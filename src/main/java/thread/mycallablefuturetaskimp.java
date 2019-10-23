package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class mycallablefuturetaskimp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task=new FutureTask<String>(new mycallable());
        new Thread(task).start();

        if(!task.isDone()){
            System.out.println("task has not finished, please waitandsleep!");
        }
        System.out.println("task return :"+ task.get());
    }
}
