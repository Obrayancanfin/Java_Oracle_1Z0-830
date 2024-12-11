package Stream.Exo_1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Film {

    String titre;
    LocalDate date_de_sortie;
    String realisateur;
    String genre;
    long nbrEntree;

    public Film(String titre, LocalDate date_de_sortie, String realisateur, String genre, long nbrEntree) {
        this.titre = titre;
        this.date_de_sortie = date_de_sortie;
        this.realisateur = realisateur;
        this.genre = genre;
        this.nbrEntree = nbrEntree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDate_de_sortie() {
        return date_de_sortie;
    }

    public void setDate_de_sortie(LocalDate date_de_sortie) {
        this.date_de_sortie = date_de_sortie;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getNbrEntree() {
        return nbrEntree;
    }

    public void setNbrEntree(long nbrEntree) {
        this.nbrEntree = nbrEntree;
    }

    @Override
    public String toString() {
        return
                "titre='" + titre + '\'' +
                ", date_de_sortie :'" + date_de_sortie + '\'' +
                ", réalisateur : '" + realisateur + '\'' +
                ", genre : '" + genre + '\'' +
                ", nbrEntree :" + nbrEntree ;
    }


    public static Film parse(String string) {
        String[] split = string.split(",");
        String title = split[0];
        String dateString = split[1];
        String director = split[2];
        String genre = split[3];
        String nbEntryString = split[4];
        try {
            LocalDate date = LocalDate.parse(dateString);
            int nbEntry = Integer.parseInt(nbEntryString);
            return new Film(title, date, director, genre, nbEntry);
        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
