import java.util.concurrent.atomic.AtomicLong;

public class Exo10 {
    static AtomicLong atomicLong = new AtomicLong(1);
    static int finalJ = 0;
    public static void main(String[] args) throws InterruptedException {
        Exo10();
    }

    public static Thread[] Exo10() throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int finalI = i+2;
            threads[i] = new Thread(() -> {
                    long value = atomicLong.updateAndGet(x -> x * finalI);
                    System.out.println(Thread.currentThread().getName() + ": " + value);
                });
            threads[i].start();
            threads[i].join();
        }
        return threads;
    }
}
