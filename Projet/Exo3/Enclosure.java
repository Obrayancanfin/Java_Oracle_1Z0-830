import java.util.List;

public class Enclosure {
    private int id;
    private String name;
    private List<Animal> animals;

    public Enclosure(int id, String name, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.animals = animals;
        ZooManager.enclosurelist.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }


    public void removeAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("this animal dont exist !");
        } else {
            if (this.animals.remove(animal)) {
                System.out.println("this animal was removed !");
            } else {
                System.out.println("this animal dont be in this enclosure !");
            }
            ;
        }
    }
}
