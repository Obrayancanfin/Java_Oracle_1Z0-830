package org.example.exo11;

public class Exo11 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        Thread thread1 = new Thread(()->bankAccount.deposit(10));
        Thread thread2 = new Thread(()->bankAccount.withdraw(10));
        Thread thread3 = new Thread(()->bankAccount.deposit(10));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("solde final : "+BankAccount.balance);

    }
}
