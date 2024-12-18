package exo13;

public class Exo13 {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread thread1 = new Thread(printer::allStep,"Tâche-1");
        Thread thread2 = new Thread(printer::allStep,"Tâche-2");
        Thread thread3= new Thread(printer::allStep,"Tâche-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Toutes les tâches sont terminées.");
    }
}
