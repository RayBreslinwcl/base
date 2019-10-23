package thread;

public class SyncDemo1 {
    public static void main(String... args) {
        SyncThread1 syncThread = new SyncThread1();
        Thread A_thread1 = new Thread(new SyncThread1(), "A_thread1");
        Thread A_thread2 = new Thread(new SyncThread1(), "A_thread2");
        Thread B_thread1 = new Thread(new SyncThread1(), "B_thread1");
        Thread B_thread2 = new Thread(new SyncThread1(), "B_thread2");
        Thread C_thread1 = new Thread(new SyncThread1(), "C_thread1");
        Thread C_thread2 = new Thread(new SyncThread1(), "C_thread2");

        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();

    }
}
