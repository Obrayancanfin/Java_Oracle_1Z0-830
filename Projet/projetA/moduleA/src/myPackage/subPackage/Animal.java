package projetA.moduleA.src.myPackage.subPackage;

public class Animal {

    private String name;
    private String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", species='" + species + '\'' + '}';
    }
}
