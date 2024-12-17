package org.example.exo12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharedResource {
    static List<Integer> listShared = new ArrayList<>();
    Random r = new Random();


    public synchronized void removeIntegerList(){
            for (int i = 0; i < 5; i++) {
                if (listShared.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
                }else {
                int removeInteger = listShared.removeFirst();
                System.out.println(Thread.currentThread().getName()+" a supprimé "+removeInteger);
                }
            }
    }

    public synchronized void addIntegerList(){
        for (int i = 0; i < 5; i++) {
            listShared.add(i);
            System.out.println(Thread.currentThread().getName()+" a ajouté "+i);
        }
    }
}
