import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class IHM {

    public static String JournalActivite = """
                --- Journal des Activités ---
                """;
    public static void ShowIHM(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                --- Menu ---
                1. Ajouter une activité
                2. Afficher les activités
                3. Sauvegarder en binaire
                4. Lire le fichier binaire
                5. Quitter
                Choisissez une option : """);
        String choice = scanner.nextLine();

        switch (choice){
            case "1" ->AddActivity();
            case "2" ->ShowActivity();
            case "3" ->SaveBinaryActivity();
            case "4" ->ReadBinaryFile();
            case "5" -> {
                break;
            }
            default -> ShowIHM();
        }
    }

    private static void ReadBinaryFile() {
    }

    private static void SaveBinaryActivity() {
    }

    private static void ShowActivity() {
        System.out.println(JournalActivite);
    }

    public static void AddActivity(){
        Scanner scanner = new Scanner(System.in);
        String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        System.out.print("Entrez une description de l'activité :");
        String activity = scanner.nextLine();
        String outputActivity = date+" : "+activity+"\n";
        JournalActivite = JournalActivite + outputActivity;
        System.out.println(JournalActivite);
        scanner.close();
        ShowIHM();
    }
}
