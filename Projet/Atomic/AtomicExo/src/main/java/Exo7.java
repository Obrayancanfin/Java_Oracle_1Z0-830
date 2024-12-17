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

        service.scheduleAtFixedRate(()-> {
            int i = count.incrementAndGet();
            System.out.println("Message periodique " + i );

            if(i==5) {
                service.shutdown();
                System.out.println("Programme terminée");
            }
        }, 1, 2, TimeUnit.SECONDS);



    }


}
