package Exo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Filter {

    public IFilterInStock inStock = (produit)  -> {
        return produit.getQuantite()>0;
    };

    IFilterName isNamed = (produit, name)  -> {
        return Objects.equals(produit.getNom(), name);
    };

//    public boolean inStock(Produit produit) {
//        return produit.getQuantite()>0;
//    }
}
