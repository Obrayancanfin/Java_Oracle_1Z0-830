package Exo14;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
      loadData();
    }
    public static void loadData(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CyclicBarrier barrier = new CyclicBarrier(3,() -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer.");
        });
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName()+ " a commence à charger les données");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" a terminé le chargement des données.");
                barrier.await();

            }catch (Exception e){
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task,"Thread-"+i).start();
        }
    }
}
