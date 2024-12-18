package exo12;

public class Exo12 {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(sharedResource::addIntegerList);
        Thread thread2 = new Thread(sharedResource::removeIntegerList);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("État final de la liste : "+ SharedResource.listShared);
    }

}
