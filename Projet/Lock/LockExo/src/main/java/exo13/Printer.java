package org.example.exo13;

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
        reentrantLock.lock();
        synchronized (printer) {
            System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise l'imprimante...");
            int waitingTime = (int) ((Math.random() * (1001 - 998)) + 998);
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
            try {
                if (reentrantLock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante et libère le verrou.");
                } else {
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé)");
                Thread.currentThread().interrupt();
            }
        }
    }
}

