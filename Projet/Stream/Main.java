package Stream;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("films_with_genres 1.csv");
        BufferedReader br = new BufferedReader(in);
        List<Film> films = new ArrayList<>();
        try {
            br.readLine();
            while (br.ready()) {
                String line = br.readLine();
                Film film = Film.parse(line);
                if (film != null) {
                    films.add(film);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Lecture :");
        System.out.println(" ");

        System.out.println("10 premiers films");
        //films.stream().limit(10).forEach(s -> System.out.println("film : "+ s));
        System.out.println("tous les films");

        //films.forEach(s-> System.out.println("film : "+ s ));

        System.out.println("Filtrage :");
        System.out.println(" ");

        System.out.println("Film d'actions :");
        System.out.println(" ");

        //films.stream().filter(s -> Objects.equals(s.getGenre(), "Action")).forEach(s -> System.out.println("films d'action: "+ "titre : "+ s.titre +" , "+" annee de sortie : "+s.date_de_sortie));

        System.out.println("Les film post annee 2000 :");
        System.out.println(" ");

        //films.stream().sorted(Comparator.comparing(Film::getDate_de_sortie)).filter(film -> film.getDate_de_sortie().getYear() >2000).forEach(film -> System.out.println("film : "+ film.getTitre()));

        System.out.println("Film auteur specifique");


        //films.stream().filter(film -> film.getRealisateur() =="Michael Webster").forEach(s -> System.out.println("film : "+ s));

        System.out.println("Tri et limitation :");
        System.out.println(" ");

        System.out.println("Les cinq films avec le plus d'entrées :");
        System.out.println(" ");

        //films.stream().sorted(Comparator.comparingInt(Film::getNbrEntree).reversed()).limit(5).forEach(s -> System.out.println("film : "+ s));

        System.out.println("Film du plus recent au plus ancien :");
        System.out.println(" ");

        //films.stream().sorted(Comparator.comparing(Film::getDate_de_sortie).reversed()).forEach(s -> System.out.println("film : "+ s.getTitre() + "Date de sortie "+ s.getDate_de_sortie()));

        System.out.println("Les 10 films avec le moins d'entres :");
        System.out.println(" ");

        //films.stream().sorted(Comparator.comparing(Film::getNbrEntree)).limit(10).forEach(s -> System.out.println("film : "+ s));

        System.out.println("Regroupement avec Stream:");
        System.out.println(" ");

        System.out.println("Regrouper par genre et afficher nombre total d'entrée :");
        System.out.println(" ");

        //films.stream().collect(Collectors.groupingBy(Film::getGenre)).forEach((s, films1) -> System.out.println("genre : "+ s + " nombre de film : " + films1.size()));

        System.out.println("Regroupez les film par réalisateur : ");
        System.out.println(" ");

        //films.stream().collect(Collectors.groupingBy(Film::getRealisateur)).forEach((director, filmsByDirector) -> {System.out.println("Realisateur : " + director);String titles = filmsByDirector.stream().map(Film::getTitre).collect(Collectors.joining(", "));System.out.println("Liste de films : " + titles);});

        System.out.println("Calculs avec Stream : ");
        System.out.println(" ");

        System.out.println("Somme entrées :");
        System.out.println(" ");

//        long sum = films.stream().mapToLong(Film::getNbrEntree).sum();
//        System.out.println(sum);

        System.out.println("Le genre avec le plus de film :");
        System.out.println(" ");

        //System.out.println(films.stream().collect(Collectors.groupingBy(Film::getGenre, Collectors.summingLong(Film::getNbrEntree))).entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null));

        System.out.println("Moyenne entree pour un realisateur donne :");

//        OptionalDouble moyen = films.stream().filter(film -> Objects.equals(film.getRealisateur(), "Michael Webster")).mapToLong(Film::getNbrEntree).average();
//
//        if (moyen.isPresent()) {
//            System.out.println("La moyenne est de "+moyen.getAsDouble());
//        }

        System.out.println("Transformation avec Stream : ");
        System.out.println(" ");

//        films.stream().forEach(film -> System.out.println(film.getTitre() +" ( "+film.getGenre()+" )"+" - "+film.realisateur +" en "+ film.getDate_de_sortie().getDayOfMonth() +' '+ film.getDate_de_sortie().getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE) +' '+ film.getDate_de_sortie().getYear()));

        System.out.println("Liste des genres : ");
        System.out.println(" ");

//        films.stream().collect(Collectors.groupingBy(Film::getGenre)).forEach((genre, genres) -> { System.out.println(genre); });


        System.out.println("Premier film de chaque genre");
        System.out.println(" ");

        //films.stream().collect(Collectors.groupingBy(Film::getGenre)).forEach((s, films1) -> System.out.println("Genre : " + s +" premier film : "+ films1.stream().sorted(Comparator.comparing(Film::getDate_de_sortie)).limit(1).toList()));

        System.out.println("Liste des réalisateurs ayant réalisé plus de 50 films ");
        System.out.println(" ");

//        films.stream().collect(Collectors.groupingBy(Film::getRealisateur)).entrySet().stream().filter(stringListEntry -> stringListEntry.getValue().size() > 50).forEach(stringListEntry -> {
//            System.out.println( stringListEntry.getKey() +" nombre de films : "+stringListEntry.getValue().size());
//        });
//

        System.out.println("nombre total d’entrées pour les films sortis entre deux années données (par exemple : 1990 et 2000).");
        System.out.println(" ");

        films.stream().filter(film -> 1990<film.getDate_de_sortie().getYear() && film.getDate_de_sortie().getYear()<2000 ).mapToLong(value -> value.getNbrEntree()).sum();
    }
}


//.getDisplayName(TextStyle.FULL, Locale.FRANCE) mois en français