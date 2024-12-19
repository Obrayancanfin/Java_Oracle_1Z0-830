package Concurrent.Exo_17;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap products = new ConcurrentHashMap<String,Integer>();
        products.put("ProduitA",100);
        products.put("ProduitB",100);
        products.put("ProduitC",100);

        System.out.println(products);

        Thread thread1 = new Thread(()->buyProduct(products,"ProduitC",1),"Acheteur-1");
        Thread thread2 =new Thread(()->buyProduct(products,"ProduitA",1),"Acheteur-1");
        Thread thread3 =new Thread(()->restockProduct(products,"ProduitA",10),"Reapprovisionneur");
        Thread thread4 =new Thread(()->buyProduct(products,"ProduitB",1),"Acheteur-1");
        Thread thread5 =new Thread(()->buyProduct(products,"ProduitC",1),"Acheteur-1");
        Thread thread6 =new Thread(()->buyProduct(products,"ProduitA",1),"Acheteur-1");
        Thread thread7 = new Thread(()->restockProduct(products,"ProduitB",10),"Reapprovisionneur");
        Thread thread8 = new Thread(()->buyProduct(products,"ProduitA",1),"Acheteur-1");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();

        System.out.println("Inventaire final : " + products);

    }

    public static void buyProduct(ConcurrentHashMap products , String product,Integer quantity){
        Integer actualQuantity = (Integer) products.get(product);
        products.replace(product,actualQuantity-quantity);
        System.out.println(Thread.currentThread().getName()+" a acheté " + quantity + " de "+ product);
    }

    public static void restockProduct(ConcurrentHashMap products , String product , Integer quantity){
        Integer actualQuantity = (Integer) products.get(product);
        products.replace(product,actualQuantity+quantity);
        System.out.println(Thread.currentThread().getName()+"a réapprovisionné "+ quantity + "unités de " +product);
    }

}
