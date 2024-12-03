package Exo1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Directory {
    public static List<Person> persons= new ArrayList();
    
        public static void addPerson(String nom , String numberPhone){
            Person person = new Person(nom, numberPhone);
            persons.add(person);
    }

    public static void showdirectory(){
        System.out.printf(""" 
                1.Ajouter contact
                2.Lister les contacts
                3.Trouver un contact
                4.Quitter

                Choisir une option :
                """ );

            Scanner scanner =new Scanner(System.in);
            String input = scanner.nextLine();
            while(true){
                switch (input) {
                    case "1":
                        String nom = scanner.nextLine();
                        String numberPhone = scanner.nextLine();
                        addPerson(nom, numberPhone);
                        break;
                    
                    case "2":
                    System.out.println("2");
                        break;

                    case "3":
                    System.out.println("3");
                        break;
                
                    default:
                        break;
                }break;
            }
            scanner.close();
        }
}