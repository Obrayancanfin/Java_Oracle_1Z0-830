package Entity;

import Factory.AnimalFactory;

public class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("meow");
    }
}
