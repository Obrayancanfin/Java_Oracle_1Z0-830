import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exo7 {

    public static void main(String[] args) {
        exo7();
    }

    public static void exo7() {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger count = new AtomicInteger(0);
        service.scheduleWithFixedDelay(()-> System.out.println("Message périodique "+count.incrementAndGet()),1,5,TimeUnit.SECONDS);
        service.shutdown();

    }


}
