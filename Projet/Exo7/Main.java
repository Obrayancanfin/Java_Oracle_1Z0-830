import Entity.Animal;
import Factory.AnimalFactory;
import Factory.CatFactory;
import Factory.DogFactory;

public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.sound();

    }
}
