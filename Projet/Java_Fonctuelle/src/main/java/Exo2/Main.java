package Exo2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IFilterInStock filter = produit -> produit.getQuantite()>0;
        IFilterName filterName= (produit, name) -> produit.getNom().contains(name);
        Produit produit1 = new Produit("Ananas" , 5 , 2 );
        Produit produit2 = new Produit("Poire" , 5 , 2 );
        Produit produit3 = new Produit("Pomme" , 5 , 0 );

        List<Produit> produits = new ArrayList<Produit>();
        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);

        System.out.println(produits.stream().filter(filter::filterStock).toList());

        System.out.println(produits.stream().filter( produit -> filterName.filterName(produit,"Ananas")).toList());

    }
}
