package Stream.Exo_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );

        // Liste des commandes

        commandes.forEach(System.out::println);

        //Nom des clients

        commandes.forEach(commande -> System.out.println(commande.getClient()));

        // Total commande

        System.out.println(commandes.stream().mapToDouble(Commande::getMontantTotal).sum());

        //Article et prix de chaque commande

        commandes.forEach(commande1 -> System.out.println("Liste d'article"+commande1.getArticles() +" Prix : " +commande1.getMontantTotal()));

        //Liste commande livrée

        commandes.stream().filter(Commande::isEstLivree).forEach(System.out::println);

        //Total de la commande de chaque client

        commandes.stream().collect(Collectors.groupingBy(Commande::getClient)).forEach((k, v) -> {
            System.out.println(k + " "+ v.stream().mapToDouble(Commande::getMontantTotal).sum()+" $");
        });

        //Liste d'article

        System.out.println(commandes.stream().collect(Collectors.groupingBy(Commande::getArticles)).keySet().stream().flatMap(Collection::stream).collect(Collectors.toSet()));
        System.out.println(commandes.stream().flatMap(commande -> commande.getArticles().stream()).collect(Collectors.toSet()));

        //Tous les clients ont une commande livrée

            commandes.stream().collect(Collectors.groupingBy(Commande::getClient)).forEach((k, v) -> {

                System.out.println(v.stream().anyMatch(Commande::isEstLivree));
            });

    }
}
