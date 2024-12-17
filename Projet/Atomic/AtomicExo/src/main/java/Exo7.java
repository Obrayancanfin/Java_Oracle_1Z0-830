import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exo7 {

    public static void main(String[] args) {
        exo7();
    }

    public static void exo7() {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger count = new AtomicInteger(0);
        count.set(1);
        while (count.get() < 5) {
        service.scheduleAtFixedRate(()-> System.out.println("Message periodique " + count.getAndIncrement()), 1, 2, TimeUnit.SECONDS);
        }
        service.shutdown();

    }


}
