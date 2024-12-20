package Exo_23;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

public class Utilisateur {
    UUID id ;
    String nom ;
    ConcurrentSkipListSet<Article> panier = new ConcurrentSkipListSet<>();

    public Utilisateur(String nom, ConcurrentSkipListSet<Article> panier) {
        this.nom = nom;
        this.panier = panier;
        this.id = UUID.randomUUID();
    }

    public ConcurrentSkipListSet<Article> getPanier() {
        return panier;
    }

    public void setPanier(ConcurrentSkipListSet<Article> panier) {
        this.panier = panier;
    }


}
