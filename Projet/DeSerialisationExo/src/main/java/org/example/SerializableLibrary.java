package org.example;

import java.io.*;

public class SerializableLibrary {

    //WIP

    public static void SerializationLibrary() {
        System.out.println("La sérialisation ....");
        Book book1  = new Book("Once upon a time","me");

        try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("book.ser"))){
            oos.writeObject(book1);
            System.out.println("Objet serialise ....");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void DeserializationLibrary() {
        System.out.println("La désérialisation ....");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"))){
            Book book = (Book) ois.readObject();
            System.out.println("Objet déserialise ...."+book);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
