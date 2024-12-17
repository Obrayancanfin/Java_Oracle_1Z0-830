public class BankAccount {
    static double balance = 0;
    public synchronized void deposit(double amount) {

        for (int i = 0; i < 4; i++) {
            if (amount < balance) {
                balance = balance - amount;
            }
         if (balance <= 0) {
             System.out.println(Thread.currentThread().getName()+ " n'a pas pu retire " + amount +" (solde insuffisant). Solde actuel : " +balance);
         }
        }
    }

    public synchronized void withdraw(double amount) {
        for (int i = 0; i < 4 ; i++) {
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName()+"a déposer " + amount +", solde actuel : " +balance);
        }
    }

    public  synchronized void operationAccount() {
        BankAccount account = new BankAccount();
        account.deposit(10);
        account.withdraw(10);
        System.out.println("S");
    }
}
