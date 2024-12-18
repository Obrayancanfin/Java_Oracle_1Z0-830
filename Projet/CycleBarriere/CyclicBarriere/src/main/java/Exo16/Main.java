package Exo16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static List<Integer> list = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8));
    static AtomicInteger sumNumber = new AtomicInteger(0);
    static AtomicInteger partielleSum = new AtomicInteger(0);
    static AtomicInteger counter = new AtomicInteger(0);
    static AtomicIntegerArray counterArray = new AtomicIntegerArray(list.size()/2);
    public static void main(String[] args) {
        AddNumber(list);
    }

    public static void AddNumber(List<Integer> list) {
        CyclicBarrier barrier = new CyclicBarrier(4,()-> System.out.println("Somme totale : "+sumNumber + " Tableau somme partielle : " + counterArray ));
        Runnable task =()->{
            try {
                int i = counter.get();
                partielleSum.set( list.get(counter.get())+list.get(counter.incrementAndGet()));
                int partielle = partielleSum.get();
                counterArray.getAndSet(i,partielle);
                sumNumber.accumulateAndGet(partielleSum.get(),Integer::sum);
                System.out.println(Thread.currentThread().getName()+" a calculé une somme partielle de (indice : "+ i +" à indice : "+(i+1)+") : " + partielle);
                counter.getAndIncrement();
                counter.getAndIncrement();
                barrier.await();
                sumNumber.set(0);
                for (int j = 0; j < counterArray.length(); j++) {
                    sumNumber.accumulateAndGet(counterArray.get(j),Integer::sum);
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 1; i < 5; i++) {
          new Thread(task,"Thread-"+i).start();
        }
    }
}
