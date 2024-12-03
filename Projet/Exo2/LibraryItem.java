package Exo2;

import java.util.ArrayList;
import java.util.List;

public class LibraryItem {
    private static int id ;
    private static String title ;
    private static int publicationYear ;
    public static List<LibraryItem> getItems = new ArrayList<>();

    public LibraryItem(String title, int publicationYear) {
        id = getItems.size()+1 ;
        LibraryItem.title = title;
        LibraryItem.publicationYear = publicationYear;
        getItems.add(this);

    }

    public static int getPublicationYear() {
        return publicationYear;
    }

    public static void setPublicationYear(int publicationYear) {
        LibraryItem.publicationYear = publicationYear;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        LibraryItem.title = title;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        LibraryItem.id = id;
    }

    public static String getDetail(){
        return "id : " + id + "title : "+ title +"publication year :" + publicationYear;
    }

}
