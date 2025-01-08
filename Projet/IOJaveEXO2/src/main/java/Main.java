import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\MARUT\\Desktop\\Java_Oracle_1Z0-830\\Projet\\IOJaveEXO2\\journal.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        IHM.ShowIHM();
    }
}
