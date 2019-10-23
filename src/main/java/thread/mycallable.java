package thread;

import java.util.concurrent.Callable;

public class mycallable implements Callable<String> {
    public String call() throws Exception {
//        return null;
        String value="callable test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(3000);
        System.out.println("task done");
        return value;
    }
}
