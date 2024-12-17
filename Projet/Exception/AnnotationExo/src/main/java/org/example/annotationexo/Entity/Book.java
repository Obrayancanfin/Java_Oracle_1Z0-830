package org.example.annotationexo.Entity;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class Book {
    public static List<Book> books = new ArrayList<Book>();

    String titre;
    String auteur;
    String genre;
    LocalDate datePublication;
    int nombrePages;
    boolean disponible;
    double prix;



    public Book(String titre, String auteur, String genre, LocalDate datePublication, int nombrePages, boolean disponible, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.datePublication = datePublication;
        this.nombrePages = nombrePages;
        this.disponible = disponible;
        this.prix = prix;

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public static Book parse(String string) {
        String[] split = string.split(",");
        String titre = split[0];
        String auteur = split[1];
        String genre = split[2];
        LocalDate datePublication = LocalDate.parse(split[3]);
        int nombrePages = Integer.parseInt(split[4]);
        boolean disponible = Boolean.parseBoolean(split[5]);
        double prix = Double.parseDouble(split[6]) ;
        try {
            return new Book(titre, auteur, genre, datePublication, nombrePages, disponible, prix);
        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Livre :" +
                "titre : " + titre + '\'' +
                ", auteur : " + auteur + '\'' +
                ", genre : " + genre + '\'' +
                ", datePublication :" + datePublication +
                ", nombrePages : " + nombrePages +
                ", disponible : " + disponible +
                ", prix : " + prix ;
    }
}
