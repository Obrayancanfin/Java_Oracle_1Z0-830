package Exo_22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        CompletableFuture<Void> step1 = CompletableFuture.runAsync(()->{
            System.out.println("Étape 1 : Lecture des données");},executor);

        CompletableFuture<Void> step2 = step1.thenRunAsync(()->{
            System.out.println("Étape 2 : Traitment des données");},executor);

        CompletableFuture<Void> step3 = step2.thenRunAsync(()->{
            System.out.println("Étape 3 : Lecture des données");},executor);

        step3.join();
    }
}
