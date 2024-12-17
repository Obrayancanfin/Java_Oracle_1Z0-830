import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner =new Scanner(System.in);

        // Entier
        /**

        while(true) {
            System.out.println("Entrer un chiffre: ");
            String chiffre = scanner.nextLine();
            try {
                chiffre = String.valueOf(Integer.parseInt(chiffre));
                break;
            } catch (Exception e ) {
         System.out.println("Entrer un chiffre");
         chiffre = scanner.nextLine();=
         }
        }
         */


        //Racine carré

        /**
        while(true){
            System.out.println("Entrer un chiffre: ");
            String chiffre = scanner.nextLine();
            try {
                String entree= chiffre;
                chiffre = String.valueOf(Math.sqrt(Integer.parseInt(chiffre)));
                System.out.println("La racine carré de "+ entree +" est " + chiffre);
                break;
            }
            catch(Exception e){

                System.out.println("Entrer un chiffre");
                chiffre = scanner.nextLine();

            }

         */

        //Tableau

        while(true){
            int[] chiffres ={1,2,3,4,5};
            String chiffreString;
            System.out.println("Veuillez entrer le chiffre :");
            chiffreString=scanner.nextLine();
            try {
                System.out.println(" Accés à l'element "+ chiffreString+"=> Élément récupéré : "+chiffres[Integer.parseInt(chiffreString)]);
                break;
            }catch (Exception e){
                System.out.println("Erreur : "+e.getMessage());

            }
        }

        }

    }
