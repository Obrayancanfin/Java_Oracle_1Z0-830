package Exo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("""
                Add an object to library : 1 \n
                Shown all the objects in library available : 2 \n
                borrow an object from the library : 3 \n
                shown all the objects in library : 4 \n
                
                """);
        switch (choice) {
            case 1:
                System.out.println("Book or Magazine ?");
                String typeObject = scanner.nextLine();
                switch (typeObject) {
                    case "book":
                        System.out.println("Book or Magazine ?");
                    case "magazin":
                        System.out.println("Book or Magazine ?");
                    default:
                        System.out.println("Book or Magazine ?");
                }
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

        
    }
}
