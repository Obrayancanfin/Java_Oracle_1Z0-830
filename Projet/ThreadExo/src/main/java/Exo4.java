import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exo4 {
    public static void main(String[] args) {
        exo4();
    }
    public static void exo4(){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 11; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("Tache " + finalI + ": executé par " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
