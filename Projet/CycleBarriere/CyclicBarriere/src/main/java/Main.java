import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        BarriereSimulator();
    }

    private static void BarriereSimulator(){
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () ->{

        try {
            System.out.println(Thread.currentThread().getName() + ": atteint la barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " continue apres la barrier");
        }catch (Exception e){
            throw new RuntimeException();
        }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread " + i).start();
        }
    }
}
