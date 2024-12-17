import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
      // ExecutorServiceWithRunnable();
        threadPool();
        //scheduledExecutorService();
    }

    public static void ExecutorServiceWithRunnable() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("Hello World"));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void threadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(finalI + ": " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }

    public static void scheduledExecutorService() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        //Task differe
        executor.schedule(() -> System.out.println("Hello World"), 1, TimeUnit.SECONDS);

        //Task périodique
        executor.scheduleAtFixedRate(() -> System.out.println("Hello World1"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(15000);
        executor.shutdown();

    }
}

