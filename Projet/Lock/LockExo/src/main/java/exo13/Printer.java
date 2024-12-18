package exo13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private static final Lock reentrantLock = new ReentrantLock();
    static Printer printer = new Printer();
    public void allStep()  {
        usingPrinter();
        getLock();
    }
    public static void usingPrinter(){
            System.out.println(Thread.currentThread().getName()+" tente d'utiliser l'imprimante...");
    }

    public static void getLock() {
        synchronized(reentrantLock){

        System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise l'imprimante...");
        int waitingTime = (int) ((Math.random() * (1003 - 999)) + 999);

        try {
            Thread.sleep(waitingTime);
            if (reentrantLock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante et libère le verrou.");
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé)");
        }finally {
            reentrantLock.unlock();
        }
        }
    }
}


