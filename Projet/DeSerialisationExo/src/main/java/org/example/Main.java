package org.example;

public class Main {

    /*

    Exercice  : Sérialisation et Désérialisation
    Enoncé :
    Créez une classe Book sérialisable avec les champs title et author.
    Sérialisez une instance de Book dans un fichier nommé book.ser.
    Désérialisez l'objet depuis le fichier et affichez ses propriétés dans la console.

     */
    public static void main(String[] args) {
        SerializableBook.SerializationBook();
        SerializableBook.DeserializationBook();
    }

}
