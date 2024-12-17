public class Exo11 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                threads[i]= new Thread(bankAccount::operationAccount);
                threads[i].start();
            }
        }
    }
}
