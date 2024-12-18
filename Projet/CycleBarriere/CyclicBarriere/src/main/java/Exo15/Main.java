package Exo15;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
    stage();
    }
    public static void stage(){
        CyclicBarrier barrier = new CyclicBarrier(3);
       Runnable task = ()->{

        for (int i = 1; i < 4; i++) {
            try {
            System.out.println(Thread.currentThread().getName()+" atteint l'étape " + i);
            barrier.await();
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
       };

        for (int i = 1; i < 4; i++) {
         new Thread(task,"Thread-"+i).start();
        }
    }
}
