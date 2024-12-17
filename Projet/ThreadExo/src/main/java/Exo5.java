import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Exo5 implements Callable<Integer> {
    public static void main(String[] args) {
    }

    public static void exo5(){
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
        Future<Integer>[] futures = new Future[10];

    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
