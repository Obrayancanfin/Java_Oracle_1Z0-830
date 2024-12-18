package exo11;

public class BankAccount {
    static double balance= 0;
    public synchronized void withdraw(double amount){
        for (int i = 0; i < 4 ; i++) {

        if (amount>balance){
            System.out.println(Thread.currentThread().getName()+" n'a pas pu retirer "+amount+" (solde insuffisant). Solde actuel : "+balance);
        }else{
            balance=balance-amount;
            System.out.println(Thread.currentThread().getName()+" a pu retirer "+amount+". Solde actuel : "+balance);
        }
        }
    }

    public synchronized void deposit(double amount){
        for (int i = 0; i < 4 ; i++) {
        balance=balance+amount;
        System.out.println(Thread.currentThread().getName()+" a déposé "+amount+", solde actuel : "+balance);
        }
    }
}
