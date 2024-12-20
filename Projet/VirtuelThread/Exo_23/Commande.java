package Exo_23;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Commande {
    List<Commande> listeCommune =  new ArrayList<>();
    UUID id ;
    List<Article> commande ;

    public Commande(List<Article> commande) {
        this.commande = commande;
        this.id = UUID.randomUUID();
        listeCommune.add(this);
    }

    public void addArticle(Article article){
        this.commande.add(article);
    }

    public void removeArticle(Article article){
        if (!this.commande.contains(article)){
            System.out.println("Cette commande ne contient pas cette article");
        }else {
            this.commande.remove(article);
        }

    }
}
