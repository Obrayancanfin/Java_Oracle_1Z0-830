import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Monster implements Serializable {
    private String name;
    private int force;
    private int health;
    static List<Monster> monsters ;

    public Monster(String name, int force, int health) {
        this.name = name;
        this.force = force;
        this.health = health;
    }

    public static void AddMonster() {
        Scanner scanner = new Scanner(System.in);
        List<String> infosCreation = Game.InfosCreation(scanner);
        Monster monster = new Monster(infosCreation.get(0),Integer.parseInt(infosCreation.get(1)),Integer.parseInt(infosCreation.get(2)));
    }

    @Override
    public String toString() {
        return "Monster : " +
                "name : " + name  +
                ", force : " + force +
                ", health : " + health ;
    }
}
