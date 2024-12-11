import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Math.floor;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader in = new FileReader("books_dataset.csv");
        BufferedReader br = new BufferedReader(in);
        List<Livre> livres = new ArrayList<>();
        try {
            br.readLine();
            while (br.ready()) {
                String line = br.readLine();
                Livre livre = Livre.parse(line);
                if (livre != null) {
                    livres.add(livre);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Livre disponible

//        livres.stream().filter(Livre::isDisponible).forEach(livre -> {
//            System.out.println(livre.toString());
//        });

        //Livre publié avant 1950

       // livres.stream().filter(livre -> livre.datePublication.getYear()<1950).forEach(System.out::println);

        //Livre groupé par genre

        //livres.stream().collect(Collectors.groupingBy(Livre::getGenre)).forEach((key, value) -> System.out.println(key + ": " + value));

        //Livre plus ancien

        //livres.stream().sorted(Comparator.comparing(Livre::getDatePublication)).limit(1).forEach(System.out::println);

        //Livre commandment par Harry

        //System.out.println(livres.stream().anyMatch(livre -> livre.getTitre().startsWith("Harry")));

        //livres.stream().filter(books -> books.getTitre().startsWith("Harry")).forEach(books -> System.out.println(books.getTitre()));

        //Calculer le prix moyen des livres disponibles dans la bibliothèque

        //System.out.printf("%.2f $", livres.stream().mapToDouble(Livre::getPrix).average().orElse(-1));

        //Trier les livre par nbr page puis par prix

//        livres.stream().sorted(Comparator.comparing(Livre::getNombrePages).thenComparing(Comparator.comparing(Livre::getPrix))).forEach(livre -> {
//            System.out.println(livre.getTitre()+ " - " +livre.getNombrePages() + " - " + livre.getPrix());
//        });

        //Calculer le total des pages pour tous les livres de genre "Fantasy".

        //System.out.println(livres.stream().filter(livre -> Objects.equals(livre.getGenre(), "Fantasy")).mapToInt(Livre::getNombrePages).sum());

        //Trouver le livre le plus cher disponible à la vente.

//        livres.stream().filter(livre -> livre.isDisponible()).sorted(Comparator.comparing(Livre::getPrix).reversed()).limit(1).forEach(livre -> {
//            System.out.println(livre.getTitre() + " - " + livre.getPrix()+" Dispo "+ livre.isDisponible());
//        });

        //Trouver les auteurs les plus prolifiques (les auteurs ayant écrit plus de 17 livre) et afficher leurs livres

//        livres.stream().collect(Collectors.groupingBy(Livre::getAuteur)).entrySet().stream().forEach(entry -> {
//            if (entry.getValue().size()>17){System.out.println(entry.getKey()+ ": " + entry.getValue().size());
//        }});

        //Compter le nombre de livres dans chaque genre (afficher par exemple combien de "Romans", combien de "Science-fiction", etc.).

//        livres.stream().collect(Collectors.groupingBy(Livre::getGenre)).entrySet().stream().forEach(entry -> {
//            {System.out.println(entry.getKey()+ ": " + entry.getValue().size());
//        }});

        //Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné, et afficher les livres correspondants.

        //25$

        //livres.stream().filter(livre -> livre.getPrix()<25).filter(Livre::isDisponible).forEach(livre -> {System.out.println(livre.getTitre());});;

        //Calculer le nombre total de pages pour les livres de chaque année.

        livres.stream().collect(Collectors.groupingBy(livre -> livre.getDatePublication().getYear())).forEach((key, value) -> System.out.println("Annee : " +key + " Nombre page : " + value.stream().mapToInt(Livre::getNombrePages).sum()));
    }
}


