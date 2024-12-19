package Exo_20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Exo20 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Natif thread");
        AtomicInteger counter = new AtomicInteger(0);
        AtomicInteger counter1 = new AtomicInteger(0);
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.submit(()-> countingNatif(counter));
        ex.shutdown();

        System.out.println("Virtual thread");
        ExecutorService ex2 = Executors.newVirtualThreadPerTaskExecutor();
        ex2.submit(()-> countingVirtual(counter1));
        ex2.shutdown();
        while(!ex2.isTerminated()){
            Thread.sleep(100);
        }

    }

    public static void countingVirtual(AtomicInteger counter){
        long start = System.currentTimeMillis();

        for (int i = 0; i <10000000 ; i++) {
            counter.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println("Temps écoulé (virtual)  : "+ (end-start));
    }

    public static void countingNatif(AtomicInteger counter){
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000000; i++) {
            counter.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println("Temps écoulé (natif)  : "+ (end-start));
    }


}
