package Concurrent.Exo_18;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList listSet = new CopyOnWriteArrayList();
        ExecutorService ex = Executors.newFixedThreadPool(3);

        Runnable task =()-> {
          addToList(listSet);
        };

        ex.submit(task);
        ex.submit(task);
        ex.submit(task);

        ex.shutdown();

        while (!ex.isTerminated()){
            Thread.sleep(100);
        }
        System.out.println("Liste finale des produits : "+listSet);
    }

    public static void addToList(CopyOnWriteArrayList listSet){
        for (int i = 0; i < 3; i++) {
        int number = ThreadLocalRandom.current().nextInt(9);
        String threadProduct = Thread.currentThread().getName()+"Produit-"+number;
            System.out.println(threadProduct);
        listSet.add(threadProduct);
        }
    }

}
