import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character implements Serializable {
    private String name;
    private int strenght;
    private int health;
    private static final String FILE_PATH = "characters.dat";
    

    public Character(String name, int strenght, int health) {
        this.name = name;
        this.strenght = strenght;
        this.health = health;

    }

    public static void AddCharacter(){
        Scanner scanner = new Scanner(System.in);
        List<String> infosCreation = Game.InfosCreation(scanner);
        Character character = new Character(infosCreation.get(0),Integer.parseInt(infosCreation.get(1)),Integer.parseInt(infosCreation.get(2)));
        SaveCharacter(character);
        Game.Start();
    }

    public static void ShowCharacter(){

            System.out.println("--- List of character ---\n");
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

    }

    private static void SaveCharacter (Character character)  {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(FILE_PATH,true)))   {
                out.write(String.valueOf(character).getBytes());
                out.write("\n".getBytes());
                System.out.println("Character is created and saved in binary file : "+ FILE_PATH);
            } catch (IOException e) {
            System.err.println(e);
        }
        }

    @Override
    public String toString() {
        return "Character : " +
                "name : " + name  +
                ", force : " + strenght +
                ", health : " + health ;
    }
}
