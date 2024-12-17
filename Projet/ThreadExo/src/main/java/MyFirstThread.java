public class MyFirstThread extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new MyFirstThread().start();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
        System.out.println("Thread-" + getName() +" - Compteur :" + i);
        }
    }
}
