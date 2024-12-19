package Concurrent.Exo_19;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedDeque linkedDeque = new ConcurrentLinkedDeque();
        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(()->addElements(linkedDeque));
        ex.submit(()->removelements(linkedDeque));

        ex.shutdown();
        while (!ex.isTerminated()){
            Thread.sleep(100);
        }

        System.out.println("État final de la file : "+linkedDeque);
    }

    public static void addElements(ConcurrentLinkedDeque linkedDeque){
        for (int i = 0; i < 10; i++) {
            linkedDeque.add("Producer-Element-"+i);
            System.out.println("Producer a ajouté : Producer-Element-"+i);
        }
    }

    public static void removelements(ConcurrentLinkedDeque linkedDeque){


        for (int i = 0; i < 10; i++) {
        if(!linkedDeque.contains(i)){
            System.out.println("Consumer n'a trouvé aucun élément à retirer.");
        }
            System.out.println("Consumer a retiré : Producer-Element-\" +i");
            linkedDeque.remove("Producer-ELement"+1);
        }
    }
}
