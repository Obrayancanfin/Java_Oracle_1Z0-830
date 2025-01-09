import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    public static void Start(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                --- Welcome in this Textual Game ! ---
                1. Create a new character
                2. Load existed character
                3. Create a monster
                4. Quit
                Choose an option :\s""");
        String option = scanner.nextLine();

        switch (option) {
            case "1"->CreateCharacter(scanner);
            case "2"->ChooseCharacter(scanner);
            case "3"->CreateMonster(scanner);
            case "4"->Quit();
            default ->Start();
        }
    }

    private static void CreateCharacter(Scanner scan) {
        Character.AddCharacter();
    }

    private static void ChooseCharacter(Scanner scan) {
        System.out.println("Choose your character :");
        Character.ShowCharacter();
    }

    private static void CreateMonster(Scanner scan) {
        Monster.AddMonster();
    }


    static List<String> InfosCreation(Scanner scan){
        System.out.print("Name ? ");
        String name = scan.nextLine();
        System.out.print("Strength ? (1-100) ");
        int strength = scan.nextInt();
        scan.nextLine();
        System.out.print("Health ? (1-100) ");
        int health = scan.nextInt();
        return List.of(new String[]{name, String.valueOf(strength), String.valueOf(health)});
    }

    private static void Quit() {
        System.out.println("Bye ! ");
        System.exit(0);
    }

}

