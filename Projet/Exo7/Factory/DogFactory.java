package Factory;

import Entity.Animal;
import Entity.Dog;

public class DogFactory extends AnimalFactory{

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
