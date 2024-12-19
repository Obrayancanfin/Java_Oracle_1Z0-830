package Concurrent.Exo_19;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue linkedDeque = new ConcurrentLinkedQueue();
        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(()->addElements(linkedDeque));
        ex.submit(()->removelements(linkedDeque));

        ex.shutdown();

        while (!ex.isTerminated()){
            Thread.sleep(100);
        }

        System.out.println("État final de la file : "+linkedDeque);
    }

    public static void addElements(ConcurrentLinkedQueue linkedDeque){
        for (int i = 0; i < 10; i++) {
            linkedDeque.addLast("Producer-Element-"+ i);
            System.out.println("Producer a ajouté : Producer-Element-"+i);
        }
    }

    public static void removelements(ConcurrentLinkedQueue linkedDeque){

        for (int i = 0; i < 10; i++) {

        if(linkedDeque.removeLast()==null){
            System.out.println("Consumer n'a trouvé aucun élément à retirer.");
        }

            String removed= (String) linkedDeque.removeLast();
            System.out.println("Consumer a retiré : "+removed);
        }
    }
}
