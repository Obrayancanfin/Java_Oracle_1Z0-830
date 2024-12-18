package Exo16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static List<Integer> list = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8));
    static int sumNumber = 0;
    static int partielleSum = 0;
    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        AddNumber(list);
    }

    public static void AddNumber(List<Integer> list) {
        CyclicBarrier barrier = new CyclicBarrier(4,()-> System.out.println("Somme totale : "+sumNumber));
        Runnable task =()->{
            try {
                partielleSum = list.get(counter.get())+list.get(counter.incrementAndGet());
                sumNumber = sumNumber +partielleSum;
                System.out.println(Thread.currentThread().getName()+" a calculé une somme partielle de (indice : "+(
                        counter.get()-1) +" à indice : "+ (counter.incrementAndGet()-1)+") :" + partielleSum);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 1; i < 5; i++) {
          new Thread(task,"Thread-"+i).start();
        }
    }
}
