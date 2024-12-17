import java.util.concurrent.atomic.AtomicInteger;

public class Exo9 {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = exo9();
        for (Thread thread : threads) thread.join(); // Attendre la fin de tous les threads
    }

    public static Thread[] exo9() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                    atomicInteger.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()+" a incrément le compte à "+atomicInteger.get());
            });
            threads[i].start();
        }
        return threads;
    }
}
