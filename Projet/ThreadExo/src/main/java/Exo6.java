import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exo6 {
    public static void main(String[] args) {
        exo6();
    }

    public static void exo6(){
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
        for (int i = 1; i < 4; i++) {
            int finalI = i;
            ex.schedule(()->System.out.println("Task  "+ finalI +" is excute after "+ finalI +" secondes" ),finalI, TimeUnit.SECONDS);
        };
        ex.schedule(()-> System.out.println("Toutes les tâches ont été exécutées. Arrêt du programme."), 4, TimeUnit.SECONDS);
    }
}
