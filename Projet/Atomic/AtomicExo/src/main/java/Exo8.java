import java.util.concurrent.atomic.AtomicInteger;

public class Exo8 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = exo8();
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join(); // Attendre la fin de tous les threads
        System.out.println("Valeur finale atomique : "+atomicInteger.get());
    }

    public static Thread[] exo8() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
        }
        return threads;
    }

}
