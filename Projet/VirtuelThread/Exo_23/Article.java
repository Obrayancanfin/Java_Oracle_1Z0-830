package Exo_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Article {
    static Article voiture= new Article(UUID.randomUUID(),"Voiture",12);
    static Article poupee= new Article(UUID.randomUUID(),"Poupee",15);
    static Article robot= new Article(UUID.randomUUID(),"Robot",30);
    static Article train= new Article(UUID.randomUUID(),"Train",30);
    static List<Article> catalogueInitial =new ArrayList<>(Arrays.asList(voiture, poupee,robot,train));

    UUID id;
    String nom;
    int prix;

    public Article(UUID id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom + " a " + prix +" $" ;
    }
}
